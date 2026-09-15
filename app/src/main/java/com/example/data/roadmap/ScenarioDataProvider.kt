package com.example.data.roadmap

import com.example.data.model.ConversationScenario

object ScenarioDataProvider {

    val scenarios: List<ConversationScenario> = listOf(
        ConversationScenario(
            id = "cafe_order",
            title = "At a Coffee Shop",
            titleHinglish = "Cafe mein coffee aur snacks order karna",
            iconEmoji = "☕",
            level = "Beginner",
            contextHinglish = "Aap ek modern cafe mein hain aur barista aapse order lene ke liye pooch raha hai. Simple polite English mein reply kijiye.",
            initialAiMessage = "Hello! Welcome to Cafe Mocha. What can I get for you today?",
            systemPromptRole = "You are a friendly, patient barista at Cafe Mocha. The user is a Hindi native speaker learning English. Ask ONE simple English question at a time. After they reply, evaluate their English carefully, correct any grammar/vocabulary mistakes in simple warm Hinglish, and then ask the next logical English question.",
            suggestedStarterReplies = listOf(
                "Hi, I would like a hot coffee please.",
                "Can I get a cappuccino?",
                "Do you have cold coffee?"
            )
        ),
        ConversationScenario(
            id = "job_interview",
            title = "Job Interview Self-Intro",
            titleHinglish = "Job interview mein confidence se introduction dena",
            iconEmoji = "💼",
            level = "Intermediate",
            contextHinglish = "Interviewer aapse simple professional questions pooch raha hai. Apne baare mein, experience aur career goals simple clear English mein bataiye.",
            initialAiMessage = "Good morning! Please have a seat. To start off, could you tell me a little bit about yourself?",
            systemPromptRole = "You are a warm, encouraging job interviewer. Ask ONE simple professional question at a time. When user replies in English, check their grammar, highlight any mistake with explanation in simple Hinglish, and ask the next interview question.",
            suggestedStarterReplies = listOf(
                "Good morning! My name is Rahul and I am from Mumbai.",
                "Thank you for this opportunity. I am a fresh graduate.",
                "Hi, I have 1 year of experience in sales."
            )
        ),
        ConversationScenario(
            id = "asking_directions",
            title = "Asking for Directions",
            titleHinglish = "Naye shahar mein raasta poochna",
            iconEmoji = "🗺️",
            level = "Beginner",
            contextHinglish = "Aap naye city mein hain aur metro station ya hotel ka raasta pooch rahe hain.",
            initialAiMessage = "Hello there! You look like you are searching for something. Can I help you with directions?",
            systemPromptRole = "You are a helpful local passerby in a city. Speak simple clear English. Ask one question at a time, check user's reply, give Hinglish feedback, and continue the conversation.",
            suggestedStarterReplies = listOf(
                "Excuse me, where is the nearest metro station?",
                "Hi, could you tell me how to reach Central Mall?",
                "Is there an ATM nearby?"
            )
        ),
        ConversationScenario(
            id = "doctor_visit",
            title = "Visiting the Doctor",
            titleHinglish = "Doctor ko bimari aur symptoms batana",
            iconEmoji = "🩺",
            level = "Beginner-Intermediate",
            contextHinglish = "Aap clinic mein hain aur doctor aapse aapki tabiyat aur takleef ke baare mein pooch raha hai.",
            initialAiMessage = "Good afternoon! Please sit down. How can I help you today? What symptoms are you experiencing?",
            systemPromptRole = "You are a gentle, attentive doctor at a clinic. Ask ONE simple question at a time about symptoms, evaluate the user's English sentences, explain any corrections in simple Hinglish, and ask the next symptom/history question.",
            suggestedStarterReplies = listOf(
                "Doctor, I have had a severe fever since yesterday.",
                "I have a sore throat and body pain.",
                "I am feeling dizzy and tired."
            )
        ),
        ConversationScenario(
            id = "daily_smalltalk",
            title = "Daily Chit-Chat with a Friend",
            titleHinglish = "Dost se weekend aur routine par aam baatcheet",
            iconEmoji = "🌟",
            level = "Beginner",
            contextHinglish = "Aapka dost aapse mil kar haalchaal aur weekend plans ke baare mein pooch raha hai.",
            initialAiMessage = "Hey! How have you been? What did you do last weekend?",
            systemPromptRole = "You are a friendly close pal. Speak casual, conversational English. Ask ONE simple question at a time, review their English sentence, explain in simple friendly Hinglish, and keep the chat rolling.",
            suggestedStarterReplies = listOf(
                "Hey! I was at home watching a movie.",
                "I went to the market with my family.",
                "I had a very relaxing weekend, how about you?"
            )
        )
    )
}
