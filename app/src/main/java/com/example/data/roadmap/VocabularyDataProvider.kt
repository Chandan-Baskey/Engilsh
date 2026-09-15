package com.example.data.roadmap

data class VocabItem(
    val id: String,
    val wordOrPhrase: String,
    val pronunciationHelp: String,
    val hinglishMeaning: String,
    val category: String,
    val exampleEnglish: String,
    val exampleHinglish: String
)

object VocabularyDataProvider {

    val vocabList: List<VocabItem> = listOf(
        // Daily Routine
        VocabItem(
            id = "v1",
            wordOrPhrase = "Wake up vs Get up",
            pronunciationHelp = "wek ap / get ap",
            hinglishMeaning = "Wake up = Neend se aankh khulna | Get up = Bistar se khada hona",
            category = "Daily Routine",
            exampleEnglish = "I woke up at 6 AM, but got up at 6:30 AM.",
            exampleHinglish = "Meri aankh 6 baje khuli, lekin main bistar se 6:30 baje utha."
        ),
        VocabItem(
            id = "v2",
            wordOrPhrase = "Run out of",
            pronunciationHelp = "ran aaut of",
            hinglishMeaning = "Kisi cheez ka khatam ho jana (jaise milk, battery, balance)",
            category = "Daily Routine",
            exampleEnglish = "We have run out of cooking oil.",
            exampleHinglish = "Hamara khana pakane ka tel khatam ho gaya hai."
        ),
        VocabItem(
            id = "v3",
            wordOrPhrase = "Tidy up",
            pronunciationHelp = "taai-dee ap",
            hinglishMeaning = "Kamra ya jagah saaf aur vyavasthit karna",
            category = "Daily Routine",
            exampleEnglish = "Please tidy up your room before guests arrive.",
            exampleHinglish = "Mehmaan aane se pehle kripya apna kamra theek kar lo."
        ),

        // Workplace / Professional
        VocabItem(
            id = "v4",
            wordOrPhrase = "Follow up",
            pronunciationHelp = "fa-lo ap",
            hinglishMeaning = "Kisi baat ya email par aage update lena / jaankari mangna",
            category = "Office & Work",
            exampleEnglish = "I will follow up with the client this afternoon.",
            exampleHinglish = "Main aaj dopahar client se update lunga."
        ),
        VocabItem(
            id = "v5",
            wordOrPhrase = "Call it a day",
            pronunciationHelp = "kaal it a de",
            hinglishMeaning = "Aaj ke din ka kaam samapt karna / wrap up karna",
            category = "Office & Work",
            exampleEnglish = "We have worked for 9 hours, let's call it a day.",
            exampleHinglish = "Humne 9 ghante kaam kar liya, chalo aaj ke liye yahi rokte hain."
        ),
        VocabItem(
            id = "v6",
            wordOrPhrase = "On the same page",
            pronunciationHelp = "on the sem pej",
            hinglishMeaning = "Ek hi baat par sehmat hona, samajh ek jaisi hona",
            category = "Office & Work",
            exampleEnglish = "Let's have a quick sync to make sure we are on the same page.",
            exampleHinglish = "Chalo ek baar baat kar lein taaki sabhi ek hi baat par sehmat hon."
        ),
        VocabItem(
            id = "v7",
            wordOrPhrase = "Keep me posted",
            pronunciationHelp = "keep mee pos-ted",
            hinglishMeaning = "Mujhe samay-samay par naye updates dete rehna",
            category = "Office & Work",
            exampleEnglish = "Once the shipment arrives, please keep me posted.",
            exampleHinglish = "Jaise hi shipment pahuche, mujhe update dete rehna."
        ),

        // Shopping & Dining
        VocabItem(
            id = "v8",
            wordOrPhrase = "Grab a bite",
            pronunciationHelp = "grab a baait",
            hinglishMeaning = "Jaldi se kuch khana khana",
            category = "Food & Dining",
            exampleEnglish = "Are you hungry? Let's grab a quick bite.",
            exampleHinglish = "Kya tumhe bhookh lagi hai? Chalo jaldi se kuch kha lete hain."
        ),
        VocabItem(
            id = "v9",
            wordOrPhrase = "Could I have the bill?",
            pronunciationHelp = "kud aai hav the bil",
            hinglishMeaning = "Kya mujhe bill mil sakta hai? (Polite restaurant phrase)",
            category = "Food & Dining",
            exampleEnglish = "Excuse me, could we have the bill, please?",
            exampleHinglish = "Maaf kijiye, kya hume bill mil sakta hai?"
        ),
        VocabItem(
            id = "v10",
            wordOrPhrase = "Bargain / Best price",
            pronunciationHelp = "baar-gin / best praais",
            hinglishMeaning = "Mole-bhaav karna ya aakhiri keemat poochna",
            category = "Shopping",
            exampleEnglish = "What is the best price you can offer for this jacket?",
            exampleHinglish = "Iss jacket ke liye aapki sabse achi keemat kya hai?"
        ),

        // Travel & Directions
        VocabItem(
            id = "v11",
            wordOrPhrase = "Excuse me, where is...",
            pronunciationHelp = "eks-kyuz mee, wer iz",
            hinglishMeaning = "Maaf kijiye, ... kahan par hai?",
            category = "Travel & Directions",
            exampleEnglish = "Excuse me, where is the nearest metro station?",
            exampleHinglish = "Maaf kijiye, sabse paas waala metro station kahan hai?"
        ),
        VocabItem(
            id = "v12",
            wordOrPhrase = "Take the second right",
            pronunciationHelp = "tek the se-kand raait",
            hinglishMeaning = "Dusra daaya (right) mod lijiye",
            category = "Travel & Directions",
            exampleEnglish = "Go straight for 200 meters and take the second right.",
            exampleHinglish = "200 meter seedhe jaakar dusra right turn lijiye."
        )
    )
}
