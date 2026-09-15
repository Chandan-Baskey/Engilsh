package com.example.data.roadmap

import com.example.data.model.MakeQuestionExercise
import com.example.data.model.PositiveToNegativeExercise
import com.example.data.model.QuickQaExercise
import com.example.data.model.SentenceBuildExercise
import com.example.data.model.TranslationExercise

object PracticeDataProvider {

    // MODE 1: Hinglish-to-English Translation
    val translationExercises: List<TranslationExercise> = listOf(
        TranslationExercise(
            id = 1,
            hinglishPrompt = "Main kal office nahi aa paunga.",
            acceptableEnglishAnswers = listOf(
                "I will not be able to come to office tomorrow.",
                "I will not be able to come to the office tomorrow.",
                "I won't be able to come to office tomorrow.",
                "I cannot come to office tomorrow.",
                "I won't be able to come to the office tomorrow."
            ),
            hintHinglish = "'Nahi aa paunga' ke liye 'will not be able to come' use karein.",
            explanationHinglish = "Future ability ke liye 'will be able to' use hota hai. Iska negative 'will not be able to come to office tomorrow' hai.",
            keyVocabulary = listOf("Office" to "Karyalaya / Daftar", "Tomorrow" to "Kal (aane waala)", "Be able to" to "Samarth hona")
        ),
        TranslationExercise(
            id = 2,
            hinglishPrompt = "Kya aap kripya thoda dhire bol sakte hain?",
            acceptableEnglishAnswers = listOf(
                "Could you please speak slowly?",
                "Can you please speak slowly?",
                "Could you speak slowly please?",
                "Please speak slowly.",
                "Could you speak a little slowly please?"
            ),
            hintHinglish = "Polite request ke liye 'Could you please...' se shuru karein.",
            explanationHinglish = "Kisi se polite request karte waqt 'Could you please speak slowly?' sabse natural aur respectful tareeqa hai.",
            keyVocabulary = listOf("Please" to "Kripya", "Speak" to "Bolna", "Slowly" to "Dhire")
        ),
        TranslationExercise(
            id = 3,
            hinglishPrompt = "Mujhe samajh nahi aaya, kya aap dohra sakte hain?",
            acceptableEnglishAnswers = listOf(
                "I did not understand, could you please repeat?",
                "I didn't understand, could you repeat that?",
                "I didn't understand, can you repeat?",
                "I didn't get it, could you please repeat that?",
                "I didn't understand, could you please repeat that?"
            ),
            hintHinglish = "'Mujhe samajh nahi aaya' = 'I did not understand'.",
            explanationHinglish = "'Did not understand' (V1) lagta hai. Baat ko repeat karane ke liye 'Could you please repeat that?' bolte hain.",
            keyVocabulary = listOf("Understand" to "Samajhna", "Repeat" to "Dohrana")
        ),
        TranslationExercise(
            id = 4,
            hinglishPrompt = "Wo pichle do ghante se padh rahi hai.",
            acceptableEnglishAnswers = listOf(
                "She has been studying for two hours.",
                "She has been studying for the last two hours.",
                "She is studying for two hours.",
                "She has been studying for past two hours."
            ),
            hintHinglish = "Past se abhi tak chal rahe kaam ke liye 'has been + V-ing' aur duration ke liye 'for' lagta hai.",
            explanationHinglish = "Present Perfect Continuous: 'She has been studying for two hours.' Yahan time duration hai isliye 'for' aaya.",
            keyVocabulary = listOf("Studying" to "Padhai karna", "Two hours" to "Do ghante")
        ),
        TranslationExercise(
            id = 5,
            hinglishPrompt = "Maine abhi-abhi apna lunch khatam kiya hai.",
            acceptableEnglishAnswers = listOf(
                "I have just finished my lunch.",
                "I just finished my lunch.",
                "I have just completed my lunch."
            ),
            hintHinglish = "'Abhi-abhi' ke liye 'just' aur 'have + V3' use karein.",
            explanationHinglish = "Present Perfect: 'I have just finished my lunch.' Finished V3 form hai.",
            keyVocabulary = listOf("Just" to "Abhi-abhi", "Finished" to "Khatam kiya", "Lunch" to "Dopahar ka khana")
        )
    )

