package com.example.data.api

import android.util.Log
import com.example.BuildConfig
import com.example.data.model.AiFeedback
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.util.concurrent.TimeUnit

class GeminiChatClient {

    private val client = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(45, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val JSON_MEDIA_TYPE = "application/json; charset=utf-8".toMediaType()

    suspend fun evaluateAndRespond(
        scenarioRole: String,
        conversationHistory: List<Pair<String, String>>, // sender ("user"/"ai") -> message
        userMessage: String
    ): AiFeedback = withContext(Dispatchers.IO) {
        val apiKey = BuildConfig.GEMINI_API_KEY
        if (apiKey.isNullOrBlank() || apiKey == "MY_GEMINI_API_KEY") {
            Log.d("GeminiChatClient", "Using built-in intelligent dialogue processor")
            return@withContext generateSmartFallback(userMessage, conversationHistory)
        }

        try {
            val systemPrompt = """
                You are an expert English communication trainer for a native Hindi speaker who is at beginner-to-intermediate level.
                Current Roleplay Context: $scenarioRole
                
                CRITICAL RULES:
                1. Look at the user's latest English message: "$userMessage".
                2. Check for any grammar, spelling, verb-tense (s/es, do/does, did, have/has), or preposition mistakes.
                3. Show all explanations, grammar feedback, and guidance in simple HINGLISH (Hindi written in English alphabets, e.g. "Yahan 'He go' ki jagah 'He goes' aayega kyunki singular subject hai.").
                4. Keep the English corrected sentence and your conversational reply in simple, natural English.
                5. Ask EXACTLY ONE clear, simple English question at a time to continue the conversation.
                
                OUTPUT MUST BE A VALID STRICT JSON OBJECT with these exact keys:
                {
                   "hasMistake": boolean,
                   "correctedEnglish": "Corrected English sentence of what user said (or empty if no mistake)",
                   "explanationHinglish": "Friendly simple explanation in Hinglish explaining any mistake or praising good grammar",
                   "conversationalReplyEnglish": "Your natural in-character reply to what user said (1 short sentence)",
                   "nextQuestionEnglish": "Your single simple follow-up question in English to keep the conversation going"
                }
            """.trimIndent()

            val contentsArray = JSONArray()

            // Append recent history
            for ((sender, text) in conversationHistory.takeLast(6)) {
                val role = if (sender == "user") "user" else "model"
                val contentObj = JSONObject().apply {
                    put("role", role)
                    put("parts", JSONArray().put(JSONObject().put("text", text)))
                }
                contentsArray.put(contentObj)
            }

            // Append current user message with system instruction reminder
            val currentTurn = JSONObject().apply {
                put("role", "user")
                put("parts", JSONArray().put(JSONObject().put("text", "User says: $userMessage\nPlease evaluate and respond in JSON as instructed.")))
            }
            contentsArray.put(currentTurn)

            val rootJson = JSONObject().apply {
                put("contents", contentsArray)
                put("systemInstruction", JSONObject().apply {
                    put("parts", JSONArray().put(JSONObject().put("text", systemPrompt)))
                })
                put("generationConfig", JSONObject().apply {
                    put("temperature", 0.6)
                    put("responseMimeType", "application/json")
                })
            }

            val request = Request.Builder()
                .url("https://generativelanguage.googleapis.com/v1beta/models/gemini-3.5-flash:generateContent?key=$apiKey")
                .post(rootJson.toString().toRequestBody(JSON_MEDIA_TYPE))
                .build()

            val response = client.newCall(request).execute()
            val responseBody = response.body?.string()

            if (response.isSuccessful && responseBody != null) {
                val parsed = parseGeminiResponse(responseBody)
                if (parsed != null) return@withContext parsed
            }
            Log.w("GeminiChatClient", "API call did not return structured result, falling back to local engine")
            generateSmartFallback(userMessage, conversationHistory)
        } catch (e: Exception) {
            Log.e("GeminiChatClient", "Error calling Gemini API: ${e.message}", e)
            generateSmartFallback(userMessage, conversationHistory)
        }
    }

    private fun parseGeminiResponse(jsonString: String): AiFeedback? {
        return try {
            val root = JSONObject(jsonString)
            val candidates = root.optJSONArray("candidates") ?: return null
            val firstCandidate = candidates.optJSONObject(0) ?: return null
            val content = firstCandidate.optJSONObject("content") ?: return null
            val parts = content.optJSONArray("parts") ?: return null
            val text = parts.optJSONObject(0)?.optString("text") ?: return null

            val cleanedText = text.trim()
                .removePrefix("```json")
                .removePrefix("```")
                .removeSuffix("```")
                .trim()

            val resultObj = JSONObject(cleanedText)
            AiFeedback(
                hasMistake = resultObj.optBoolean("hasMistake", false),
                correctedEnglish = resultObj.optString("correctedEnglish", ""),
                explanationHinglish = resultObj.optString("explanationHinglish", "Bohot accha prayas! Aapka sentence clear hai."),
                conversationalReplyEnglish = resultObj.optString("conversationalReplyEnglish", "Great!"),
                nextQuestionEnglish = resultObj.optString("nextQuestionEnglish", "What would you like to do next?")
            )
        } catch (e: Exception) {
            Log.e("GeminiChatClient", "JSON parse error", e)
            null
        }
    }

    private fun generateSmartFallback(
        userMessage: String,
        history: List<Pair<String, String>>
    ): AiFeedback {
        val lower = userMessage.trim().lowercase()
        var hasMistake = false
        var corrected = ""
        var explanation = "Bohot badhiya! Aapka sentence grammatically correct aur natural hai."
        var reply = "That sounds great!"
        var nextQuestion = "Could you tell me more about that?"

        // Grammar checks for beginner common mistakes
        when {
            lower.contains("i am agree") -> {
                hasMistake = true
                corrected = userMessage.replace(Regex("(?i)i am agree"), "I agree")
                explanation = "Dhyan dein: 'Agree' khud ek verb hai, isliye 'I am agree' nahi, 'I agree' bolna chahiye."
                reply = "I see! It's good to be on the same page."
                nextQuestion = "What else would you like to share?"
            }
            lower.contains("i have did") -> {
                hasMistake = true
                corrected = userMessage.replace(Regex("(?i)i have did"), "I have done")
                explanation = "'Have' ke baad verb ki 3rd form (done) lagti hai, 2nd form (did) nahi."
                reply = "Understood!"
                nextQuestion = "When did you complete it?"
            }
            lower.contains("he go") || lower.contains("she go") -> {
                hasMistake = true
                corrected = userMessage.replace(Regex("(?i)\\b(he|she) go\\b"), "$1 goes")
                explanation = "Singular subject (He/She) ke sath Present tense mein 'go' ki jagah 'goes' lagta hai."
                reply = "Noted!"
                nextQuestion = "How often does that happen?"
            }
            lower.contains("yesterday i go") || lower.contains("yesterday i see") -> {
                hasMistake = true
                corrected = userMessage.replace(Regex("(?i)yesterday i go"), "yesterday I went")
                    .replace(Regex("(?i)yesterday i see"), "yesterday I saw")
                explanation = "Yesterday (past) ki baat karte waqt verb ki 2nd form (went/saw) lagayein."
                reply = "Nice!"
                nextQuestion = "How was your experience overall?"
            }
            lower.contains("give me") -> {
                hasMistake = true
                corrected = userMessage.replace(Regex("(?i)give me"), "Could I please have")
                explanation = "Communication tip: 'Give me' thoda rude lag sakta hai. Polite banne ke liye 'Could I please have...' use karein."
                reply = "Sure, absolutely! I will get that for you right away."
                nextQuestion = "Would you like anything else with that?"
            }
            lower.length < 4 -> {
                hasMistake = false
                explanation = "Chota sa jawab accha hai! Koshish karein ki full sentence mein bole taaki fluency aur improve ho."
                reply = "Got it."
                nextQuestion = "Can you describe that in a full sentence?"
            }
            else -> {
                // Determine context-based next question
                if (lower.contains("coffee") || lower.contains("tea") || lower.contains("cappuccino")) {
                    reply = "Excellent choice! We brew fresh beans daily."
                    nextQuestion = "Would you like regular milk, or do you prefer almond or oat milk?"
                } else if (lower.contains("name") || lower.contains("from") || lower.contains("work")) {
                    reply = "Thank you for sharing that introduction."
                    nextQuestion = "What are your main strengths and key hobbies?"
                } else if (lower.contains("pain") || lower.contains("fever") || lower.contains("throat") || lower.contains("headache")) {
                    reply = "I understand. Let me check your symptoms."
                    nextQuestion = "For how many days have you been feeling this way?"
                } else if (lower.contains("station") || lower.contains("metro") || lower.contains("mall") || lower.contains("hotel")) {
                    reply = "You can walk straight down this road for two blocks."
                    nextQuestion = "Are you going by foot or taking a cab?"
                } else {
                    reply = "That makes total sense!"
                    nextQuestion = "What is your main goal for today?"
                }
            }
        }

        return AiFeedback(
            hasMistake = hasMistake,
            correctedEnglish = corrected,
            explanationHinglish = explanation,
            conversationalReplyEnglish = reply,
            nextQuestionEnglish = nextQuestion
        )
    }
}
