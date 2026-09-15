package com.example.data.roadmap

import com.example.data.model.CommonMistake
import com.example.data.model.ExampleSentence
import com.example.data.model.LessonSection
import com.example.data.model.QuizQuestion
import com.example.data.model.RoadmapModule

object RoadmapDataProvider {

    val modules: List<RoadmapModule> = listOf(
        // MODULE 1: Parts of Speech
        RoadmapModule(
            id = 1,
            title = "1. Parts of Speech",
            subtitleHinglish = "English language ke 8 basic building blocks",
            iconEmoji = "🧱",
            category = "Foundation",
            estimatedMinutes = 10,
            overviewHinglish = "Jaise kisi building ko banane ke liye cement, bricks aur steel chahiye, waise hi English sentence bolne ke liye 8 Parts of Speech ki zaroorat hoti hai. Har word ka ek specific kaam (role) hota hai.",
            coreConceptRule = "Sentence ka har word ya to Noun, Pronoun, Verb, Adjective, Adverb, Preposition, Conjunction ya Interjection hota hai.",
            sections = listOf(
                LessonSection(
                    title = "Noun (Naam) & Pronoun (Sarvanam)",
                    explanationHinglish = "Noun kisi person, place, thing ya idea ka naam hai (e.g. Rahul, Delhi, Phone, Water). Pronoun wo word hai jo baar-baar Noun repeat na karne ke liye use hota hai jaise: I, You, He, She, It, We, They.",
                    formulaOrStructure = "Noun = Naming Word | Pronoun = Noun ki jagah aane waala word",
                    bulletPointsHinglish = listOf(
                        "Example: 'Rahul is tired. He is sleeping.' (Yahan 'Rahul' Noun hai aur 'He' Pronoun)",
                        "Singular: I, He, She, It | Plural: We, They, You"
                    ),
                    keyExamples = listOf(
                        ExampleSentence("Rohan is my friend. He helps me.", "Rohan mera dost hai. Wo meri madad karta hai.", "Rohan ki jagah 'He' use hua.")
                    )
                ),
                LessonSection(
                    title = "Verb (Action / Kaam) & Adjective (Visheshan)",
                    explanationHinglish = "Verb sentence ka sabse important hissa hai jo koi action (eat, run, speak) ya state (is, am, are) batata hai. Adjective kisi Noun ki quality ya khasiyat batata hai (tall, good, hot, beautiful).",
                    formulaOrStructure = "Verb = Action/State | Adjective = Noun ki khasiyat batane waala",
                    bulletPointsHinglish = listOf(
                        "Action Verb: 'I speak English.' (speak = verb)",
                        "Adjective: 'He drives a fast car.' (fast = adjective jo car ki speed bata raha hai)"
                    ),
                    keyExamples = listOf(
                        ExampleSentence("She speaks sweet words.", "Wo meethe shabd bolti hai.", "'speaks' Verb hai aur 'sweet' Adjective hai.")
                    )
                ),
                LessonSection(
                    title = "Adverb, Preposition & Conjunction",
                    explanationHinglish = "Adverb batata hai ki action kaise hua (slowly, loudly, very). Preposition position aur time batata hai (in, on, at, under). Conjunction do sentences ya words ko jodta hai (and, but, because).",
                    bulletPointsHinglish = listOf(
                        "Adverb: He runs fast / She speaks softly.",
                        "Preposition: The book is on the table.",
                        "Conjunction: I like tea and biscuits."
                    )
                )
            ),
            commonMistakes = listOf(
                CommonMistake(
                    incorrectEnglish = "He is a very quickly runner.",
                    correctEnglish = "He is a very quick runner.",
                    reasonHinglish = "Runner ek Noun hai, isliye uski khasiyat Adjective 'quick' batayega, 'quickly' (adverb) nahi."
                ),
                CommonMistake(
                    incorrectEnglish = "Rahul and myself will come.",
                    correctEnglish = "Rahul and I will come.",
                    reasonHinglish = "Subject ki jagah 'myself' nahi, standard pronoun 'I' lagta hai."
                )
            ),
            examples = listOf(
                ExampleSentence("Pooja reads a book daily.", "Pooja roz ek kitaab padhti hai.", "Pooja = Noun, reads = Verb, daily = Adverb"),
                ExampleSentence("They are happy today.", "Wo log aaj khush hain.", "They = Pronoun, are = Be-verb, happy = Adjective")
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = 101,
                    questionHinglish = "Sentence: 'Aman runs fast.' ismein 'runs' kya hai?",
                    promptEnglish = "Aman runs fast.",
                    options = listOf("Noun", "Verb", "Adjective", "Preposition"),
                    correctOptionIndex = 1,
                    explanationHinglish = "Kyunki 'runs' (daudna) ek action/kaam hai, isliye ye Verb hai."
                ),
                QuizQuestion(
                    id = 102,
                    questionHinglish = "Is sentence mein Adjective (khasiyat batane waala word) pehchano: 'She has a blue bag.'",
                    promptEnglish = "She has a blue bag.",
                    options = listOf("She", "has", "blue", "bag"),
                    correctOptionIndex = 2,
                    explanationHinglish = "'blue' bag ka color/khasiyat bata raha hai, isliye 'blue' Adjective hai."
                )
            )
        ),