    // MODE 2: Quick Q & A
    val quickQaExercises: List<QuickQaExercise> = listOf(
        QuickQaExercise(
            id = 1,
            situationHinglish = "Aap kisi naye colleague ya dost se pehli baar mil rahe hain.",
            aiQuestionEnglish = "Hi! Nice to meet you. What do you do for a living?",
            acceptableEnglishReplies = listOf(
                "I am a software engineer.",
                "I work as a software engineer.",
                "I am a student.",
                "I work in marketing.",
                "I am working in IT."
            ),
            sampleGoodAnswers = listOf(
                "I am a software engineer at a tech firm.",
                "I work as a graphic designer.",
                "I am currently studying computer science."
            ),
            hintHinglish = "Apna profession batane ke liye 'I am a [profession]' ya 'I work as a [role]' bole.",
            explanationHinglish = "'What do you do for a living?' ka matlab hai 'Aap kya kaam karte hain?'. Jawab 'I am a...' ya 'I work at...' se diya jata hai."
        ),
        QuickQaExercise(
            id = 2,
            situationHinglish = "Office mein aapka manager aapke project ke status ke baare mein pooch raha hai.",
            aiQuestionEnglish = "Have you finished the report that was due today?",
            acceptableEnglishReplies = listOf(
                "Yes, I have finished it.",
                "Yes, I sent it already.",
                "No, I am still working on it.",
                "I will finish it in an hour.",
                "Yes, I have completed it."
            ),
            sampleGoodAnswers = listOf(
                "Yes, I have already emailed it to you.",
                "Almost done, I will share it by 4 PM.",
                "Yes, I completed it this morning."
            ),
            hintHinglish = "Agar pura ho gaya to 'Yes, I have completed it' bole, agar thoda baaki hai to 'Almost done' bole.",
            explanationHinglish = "Sawal 'Have you finished' se hai, isliye answer 'Yes, I have finished it' ya 'Almost done' hoga."
        ),
        QuickQaExercise(
            id = 3,
            situationHinglish = "Restaurant mein waiter aapke paas aata hai.",
            aiQuestionEnglish = "Are you ready to order, or do you need a few more minutes?",
            acceptableEnglishReplies = listOf(
                "I am ready to order.",
                "We are ready to order.",
                "Please give us two more minutes.",
                "I need a few more minutes please.",
                "Yes, I'd like a pasta please."
            ),
            sampleGoodAnswers = listOf(
                "We are ready to order, thank you.",
                "Could you give us 5 more minutes, please?",
                "Yes, I would like to order a sandwich."
            ),
            hintHinglish = "Agar taiyar hain to 'We are ready to order', warna 'Give us a few minutes please'.",
            explanationHinglish = "Polite restaurant interaction mein 'I'm ready to order' ya 'Could you give us a few minutes' bolte hain."
        ),
        QuickQaExercise(
            id = 4,
            situationHinglish = "Interview mein interviewer aapse weekend ya hobbies ke baare mein poochta hai.",
            aiQuestionEnglish = "How do you like to spend your free time on weekends?",
            acceptableEnglishReplies = listOf(
                "I like to read books.",
                "I enjoy playing cricket with my friends.",
                "I like listening to music and watching movies.",
                "I spend time with my family.",
                "I like to travel and explore new places."
            ),
            sampleGoodAnswers = listOf(
                "I love reading books and listening to podcasts.",
                "I usually play cricket and spend time with my family.",
                "I enjoy cooking and exploring new places."
            ),
            hintHinglish = "'I like to [verb]...' ya 'I enjoy [verb-ing]...' ka use karein.",
            explanationHinglish = "Hobbies batate waqt 'I like to read' ya 'I enjoy playing' simple present structure sabse best hai."
        )
    )

    // MODE 3: Sentence Building (Jumbled Words)
    val sentenceBuildExercises: List<SentenceBuildExercise> = listOf(
        SentenceBuildExercise(
            id = 1,
            hinglishMeaning = "Main roz subah chai peeta hoon.",
            correctSentenceEnglish = "I drink tea every morning",
            jumbledWords = listOf("tea", "every", "I", "morning", "drink"),
            explanationHinglish = "S-V-O Structure: Subject (I) + Verb (drink) + Object (tea) + Time phrase (every morning)."
        ),
        SentenceBuildExercise(
            id = 2,
            hinglishMeaning = "Kya aap kripya meri madad kar sakte hain?",
            correctSentenceEnglish = "Could you please help me",
            jumbledWords = listOf("please", "me", "Could", "help", "you"),
            explanationHinglish = "Polite Question Structure: Could + Subject (you) + please + Verb (help) + Object (me)?"
        ),
        SentenceBuildExercise(
            id = 3,
            hinglishMeaning = "Usne kal ek naya laptop khareeda.",
            correctSentenceEnglish = "She bought a new laptop yesterday",
            jumbledWords = listOf("laptop", "bought", "yesterday", "She", "new", "a"),
            explanationHinglish = "Subject (She) + Past Verb (bought) + Object (a new laptop) + Time (yesterday)."
        ),
        SentenceBuildExercise(
            id = 4,
            hinglishMeaning = "Hum kal shaam ko aapse milenge.",
            correctSentenceEnglish = "We will meet you tomorrow evening",
            jumbledWords = listOf("evening", "will", "meet", "We", "tomorrow", "you"),
            explanationHinglish = "Subject (We) + Future modal (will) + Verb (meet) + Object (you) + Time (tomorrow evening)."
        ),
        SentenceBuildExercise(
            id = 5,
            hinglishMeaning = "Wo pichle paanch saal se yahan kaam kar raha hai.",
            correctSentenceEnglish = "He has been working here for five years",
            jumbledWords = listOf("here", "He", "working", "five", "has", "for", "been", "years"),
            explanationHinglish = "Subject (He) + has been + V-ing (working) + place (here) + duration (for five years)."
        )
    )

    // MODE 4: Positive to Negative
    val positiveToNegativeExercises: List<PositiveToNegativeExercise> = listOf(
        PositiveToNegativeExercise(
            id = 1,
            positiveSentenceEnglish = "She likes coffee.",
            hinglishMeaning = "Wo coffee pasand karti hai -> Wo coffee pasand nahi karti hai.",
            correctNegativeSentence = "She does not like coffee.",
            alternateNegatives = listOf("She doesn't like coffee.", "She does not like coffee"),
            grammarRuleHinglish = "'She' ke sath negative banane ke liye 'does not' lagta hai aur 'likes' ka 's' hat kar original 'like' ban jata hai."
        ),
        PositiveToNegativeExercise(
            id = 2,
            positiveSentenceEnglish = "I understand what you are saying.",
            hinglishMeaning = "Main samajhta hoon jo aap keh rahe hain -> Main nahi samajhta...",
            correctNegativeSentence = "I do not understand what you are saying.",
            alternateNegatives = listOf("I don't understand what you are saying.", "I do not understand what you are saying"),
            grammarRuleHinglish = "'I' ke sath 'do not' use hota hai aur verb original form mein rehti hai."
        ),
        PositiveToNegativeExercise(
            id = 3,
            positiveSentenceEnglish = "He went to office yesterday.",
            hinglishMeaning = "Wo kal office gaya tha -> Wo kal office nahi gaya tha.",
            correctNegativeSentence = "He did not go to office yesterday.",
            alternateNegatives = listOf("He didn't go to office yesterday.", "He did not go to the office yesterday.", "He didn't go to the office yesterday."),
            grammarRuleHinglish = "Past mein negative ke liye 'did not' lagte hi 2nd form 'went' badal kar 1st form 'go' ban jaati hai!"
        ),
        PositiveToNegativeExercise(
            id = 4,
            positiveSentenceEnglish = "They are ready for the meeting.",
            hinglishMeaning = "Wo meeting ke liye taiyar hain -> Wo meeting ke liye taiyar nahi hain.",
            correctNegativeSentence = "They are not ready for the meeting.",
            alternateNegatives = listOf("They aren't ready for the meeting.", "They are not ready for the meeting"),
            grammarRuleHinglish = "Be-verb 'are' ke turant baad 'not' lagaya jata hai."
        ),
        PositiveToNegativeExercise(
            id = 5,
            positiveSentenceEnglish = "You should drive fast in heavy rain.",
            hinglishMeaning = "Aapko tez barish mein tez chalani chahiye -> Nahi chalani chahiye.",
            correctNegativeSentence = "You should not drive fast in heavy rain.",
            alternateNegatives = listOf("You shouldn't drive fast in heavy rain.", "You should not drive fast in heavy rain"),
            grammarRuleHinglish = "Modal verb 'should' ke baad 'not' lagta hai: 'should not'."
        )
    )