        // MODULE 2: Basic Sentence Structure
        RoadmapModule(
            id = 2,
            title = "2. Basic Sentence Structure",
            subtitleHinglish = "English ka S-V-O rule (Hindi vs English ka antar)",
            iconEmoji = "📐",
            category = "Foundation",
            estimatedMinutes = 12,
            overviewHinglish = "Hindi aur English mein sentence banane ka sequence alag hota hai. Hindi mein hum bolte hain: 'Main (Subject) Chai (Object) Peeta hoon (Verb)'. Lekin English mein Verb hamesha beech mein aata hai: S + V + O!",
            coreConceptRule = "Hindi Rule: Karta + Karma + Kriya (S + O + V)\nEnglish Rule: Subject + Verb + Object (S + V + O)",
            sections = listOf(
                LessonSection(
                    title = "S-V-O Formula Samajhiye",
                    explanationHinglish = "Subject = Kaam karne waala (I, He, She, We, Amit)\nVerb = Kya kaam ho raha hai (drink, play, write, watch)\nObject = Kis cheez par kaam ho raha hai (tea, cricket, a letter, movie)",
                    formulaOrStructure = "[Subject] + [Verb] + [Object]",
                    bulletPointsHinglish = listOf(
                        "Hindi: Main (S) paani (O) peeta hoon (V).",
                        "English: I (S) drink (V) water (O).",
                        "Hindi: Wo (S) English (O) seekhta hai (V).",
                        "English: He (S) learns (V) English (O)."
                    ),
                    keyExamples = listOf(
                        ExampleSentence("I play cricket.", "Main cricket khelta hoon.", "I (S) + play (V) + cricket (O)"),
                        ExampleSentence("She teaches English.", "Wo English padhati hai.", "She (S) + teaches (V) + English (O)")
                    )
                ),
                LessonSection(
                    title = "Subject-Verb Agreement (s/es ka rule)",
                    explanationHinglish = "Present simple mein jab Subject Singular (He, She, It, Kisi ek ka naam) ho, to Verb mein 's' ya 'es' judta hai. Lekin I, You, We, They ke sath normal verb lagta hai.",
                    formulaOrStructure = "He/She/It + Verb(s/es) | I/You/We/They + Verb(original)",
                    bulletPointsHinglish = listOf(
                        "He speaks English. (Correct - Singular subject)",
                        "They speak English. (Correct - Plural subject)",
                        "I speak English. ('I' exception hai, 's' nahi lagta)"
                    )
                )
            ),
            commonMistakes = listOf(
                CommonMistake(
                    incorrectEnglish = "I cricket play.",
                    correctEnglish = "I play cricket.",
                    reasonHinglish = "Hindi word order (I cricket play) mat follow karo. English mein Verb 'play' pehle aayega, fir object 'cricket'."
                ),
                CommonMistake(
                    incorrectEnglish = "He go to office daily.",
                    correctEnglish = "He goes to office daily.",
                    reasonHinglish = "Singular subject 'He' ke sath verb mein 'es' (goes) lagta hai."
                )
            ),
            examples = listOf(
                ExampleSentence("We watch movies on Sunday.", "Hum Sunday ko movies dekhte hain.", "We (S) + watch (V) + movies (O)"),
                ExampleSentence("My brother loves music.", "Mera bhai music pasand karta hai.", "Brother singular hai, isliye 'loves' aaya.")
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = 201,
                    questionHinglish = "'Main gaana sunta hoon' ka sahi English S-V-O order kya hai?",
                    promptEnglish = "Translate to correct S-V-O format",
                    options = listOf("I song listen.", "I listen to songs.", "Song I listen.", "Listen I songs."),
                    correctOptionIndex = 1,
                    explanationHinglish = "Subject (I) + Verb (listen) + Object (to songs) hi correct structure hai."
                ),
                QuizQuestion(
                    id = 202,
                    questionHinglish = "Khali jagah bhariye: 'She ___ delicious food.'",
                    promptEnglish = "She ___ delicious food.",
                    options = listOf("cook", "cooks", "cooking", "cooked not"),
                    correctOptionIndex = 1,
                    explanationHinglish = "'She' singular subject hai, isliye verb mein 's' judega: 'cooks'."
                )
            )
        ),

        // MODULE 3: Be Verbs (am, is, are, was, were)
        RoadmapModule(
            id = 3,
            title = "3. Be Verbs (am, is, are, was, were)",
            subtitleHinglish = "Hona, Pehchan, Quality aur State of Being batana",
            iconEmoji = "✨",
            category = "Core Grammar",
            estimatedMinutes = 15,
            overviewHinglish = "'Be Verbs' kisi cheez ke hone ya sthiti (state) ko batate hain jab koi action nahi ho raha ho. Jaise: Main teacher hoon, Wo khush hai, Hum kal busy the.",
            coreConceptRule = "Present: am (I ke sath), is (He/She/It/Singular), are (You/We/They/Plural)\nPast: was (I/He/She/It), were (You/We/They)",
            sections = listOf(
                LessonSection(
                    title = "Present Be Verbs (am / is / are)",
                    explanationHinglish = "'Hoon / Hai / Hain' ke liye use hote hain.",
                    formulaOrStructure = "I + am | He/She/It/Name + is | You/We/They + are",
                    bulletPointsHinglish = listOf(
                        "I am ready. (Main taiyar hoon)",
                        "He is my brother. (Wo mera bhai hai)",
                        "They are very polite. (Wo log bohot vinamra hain)"
                    ),
                    keyExamples = listOf(
                        ExampleSentence("I am a software engineer.", "Main ek software engineer hoon.", "Pehchan batane ke liye 'am' use hua.")
                    )
                ),
                LessonSection(
                    title = "Past Be Verbs (was / were)",
                    explanationHinglish = "'Tha / Thi / The' ke liye use hote hain.",
                    formulaOrStructure = "I/He/She/It + was | You/We/They + were",
                    bulletPointsHinglish = listOf(
                        "I was at home yesterday. (Main kal ghar par tha)",
                        "She was upset. (Wo pareshan thi)",
                        "We were in the meeting. (Hum meeting mein the)"
                    )
                ),
                LessonSection(
                    title = "Negatives & Questions with Be Verbs",
                    explanationHinglish = "Negative banane ke liye Be-verb ke baad 'not' lagao. Question banane ke liye Be-verb ko shuruat mein le aao.",
                    formulaOrStructure = "Negative: Subject + Be-verb + not | Question: Be-verb + Subject...?",
                    bulletPointsHinglish = listOf(
                        "Negative: I am not tired. / He is not at home.",
                        "Question: Are you ready? / Was he angry?"
                    )
                )
            ),
            commonMistakes = listOf(
                CommonMistake(
                    incorrectEnglish = "You is very smart.",
                    correctEnglish = "You are very smart.",
                    reasonHinglish = "'You' chahe ek vyakti ke liye ho ya kayi ke liye, hamesha 'are' ya 'were' leta hai."
                ),
                CommonMistake(
                    incorrectEnglish = "They was absent yesterday.",
                    correctEnglish = "They were absent yesterday.",
                    reasonHinglish = "They plural hai, isliye past mein 'were' aayega."
                )
            ),
            examples = listOf(
                ExampleSentence("Are you busy right now?", "Kya aap abhi busy hain?", "Direct question using 'Are'."),
                ExampleSentence("The weather was pleasant yesterday.", "Kal mausam suhana tha.", "Past singular state using 'was'.")
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = 301,
                    questionHinglish = "'Hum kal shaam ko market mein the' ka sahi translation kya hoga?",
                    promptEnglish = "We ___ in the market yesterday evening.",
                    options = listOf("was", "were", "are", "is"),
                    correctOptionIndex = 1,
                    explanationHinglish = "'We' plural subject hai aur baat kal (past) ki ho rahi hai, isliye 'were' aayega."
                ),
                QuizQuestion(
                    id = 302,
                    questionHinglish = "'Kya wo tumhari behan hai?' ko English mein kaise puchenge?",
                    promptEnglish = "Choose the correct question:",
                    options = listOf("Is she your sister?", "She is your sister?", "Are she your sister?", "Does she your sister?"),
                    correctOptionIndex = 0,
                    explanationHinglish = "She ke sath 'Is' lagta hai aur question banane ke liye 'Is' shuruat mein aata hai: 'Is she your sister?'"
                )
            )
        ),

        // MODULE 4: Do Verbs (do, does, did)
        RoadmapModule(
            id = 4,
            title = "4. Do Verbs (do, does, did)",
            subtitleHinglish = "Actions ke negatives aur questions banana",
            iconEmoji = "⚡",
            category = "Core Grammar",
            estimatedMinutes = 15,
            overviewHinglish = "Jab sentence mein koi Action Verb (jaise play, know, go, like) ho, tab 'not' lagane ya question banane ke liye Do/Does/Did ki help li jaati hai. Inhe Helping Verbs kehte hain.",
            coreConceptRule = "Present: Do (I, You, We, They) | Does (He, She, It, Singular Name)\nPast: Did (Sabhi subjects ke sath)",
            sections = listOf(
                LessonSection(
                    title = "Do & Does ka Golden Rule",
                    explanationHinglish = "Positive sentence mein simple verb aata hai. Lekin Negative ya Question mein Do/Does aate hi main verb hamesha first form (original V1) mein rehta hai!",
                    formulaOrStructure = "Negative: Subject + do/does + not + V1 | Question: Do/Does + Subject + V1?",
                    bulletPointsHinglish = listOf(
                        "Positive: She likes coffee.",
                        "Negative: She does not like coffee. (Notice: 'likes' ka 's' hat gaya!)",
                        "Question: Does she like coffee?"
                    ),
                    keyExamples = listOf(
                        ExampleSentence("I do not understand.", "Mujhe samajh nahi aa raha.", "I ke sath 'do not' use hota hai.")
                    )
                ),
                LessonSection(
                    title = "Past mein 'Did' ka use",
                    explanationHinglish = "Past ki baaton mein sabhi subjects ke sath 'did' lagta hai. Did lagte hi verb ka 2nd form waapas 1st form (V1) ban jata hai!",
                    formulaOrStructure = "Did + not + V1 (Original verb)",
                    bulletPointsHinglish = listOf(
                        "Positive: He went to market. (went = V2)",
                        "Negative: He did not go to market. (did + go V1, 'went' nahi aayega!)",
                        "Question: Did you call him?"
                    )
                )
            ),
            commonMistakes = listOf(
                CommonMistake(
                    incorrectEnglish = "She does not likes tea.",
                    correctEnglish = "She does not like tea.",
                    reasonHinglish = "Jab 'does' lag gaya, to 'like' mein alag se 's' nahi lagaya jata."
                ),
                CommonMistake(
                    incorrectEnglish = "Did you saw the movie?",
                    correctEnglish = "Did you see the movie?",
                    reasonHinglish = "'Did' ke sath hamesha 1st form (see) aati hai, 2nd form (saw) nahi."
                )
            ),
            examples = listOf(
                ExampleSentence("Do you know the answer?", "Kya aapko jawab pata hai?", "Do + You + know?"),
                ExampleSentence("He did not reply to my message.", "Usne mere message ka jawab nahi diya.", "did not + reply (V1)")
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = 401,
                    questionHinglish = "'Wo roz subah gym nahi jata hai' ka sahi English kya hoga?",
                    promptEnglish = "He ___ to gym every morning.",
                    options = listOf("does not goes", "does not go", "do not go", "is not go"),
                    correctOptionIndex = 1,
                    explanationHinglish = "'He' ke sath 'does not' aayega aur verb ki original form 'go' rahegi: 'does not go'."
                ),
                QuizQuestion(
                    id = 402,
                    questionHinglish = "'Did they ___ the match yesterday?' khali jagah bhariye:",
                    promptEnglish = "Did they ___ the match yesterday?",
                    options = listOf("won", "win", "winning", "wins"),
                    correctOptionIndex = 1,
                    explanationHinglish = "'Did' ke baad hamesha verb ki 1st form (win) aati hai."
                )
            )
        ),

        // MODULE 5: Have Verbs (have, has, had)
        RoadmapModule(
            id = 5,
            title = "5. Have Verbs (have, has, had)",
            subtitleHinglish = "Possession (Paas hona) aur Completed Actions batana",
            iconEmoji = "💼",
            category = "Core Grammar",
            estimatedMinutes = 12,
            overviewHinglish = "'Have/Has/Had' do tareeqe se use hote hain: 1) Possession batane ke liye (Mere paas gaadi hai), 2) Perfect Tense mein batane ke liye ki koi kaam abhi-abhi pura hua hai (Main lunch kar chuka hoon).",
            coreConceptRule = "Present Possession: Have (I, You, We, They) | Has (He, She, It, Singular)\nPast: Had (Sabhi ke sath)\nAction: Have/Has/Had + V3 (3rd form of verb)",
            sections = listOf(
                LessonSection(
                    title = "1) Possession: Mere paas kuch hai",
                    explanationHinglish = "Jab aapke paas koi cheez, rishta ya problem ho.",
                    formulaOrStructure = "Subject + have/has + Object",
                    bulletPointsHinglish = listOf(
                        "I have a laptop. (Mere paas laptop hai)",
                        "She has two brothers. (Uske do bhai hain)",
                        "I had a severe headache yesterday. (Kal mujhe bohot tej sir dard tha)"
                    ),
                    keyExamples = listOf(
                        ExampleSentence("Do you have some time?", "Kya aapke paas thoda waqt hai?", "Possession question using 'Do you have'?")
                    )
                ),
                LessonSection(
                    title = "2) Action Complete: Kaam ho chuka hai (V3)",
                    explanationHinglish = "Jab koi kaam finish ho chuka ho, tab Have/Has + 3rd form (V3) lagti hai.",
                    formulaOrStructure = "Subject + have/has + V3 (done, eaten, seen, sent)",
                    bulletPointsHinglish = listOf(
                        "I have sent the email. (Maine email bhej diya hai)",
                        "He has finished his work. (Usne apna kaam khatam kar liya hai)",
                        "They have reached Delhi. (Wo Delhi pahunch chuke hain)"
                    )
                )
            ),
            commonMistakes = listOf(
                CommonMistake(
                    incorrectEnglish = "He have a new car.",
                    correctEnglish = "He has a new car.",
                    reasonHinglish = "He/She/It ke sath 'has' lagta hai, 'have' nahi."
                ),
                CommonMistake(
                    incorrectEnglish = "I have did my homework.",
                    correctEnglish = "I have done my homework.",
                    reasonHinglish = "'Have' ke baad 3rd form (done) aati hai, 2nd form (did) nahi."
                )
            ),
            examples = listOf(
                ExampleSentence("She has a lot of experience.", "Uske paas kafi anubhav hai.", "Singular possession with 'has'."),
                ExampleSentence("We have completed the project.", "Humne project complete kar liya hai.", "have + completed (V3)")
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = 501,
                    questionHinglish = "'Rahul ke paas ek naya phone hai' ka sahi translation kya hoga?",
                    promptEnglish = "Rahul ___ a new phone.",
                    options = listOf("have", "has", "is having", "are"),
                    correctOptionIndex = 1,
                    explanationHinglish = "Rahul singular name hai, isliye possession ke liye 'has' aayega."
                ),
                QuizQuestion(
                    id = 502,
                    questionHinglish = "'Maine apna lunch kar liya hai' - sahi form chunein:",
                    promptEnglish = "I have ___ my lunch.",
                    options = listOf("eat", "ate", "eaten", "eating"),
                    correctOptionIndex = 2,
                    explanationHinglish = "'have' ke sath verb ki 3rd form (eaten) lagti hai."
                )
            )
        ),

        // MODULE 6: Basic Tenses
        RoadmapModule(
            id = 6,
            title = "6. Basic Tenses",
            subtitleHinglish = "Present, Past, Future aur Continuous tenses ka practical use",
            iconEmoji = "⏳",
            category = "Sentence Mastery",
            estimatedMinutes = 18,
            overviewHinglish = "Tenses ka matlab hai waqt (Time). English mein rozmarra ki 80% baatcheet sirf 4 main tenses mein hoti hai: Simple Present (Daily habit), Present Continuous (Abhi chal raha kaam), Simple Past (Jo ho gaya), aur Simple Future (Aane waala kal).",
            coreConceptRule = "Simple Present: Routine (V1 / V1+s)\nPresent Continuous: Abhi (is/am/are + V-ing)\nSimple Past: Beeta hua kal (V2)\nSimple Future: Aane waala kal (will + V1)",
            sections = listOf(
                LessonSection(
                    title = "1. Simple Present & Present Continuous",
                    explanationHinglish = "Simple Present roz ki aadat ke liye: 'I wake up at 7 AM.'\nPresent Continuous abhi iss pal chal rahe kaam ke liye: 'I am studying right now.'",
                    bulletPointsHinglish = listOf(
                        "Habit: I drink tea daily. (Main roz chai peeta hoon)",
                        "Now: I am drinking tea now. (Main abhi chai pee raha hoon)"
                    )
                ),
                LessonSection(
                    title = "2. Simple Past (Past Action - V2)",
                    explanationHinglish = "Jo kaam past mein khatam hua, uske liye verb ki 2nd form (V2) lagti hai: go -> went, see -> saw, call -> called, buy -> bought.",
                    formulaOrStructure = "Subject + V2 (e.g. I watched a movie yesterday)",
                    bulletPointsHinglish = listOf(
                        "I called you yesterday. (Maine kal tumhe call kiya tha)",
                        "She bought a new phone last week. (Usne pichle hafte naya phone khareeda)"
                    )
                ),
                LessonSection(
                    title = "3. Simple Future (will + V1)",
                    explanationHinglish = "Aane waale waqt mein jo kaam hoga uske liye 'will + V1' lagayein.",
                    formulaOrStructure = "Subject + will + V1",
                    bulletPointsHinglish = listOf(
                        "I will call you in 5 minutes. (Main tumhe 5 minute mein call karunga)",
                        "We will meet tomorrow. (Hum kal milenge)"
                    )
                )
            ),
            commonMistakes = listOf(
                CommonMistake(
                    incorrectEnglish = "I am agree with you.",
                    correctEnglish = "I agree with you.",
                    reasonHinglish = "'Agree' khud ek verb hai, iske pehle 'am' nahi lagate."
                ),
                CommonMistake(
                    incorrectEnglish = "Yesterday I go to market.",
                    correctEnglish = "Yesterday I went to market.",
                    reasonHinglish = "Yesterday (past) ki baat ho rahi hai, isliye 'go' ki jagah 2nd form 'went' aayegi."
                )
            ),
            examples = listOf(
                ExampleSentence("What are you doing right now?", "Aap abhi kya kar rahe hain?", "Present continuous question."),
                ExampleSentence("I will help you with this.", "Main isme aapki madad karunga.", "Future promise using 'will'.")
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = 601,
                    questionHinglish = "'Main kal aapse milunga' ka sahi translation kya hai?",
                    promptEnglish = "I ___ you tomorrow.",
                    options = listOf("met", "will meet", "am meet", "meeting"),
                    correctOptionIndex = 1,
                    explanationHinglish = "Tomorrow (future) ke liye 'will + V1' (will meet) lagta hai."
                ),
                QuizQuestion(
                    id = 602,
                    questionHinglish = "'Wo abhi gaadi chala raha hai' ka sahi English kya hoga?",
                    promptEnglish = "He ___ a car right now.",
                    options = listOf("drives", "is driving", "drived", "will drive"),
                    correctOptionIndex = 1,
                    explanationHinglish = "'right now' (abhi iss samay) ho rahe action ke liye 'is driving' aayega."
                )
            )
        ),

        // MODULE 7: Modal Verbs (Can, Could, Should, Must, May, Might)
        RoadmapModule(
            id = 7,
            title = "7. Modal Verbs",
            subtitleHinglish = "Can, Could, Should, Must, May, Might ka natural use",
            iconEmoji = "🔑",
            category = "Sentence Mastery",
            estimatedMinutes = 14,
            overviewHinglish = "Modal verbs feelings, ability, advice, permission aur zaroorat batate hain. Sabse acchi baat ye hai ki inke sath Subject chahe singular ho ya plural, verb hamesha simple 1st form (V1) mein hi rehti hai!",
            coreConceptRule = "Subject + Modal Verb (Can/Should/Could/Must) + V1 (No 's/es', No 'ing')",
            sections = listOf(
                LessonSection(
                    title = "Can vs Could (Ability aur Polite Requests)",
                    explanationHinglish = "Can = Kshamta (I can speak English).\nCould = Polite request ya past ability (Could you please help me?).",
                    bulletPointsHinglish = listOf(
                        "Can: I can drive a car. (Main gaadi chala sakta hoon)",
                        "Polite: Could you please open the door? (Kya aap kripya darwaza khol denge?)"
                    )
                ),
                LessonSection(
                    title = "Should vs Must (Advice aur Zaroorat)",
                    explanationHinglish = "Should = Salah / Advice (Aapko exercise karni chahiye).\nMust = Pakka zaroori / Obligation (Aapko helmet pehanna hi chahiye).",
                    bulletPointsHinglish = listOf(
                        "Should: You should sleep early. (Aapko jaldi sona chahiye)",
                        "Must: You must wear a seatbelt. (Aapko seatbelt lagana hi chahiye)"
                    )
                ),
                LessonSection(
                    title = "May & Might (Permission aur Possibility)",
                    explanationHinglish = "May = Formal permission (May I come in?) ya possibility (It may rain).\nMight = Kam sambhavna (He might come today - Shayad wo aaye).",
                    bulletPointsHinglish = listOf(
                        "May I ask a question? (Kya main ek sawal pooch sakta hoon?)",
                        "It might rain today. (Aaj shayad baarish ho sakti hai)"
                    )
                )
            ),
            commonMistakes = listOf(
                CommonMistake(
                    incorrectEnglish = "You should to go home.",
                    correctEnglish = "You should go home.",
                    reasonHinglish = "Modal verbs (should, can, must, could) ke baad 'to' nahi lagta."
                ),
                CommonMistake(
                    incorrectEnglish = "He can speaks fluent English.",
                    correctEnglish = "He can speak fluent English.",
                    reasonHinglish = "Modal verb ke baad verb mein 's' nahi lagta (he can speak)."
                )
            ),
            examples = listOf(
                ExampleSentence("Could you repeat that, please?", "Kya aap kripya use dohra sakte hain?", "Polite conversation phrase."),
                ExampleSentence("You should practice English daily.", "Aapko roz English practice karni chahiye.", "Giving advice using 'should'.")
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = 701,
                    questionHinglish = "'Kya aap kripya thoda dhire bol sakte hain?' ke liye sabse polite English kya hogi?",
                    promptEnglish = "Choose the most polite request:",
                    options = listOf("Speak slowly.", "Could you please speak slowly?", "You must speak slowly.", "You can speaking slowly?"),
                    correctOptionIndex = 1,
                    explanationHinglish = "'Could you please...' sabse respectful aur polite tareeqa hai request karne ka."
                ),
                QuizQuestion(
                    id = 702,
                    questionHinglish = "'Aapko doctor se consult karna chahiye' - sahi modal chunein:",
                    promptEnglish = "You ___ consult a doctor.",
                    options = listOf("should", "should to", "can to", "musting"),
                    correctOptionIndex = 0,
                    explanationHinglish = "Salah (advice) dene ke liye 'should' lagta hai aur iske baad direct V1 aati hai."
                )
            )
        ),

        // MODULE 8: Making Questions
        RoadmapModule(
            id = 8,
            title = "8. Making Questions",
            subtitleHinglish = "Wh- Questions aur Yes/No Questions banana",
            iconEmoji = "❓",
            category = "Communication",
            estimatedMinutes = 15,
            overviewHinglish = "English communication mein sawal poochna sabse important skill hai. English mein 2 types ke questions hote hain: 1) Yes/No questions jo Helping Verb se shuru hote hain, 2) Information questions jo Wh- family se shuru hote hain.",
            coreConceptRule = "Yes/No: [Helping Verb] + [Subject] + [Main Verb]...?\nWh- Question: [Wh- Word] + [Helping Verb] + [Subject] + [Main Verb]...?",
            sections = listOf(
                LessonSection(
                    title = "Wh- Family Words Samajhiye",
                    explanationHinglish = "What (Kya), Where (Kahan), When (Kab), Why (Kyun), Who (Kaun), How (Kaise), Which (Kaunsa), Whose (Kiska).",
                    formulaOrStructure = "Wh-word + Helping Verb (is/are/do/did/will) + Subject + Main Verb?",
                    bulletPointsHinglish = listOf(
                        "Where do you live? (Aap kahan rehte hain?)",
                        "What are you doing? (Aap kya kar rahe hain?)",
                        "Why did you arrive late? (Aap late kyun aaye?)",
                        "How can I help you? (Main aapki kaise madad kar sakta hoon?)"
                    )
                ),
                LessonSection(
                    title = "Yes/No Questions (Auxiliary Verbs)",
                    explanationHinglish = "Inka jawab sirf 'Haan' ya 'Naa' hota hai. Inhe 'Do, Does, Did, Is, Are, Have, Can' se start karte hain.",
                    bulletPointsHinglish = listOf(
                        "Do you speak English? (Kya aap English bolte hain?)",
                        "Are you ready? (Kya aap taiyar hain?)",
                        "Have you eaten? (Kya aapne khana kha liya?)",
                        "Can you hear me? (Kya aapko meri aawaz aa rahi hai?)"
                    )
                )
            ),
            commonMistakes = listOf(
                CommonMistake(
                    incorrectEnglish = "Where you are going?",
                    correctEnglish = "Where are you going?",
                    reasonHinglish = "Question mein helping verb 'are' subject 'you' se pehle aani chahiye."
                ),
                CommonMistake(
                    incorrectEnglish = "Why you did not call me?",
                    correctEnglish = "Why didn't you call me? / Why did you not call me?",
                    reasonHinglish = "Wh- word ke turant baad helping verb (did) aani chahiye."
                )
            ),
            examples = listOf(
                ExampleSentence("What is your plan for the weekend?", "Weekend ke liye aapka kya plan hai?", "Wh- question using 'What is'."),
                ExampleSentence("Did you receive my email?", "Kya aapko mera email mila?", "Yes/No past question with 'Did you receive'?")
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = 801,
                    questionHinglish = "'Aap kahan kaam karte hain?' ka sahi English question kya hai?",
                    promptEnglish = "Choose the correct question format:",
                    options = listOf("Where you work?", "Where do you work?", "Where are you work?", "Where does you work?"),
                    correctOptionIndex = 1,
                    explanationHinglish = "Wh-word (Where) + helping verb (do) + subject (you) + verb (work) = 'Where do you work?'"
                ),
                QuizQuestion(
                    id = 802,
                    questionHinglish = "'Kya aap meri madad kar sakte hain?' ko English mein kya kahenge?",
                    promptEnglish = "Can you ___ me?",
                    options = listOf("helps", "helping", "help", "helped"),
                    correctOptionIndex = 2,
                    explanationHinglish = "Can ke baad direct original verb 'help' aati hai: 'Can you help me?'"
                )
            )
        ),

        // MODULE 9: Answering Questions
        RoadmapModule(
            id = 9,
            title = "9. Answering Questions",
            subtitleHinglish = "Short aur full answers, polite communication techniques",
            iconEmoji = "🗣️",
            category = "Communication",
            estimatedMinutes = 12,
            overviewHinglish = "English baatcheet mein sirf 'Yes' ya 'No' bolna bohot blunt (adhura) lag sakta hai. Sahi tareeqa hai polite short answers ya full answers dena.",
            coreConceptRule = "Short Answer: Yes, I do. / No, I don't. | Yes, I am. / No, I'm not.\nPolite Addition: Thank you / Sure / Certainly / I'm afraid not.",
            sections = listOf(
                LessonSection(
                    title = "Natural Short Answers",
                    explanationHinglish = "Sawal jis helping verb se pucha gaya ho, jawab mein wahi helping verb use hoti hai.",
                    bulletPointsHinglish = listOf(
                        "Q: 'Do you work here?' -> Ans: 'Yes, I do.' ya 'No, I don't.'",
                        "Q: 'Are you coming?' -> Ans: 'Yes, I am.' ya 'No, I'm not.'",
                        "Q: 'Can you drive?' -> Ans: 'Yes, I can.' ya 'No, I can't.'"
                    )
                ),
                LessonSection(
                    title = "Polite Professional Responses",
                    explanationHinglish = "Office aur daily life mein naturally reply karne ke phrases.",
                    bulletPointsHinglish = listOf(
                        "'How are you?' -> 'I'm doing well, thank you. How about you?'",
                        "'Would you like some water?' -> 'Yes, please.' ya 'No, thank you.'",
                        "'Can I talk to you?' -> 'Sure, go ahead.' ya 'I'm a bit busy right now, can we talk in 10 minutes?'"
                    )
                )
            ),
            commonMistakes = listOf(
                CommonMistake(
                    incorrectEnglish = "Q: Do you like tea? Ans: Yes, I am.",
                    correctEnglish = "Yes, I do.",
                    reasonHinglish = "Sawal 'Do' se tha, isliye jawab bhi 'do' mein aayega, 'am' mein nahi."
                )
            ),
            examples = listOf(
                ExampleSentence("Yes, absolutely. I would love to.", "Haan, bilkul. Mujhe bohot khushi hogi.", "Polite positive response."),
                ExampleSentence("I'm sorry, I don't have that information right now.", "Maaf kijiye, abhi mere paas ye jaankari nahi hai.", "Professional negative response.")
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = 901,
                    questionHinglish = "Agar koi puche: 'Are you ready for the presentation?', to sahi short answer kya hoga?",
                    promptEnglish = "Q: Are you ready for the presentation?",
                    options = listOf("Yes, I do.", "Yes, I am.", "Yes, I have.", "Yes, I can."),
                    correctOptionIndex = 1,
                    explanationHinglish = "Sawal 'Are you' se hai, isliye answer 'Yes, I am' hoga."
                )
            )
        ),

        // MODULE 10: Articles (A, An, The)
        RoadmapModule(
            id = 10,
            title = "10. Articles (A, An, The)",
            subtitleHinglish = "Sound-based rules: Vowel sounds aur Specific things",
            iconEmoji = "🎯",
            category = "Grammar Engine",
            estimatedMinutes = 12,
            overviewHinglish = "Articles Hindi mein nahi hote, isliye Hindi speakers yahan aksar mistake karte hain. A aur An ka use letter dekh kar nahi, balki bolne par aane waali SOUND (aawaz) dekh kar kiya jata hai!",
            coreConceptRule = "A = Consonant Sound (Vyanjan - k, kh, g, b, t...)\nAn = Vowel Sound (Swar - a, aa, e, ee, u, oo, ae, o...)\nThe = Specific / Khas cheez ya Unique cheez",
            sections = listOf(
                LessonSection(
                    title = "A vs An (The Sound Rule)",
                    explanationHinglish = "Letter mat dekhiye, bolte samay shuruat ki aawaz dekhiye!",
                    bulletPointsHinglish = listOf(
                        "An hour ('h' silent hai, aawaz 'aa-ur' swar ki hai isliye 'An' aayega)",
                        "A university ('u' ki aawaz 'yu' vyanjan ki hai, isliye 'A' aayega)",
                        "An honest man ('honest' mein 'o' ki sound aati hai, isliye 'An' aayega)",
                        "An umbrella ('u' ki aawaz 'am' swar ki hai, isliye 'An' aayega)"
                    )
                ),
                LessonSection(
                    title = "The ka use kab karein?",
                    explanationHinglish = "Jab kisi specific cheez ki baat ho jise bolne aur sunne waala dono pehle se jaante hon, ya duniya mein wo unique ho (The Sun, The Moon, The Internet).",
                    bulletPointsHinglish = listOf(
                        "Give me a pen. (Koi bhi ek pen de do)",
                        "Give me the pen on your table. (Wahi khas pen jo table par hai)",
                        "The Prime Minister of India."
                    )
                )
            ),
            commonMistakes = listOf(
                CommonMistake(
                    incorrectEnglish = "He is an European.",
                    correctEnglish = "He is a European.",
                    reasonHinglish = "'European' 'Yu' (consonant sound) se shuru hota hai, isliye 'a' lagta hai."
                ),
                CommonMistake(
                    incorrectEnglish = "I will come in a hour.",
                    correctEnglish = "I will come in an hour.",
                    reasonHinglish = "'Hour' mein 'h' silent hai aur vowel sound aati hai, isliye 'an hour' sahi hai."
                )
            ),
            examples = listOf(
                ExampleSentence("She bought an expensive phone.", "Usne ek mehenga phone khareeda.", "'expensive' starts with vowel sound 'e' -> 'an'."),
                ExampleSentence("Could you turn on the fan?", "Kya aap fan chala denge?", "Kamre ke specific fan ki baat ho rahi hai -> 'the'.")
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = 1001,
                    questionHinglish = "Khali jagah bhariye: 'He is ___ honest person.'",
                    promptEnglish = "He is ___ honest person.",
                    options = listOf("a", "an", "the", "no article needed"),
                    correctOptionIndex = 1,
                    explanationHinglish = "'Honest' mein 'h' silent hai aur 'o' vowel sound se pronounce hota hai, isliye 'an' aayega."
                )
            )
        ),

        // MODULE 11: Prepositions (In, On, At, To, For, From, Under...)
        RoadmapModule(
            id = 11,
            title = "11. Prepositions",
            subtitleHinglish = "Time, Place aur Direction batane waale words",
            iconEmoji = "📍",
            category = "Grammar Engine",
            estimatedMinutes = 15,
            overviewHinglish = "Prepositions batate hain ki koi cheez kahan hai (Place), kab ho rahi hai (Time), ya kis taraf ja rahi hai (Direction). In, On aur At mein sabse zyada confusion hoti hai, aaiye aasan banayein!",
            coreConceptRule = "Time: At (Exact time: at 5 PM), On (Days/Dates: on Monday), In (Months/Years/Centuries: in July, in 2026)\nPlace: At (Exact point: at the door), On (Surface: on the table), In (Inside enclosed space: in the room)",
            sections = listOf(
                LessonSection(
                    title = "In, On, At ka Triangle Rule",
                    explanationHinglish = "In = Sabse bada/General (In India, in Mumbai, in morning, in 2026)\nOn = Beech ka (On MG Road, on the bus, on Sunday, on the roof)\nAt = Sabse exact/Specific (At the bus stop, at home, at 9:30 AM)",
                    bulletPointsHinglish = listOf(
                        "I will meet you at 4 PM. (Exact time -> at)",
                        "The party is on Saturday. (Day -> on)",
                        "I live in Delhi. (Bada shahar -> in)"
                    )
                ),
                LessonSection(
                    title = "To, For, From, With",
                    explanationHinglish = "To = Direction / Destination (Going to office)\nFor = Purpose ya Duration (Gift for you / Lived for 2 years)\nFrom = Source (Coming from home)\nWith = Sath ya Tool (With my friend / Write with a pen)",
                    bulletPointsHinglish = listOf(
                        "This coffee is for you.",
                        "He is traveling to London.",
                        "I am talking with my manager."
                    )
                )
            ),
            commonMistakes = listOf(
                CommonMistake(
                    incorrectEnglish = "I will meet you in Sunday.",
                    correctEnglish = "I will meet you on Sunday.",
                    reasonHinglish = "Days (Sunday, Monday) ke pehle 'on' lagta hai, 'in' nahi."
                ),
                CommonMistake(
                    incorrectEnglish = "The train arrives on 10 AM.",
                    correctEnglish = "The train arrives at 10 AM.",
                    reasonHinglish = "Exact clock time (10 AM) ke pehle 'at' lagta hai."
                )
            ),
            examples = listOf(
                ExampleSentence("The keys are on the dining table.", "Chaabiya dining table par hain.", "Surface location using 'on'."),
                ExampleSentence("I was born in October.", "Mera janam October mein hua tha.", "Month using 'in'.")
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = 1101,
                    questionHinglish = "'Hum kal shaam 6 baje milenge' - sahi preposition chunein:",
                    promptEnglish = "We will meet ___ 6 PM tomorrow.",
                    options = listOf("in", "on", "at", "to"),
                    correctOptionIndex = 2,
                    explanationHinglish = "Exact time (6 PM) ke pehle hamesha 'at' lagta hai."
                )
            )
        ),

        // MODULE 12: Connectors (And, But, Because, So, Although, Therefore...)
        RoadmapModule(
            id = 12,
            title = "12. Connectors & Conjunctions",
            subtitleHinglish = "Sentences ko smoothly jodna aur natural flow banana",
            iconEmoji = "🔗",
            category = "Sentence Mastery",
            estimatedMinutes = 12,
            overviewHinglish = "Chote-chote tukdon mein bolne ki jagah sentences ko 'Connectors' se jodiye taaki aapki English mature aur fluent lage. Jaise: And (aur), But (lekin), Because (kyunki), So (isliye), Although (halaanki).",
            coreConceptRule = "And = Same idea add karna | But = Opposite idea | Because = Reason batana | So/Therefore = Result batana",
            sections = listOf(
                LessonSection(
                    title = "Daily Connectors ka Use",
                    explanationHinglish = "In 5 words se aap lambe sentences bol sakte hain:",
                    bulletPointsHinglish = listOf(
                        "Because (Kyunki): I was late because there was heavy traffic.",
                        "So (Isliye): I was tired, so I went to sleep early.",
                        "But (Lekin): I wanted to come, but I had urgent work.",
                        "Although (Halaanki): Although it was raining, we enjoyed the trip.",
                        "Otherwise (Warna): Please hurry up, otherwise we will miss the train."
                    )
                )
            ),
            commonMistakes = listOf(
                CommonMistake(
                    incorrectEnglish = "Because I was sick, so I didn't come.",
                    correctEnglish = "Because I was sick, I didn't come. / I was sick, so I didn't come.",
                    reasonHinglish = "'Because' aur 'so' dono ko ek sath ek hi sentence mein nahi use karte."
                )
            ),
            examples = listOf(
                ExampleSentence("He worked hard, so he got promoted.", "Usne mehnat ki, isliye uska promotion hua.", "Result connector 'so'."),
                ExampleSentence("I like tea, but my sister prefers coffee.", "Mujhe chai pasand hai, lekin meri behan coffee pasand karti hai.", "Contrast connector 'but'.")
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = 1201,
                    questionHinglish = "'Main shopping gaya ___ market band tha' - sahi connector chunein:",
                    promptEnglish = "I went for shopping, ___ the market was closed.",
                    options = listOf("so", "because", "but", "and"),
                    correctOptionIndex = 2,
                    explanationHinglish = "Opposite situation (gaya par band tha) ke liye 'but' aayega."
                )
            )
        ),

        // MODULE 13: Daily Vocabulary
        RoadmapModule(
            id = 13,
            title = "13. Daily Vocabulary",
            subtitleHinglish = "Roz kaam aane waale 100+ smart words aur phrases",
            iconEmoji = "📚",
            category = "Real Speaking",
            estimatedMinutes = 15,
            overviewHinglish = "Bohot mushkil words yaad karne ki zaroorat nahi hai. Rozmarra ki baatcheet ke high-frequency words aur ready-made phrases seekhiye jo daily routine, office, shopping aur travel mein kaam aate hain.",
            coreConceptRule = "Single words ki jagah 2-3 words ke Natural Chunks/Phrases seekho (e.g., 'reach on time', 'make a decision', 'run out of').",
            sections = listOf(
                LessonSection(
                    title = "Daily Routine & Home Phrases",
                    explanationHinglish = "Ghar aur dincharya ke zaroori phrases:",
                    bulletPointsHinglish = listOf(
                        "Wake up vs Get up (Aankh khulna vs Bistar se uthna)",
                        "Run out of (Khatam ho jana): We have run out of milk.",
                        "Tidy up (Saaf-safai karna): Let's tidy up the room.",
                        "Grab a bite (Jaldi se kuch khana): Let's grab a quick bite."
                    )
                ),
                LessonSection(
                    title = "Office & Professional Phrases",
                    explanationHinglish = "Workplace aur emails mein use hone waale smart phrases:",
                    bulletPointsHinglish = listOf(
                        "Follow up (Jaankari lena / update lena): I will follow up with the client.",
                        "Call it a day (Aaj ka kaam samapt karna): It's 7 PM, let's call it a day.",
                        "Keep me posted (Mujhe updates dete rehna).",
                        "On the same page (Ek hi baat par sehmat hona)."
                    )
                )
            ),
            commonMistakes = listOf(
                CommonMistake(
                    incorrectEnglish = "I am eating my breakfast.",
                    correctEnglish = "I am having my breakfast.",
                    reasonHinglish = "Meals ke sath 'having breakfast / having lunch' bolna zyada natural lagta hai."
                )
            ),
            examples = listOf(
                ExampleSentence("Please keep me in the loop.", "Kripya mujhe is baare mein updated rakhein.", "Smart office phrase."),
                ExampleSentence("We are running out of time.", "Hamara samay khatam ho raha hai.", "Everyday urgency phrase.")
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = 1301,
                    questionHinglish = "'Aaj ka kaam yahi rokte hain / khatam karte hain' ke liye sahi idiom kya hai?",
                    promptEnglish = "Choose the correct expression:",
                    options = listOf("Call it a day", "Break the day", "Stop the clock", "Make a day"),
                    correctOptionIndex = 0,
                    explanationHinglish = "'Let's call it a day' ka matlab hota hai aaj ke liye kaam samapt karna."
                )
            )
        ),

        // MODULE 14: Real Conversation Practice
        RoadmapModule(
            id = 14,
            title = "14. Real Conversation Practice",
            subtitleHinglish = "Cafe, Job Interview, Market, Doctor aur Directions roleplays",
            iconEmoji = "🎭",
            category = "Real Speaking",
            estimatedMinutes = 20,
            overviewHinglish = "Grammar aane ke baad asal challenge hota hai mauke par bina atke bolna. Yahan hum 5 real-life situations ki step-by-step scripts aur practical dialogues seekhenge.",
            coreConceptRule = "Har scenario ka ek standard flow hota hai: Greeting -> Main request -> Details -> Confirmation -> Closing.",
            sections = listOf(
                LessonSection(
                    title = "Scenario 1: Ordering at a Cafe / Restaurant",
                    explanationHinglish = "Cafe mein order karte waqt natural English:",
                    bulletPointsHinglish = listOf(
                        "Waiter: 'Hello, what can I get for you today?'",
                        "You: 'Hi, I'd like a hot cappuccino with less sugar, please.'",
                        "Waiter: 'Sure, for here or to take away?'",
                        "You: 'For here, please. And could I also get the bill?'"
                    )
                ),
                LessonSection(
                    title = "Scenario 2: Job Interview Self-Introduction",
                    explanationHinglish = "Jab interviewer puche: 'Tell me about yourself':",
                    bulletPointsHinglish = listOf(
                        "1. Greeting: 'Good morning, sir/madam. Thank you for this opportunity.'",
                        "2. Identity: 'My name is Rohan, and I am from Jaipur.'",
                        "3. Experience/Skills: 'I have 2 years of experience in customer support and I am skilled in communication and problem-solving.'",
                        "4. Goal: 'I am excited about this role because it matches my career goals.'"
                    )
                ),
                LessonSection(
                    title = "Scenario 3: Asking for Directions & Doctor Visit",
                    explanationHinglish = "Raaste poochna aur doctor se symptoms batana:",
                    bulletPointsHinglish = listOf(
                        "Directions: 'Excuse me, could you tell me how to get to the nearest metro station?'",
                        "Doctor: 'Doctor, I have had a severe sore throat and fever since yesterday morning.'"
                    )
                )
            ),
            commonMistakes = listOf(
                CommonMistake(
                    incorrectEnglish = "Give me one coffee.",
                    correctEnglish = "Could I have a coffee, please? / I'd like a coffee, please.",
                    reasonHinglish = "Direct order 'Give me' rude lagta hai, 'Could I have / I'd like' polite aur natural hai."
                )
            ),
            examples = listOf(
                ExampleSentence("Excuse me, is this seat occupied?", "Maaf kijiye, kya ye seat reserved hai?", "Polite public conversation."),
                ExampleSentence("How much does this cost?", "Iski keemat kitni hai?", "Shopping dialogue.")
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = 1401,
                    questionHinglish = "Cafe mein coffee order karne ka sabse polite tareeqa kya hai?",
                    promptEnglish = "Choose the best phrase to order:",
                    options = listOf("Bring me coffee.", "I'd like a regular coffee, please.", "Give coffee now.", "I want coffee."),
                    correctOptionIndex = 1,
                    explanationHinglish = "'I'd like a regular coffee, please' standard polite customer English hai."
                )
            )
        ),

        // MODULE 15: Speaking and Pronunciation
        RoadmapModule(
            id = 15,
            title = "15. Speaking & Pronunciation",
            subtitleHinglish = "Silent letters, tricky sounds, tongue twisters aur fluency tips",
            iconEmoji = "🎙️",
            category = "Real Speaking",
            estimatedMinutes = 15,
            overviewHinglish = "Aapka accent natural banane aur clarity badhane ke liye pronunciation rules samajhna zaroori hai. Silent letters, word stress, aur daily tongue-twisters se zubaan ki hichkichahat door hoti hai.",
            coreConceptRule = "English phonetic language nahi hai (jaisa likha hai zaroori nahi waisa hi bola jaye). Silent letters aur sounds par dhyan dein!",
            sections = listOf(
                LessonSection(
                    title = "Common Silent Letters",
                    explanationHinglish = "In words mein kuch letters chup rehte hain:",
                    bulletPointsHinglish = listOf(
                        "Silent K: Knife (naa-eef), Knee (nee), Know (no), Knowledge",
                        "Silent B: Doubt (daaut), Debt (det), Comb (kom), Thumb (tham)",
                        "Silent W: Write (raait), Wrong (rong), Answer (aan-sar)",
                        "Silent L: Talk (taak), Walk (waak), Half (haaf), Calm (kaam)",
                        "Silent P: Receipt (ri-seet), Psychology (saai-kology)"
                    )
                ),
                LessonSection(
                    title = "Tricky Confusing Sound Pairs",
                    explanationHinglish = "Choti 'i' vs Badi 'ee' sound ka difference:",
                    bulletPointsHinglish = listOf(
                        "Ship (paani ka jahaz) vs Sheep (bhed)",
                        "Live (rehna) vs Leave (chhod kar jana)",
                        "Fit (durust) vs Feet (pair)",
                        "Sit (baithna) vs Seat (baithne ki jagah)"
                    )
                ),
                LessonSection(
                    title = "Daily Tongue Twisters for Fluency",
                    explanationHinglish = "Inhe roz 3 baar tezi se bolne ki practice kijiye:",
                    bulletPointsHinglish = listOf(
                        "1. 'She sells seashells on the seashore.' (S aur Sh sound clarity ke liye)",
                        "2. 'Red lorry, yellow lorry.' (R aur L clarity ke liye)",
                        "3. 'I scream, you scream, we all scream for ice cream!'"
                    )
                )
            ),
            commonMistakes = listOf(
                CommonMistake(
                    incorrectEnglish = "Pronouncing 'Talk' as 'Taalk' with L",
                    correctEnglish = "Talk (pronounced: 'Tok')",
                    reasonHinglish = "'Talk' aur 'Walk' mein L silent rehta hai."
                ),
                CommonMistake(
                    incorrectEnglish = "Pronouncing 'Receipt' as 'Re-seept'",
                    correctEnglish = "Receipt (pronounced: 'Ri-seet')",
                    reasonHinglish = "'Receipt' mein P silent rehta hai."
                )
            ),
            examples = listOf(
                ExampleSentence("Knowledge is power.", "Gyaan hi shakti hai.", "Notice: 'K' is silent in Knowledge!"),
                ExampleSentence("He combed his hair calmly.", "Usne aaram se apne baal banaye.", "Notice: 'b' in combed and 'l' in calmly are silent.")
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = 1501,
                    questionHinglish = "Word 'Doubt' mein kaunsa letter silent hota hai?",
                    promptEnglish = "Which letter is silent in 'Doubt'?",
                    options = listOf("D", "o", "u", "b"),
                    correctOptionIndex = 3,
                    explanationHinglish = "'Doubt' ko 'daut' bola jata hai, ismein letter 'b' silent rehta hai."
                )
            )
        )
    )
}