    // MODE 5: Make a Question
    val makeQuestionExercises: List<MakeQuestionExercise> = listOf(
        MakeQuestionExercise(
            id = 1,
            statementEnglish = "You live in Mumbai.",
            targetType = "Yes/No Question",
            promptHinglish = "Sawal banayein: 'Kya aap Mumbai mein rehte hain?'",
            correctQuestionEnglish = "Do you live in Mumbai?",
            acceptableQuestions = listOf("Do you live in Mumbai?", "Do you live in Mumbai"),
            grammarRuleHinglish = "Present simple mein 'You' se Yes/No question banane ke liye shuruat mein 'Do' lagayein: Do + you + live in Mumbai?"
        ),
        MakeQuestionExercise(
            id = 2,
            statementEnglish = "He works in a bank.",
            targetType = "Wh- Question (Where)",
            promptHinglish = "Sawal banayein: 'Wo kahan kaam karta hai?'",
            correctQuestionEnglish = "Where does he work?",
            acceptableQuestions = listOf("Where does he work?", "Where does he work"),
            grammarRuleHinglish = "Wh-word (Where) + helping verb (does) + subject (he) + original verb (work)?"
        ),
        MakeQuestionExercise(
            id = 3,
            statementEnglish = "She called you yesterday.",
            targetType = "Yes/No Past Question",
            promptHinglish = "Sawal banayein: 'Kya usne kal tumhe call kiya tha?'",
            correctQuestionEnglish = "Did she call you yesterday?",
            acceptableQuestions = listOf("Did she call you yesterday?", "Did she call you yesterday"),
            grammarRuleHinglish = "Past question ke liye 'Did' aage aayega aur 'called' badal kar 'call' (V1) ban jayega: Did + she + call...?"
        ),
        MakeQuestionExercise(
            id = 4,
            statementEnglish = "The train arrives at 10 PM.",
            targetType = "Wh- Question (What time / When)",
            promptHinglish = "Sawal banayein: 'Train kab / kitne baje aati hai?'",
            correctQuestionEnglish = "When does the train arrive?",
            acceptableQuestions = listOf(
                "When does the train arrive?",
                "What time does the train arrive?",
                "When does the train arrive",
                "What time does the train arrive"
            ),
            grammarRuleHinglish = "Wh-word (When / What time) + does + the train (singular) + arrive?"
        ),
        MakeQuestionExercise(
            id = 5,
            statementEnglish = "You can speak English.",
            targetType = "Yes/No Modal Question",
            promptHinglish = "Sawal banayein: 'Kya aap English bol sakte hain?'",
            correctQuestionEnglish = "Can you speak English?",
            acceptableQuestions = listOf("Can you speak English?", "Can you speak English"),
            grammarRuleHinglish = "Modal verb 'Can' ko sentence ke shuruat mein rakhein: Can + you + speak English?"
        )
    )
}
