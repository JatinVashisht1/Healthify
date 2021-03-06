package com.jatinvashisht.healthify.presentation.who_guidelines

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jatinvashisht.healthify.presentation.who_guidelines.components.WhoGuidelinesEntity

@HiltViewModel
class WhoGuidelinesViewModel @Inject constructor() : ViewModel(){
    val whoGuidelinesEntityList = mutableListOf<WhoGuidelinesEntity>(
        WhoGuidelinesEntity(
            title = "1. Eat a healthy diet",
            description = "Eat a combination of different foods, including fruit, vegetables, legumes, nuts and whole grains. Adults should eat at least five portions (400g) of fruit and vegetables per day. You can improve your intake of fruits and vegetables by always including veggies in your meal; eating fresh fruit and vegetables as snacks; eating a variety of fruits and vegetables; and eating them in season. By eating healthy, you will reduce your risk of malnutrition and noncommunicable diseases (NCDs) such as diabetes, heart disease, stroke and cancer."
        ),
        WhoGuidelinesEntity(
            "2. Consume less salt and sugar",
            "Filipinos consume twice the recommended amount of sodium, putting them at risk of high blood pressure, which in turn increases the risk of heart disease and stroke. Most people get their sodium through salt. Reduce your salt intake to 5g per day, equivalent to about one teaspoon. It’s easier to do this by limiting the amount of salt, soy sauce, fish sauce and other high-sodium condiments when preparing meals; removing salt, seasonings and condiments from your meal table; avoiding salty snacks; and choosing low-sodium products.\n" +
                    "\n" +
                    "On the other hand, consuming excessive amounts of sugars increases the risk of tooth decay and unhealthy weight gain. In both adults and children, the intake of free sugars should be reduced to less than 10% of total energy intake. This is equivalent to 50g or about 12 teaspoons for an adult. WHO recommends consuming less than 5% of total energy intake for additional health benefits. You can reduce your sugar intake by limiting the consumption of sugary snacks, candies and sugar-sweetened beverages."
        ),
        WhoGuidelinesEntity(
            "3. Reduce intake of harmful fats",
            "Fats consumed should be less than 30% of your total energy intake. This will help prevent unhealthy weight gain and NCDs. There are different types of fats, but unsaturated fats are preferable over saturated fats and trans-fats. WHO recommends reducing saturated fats to less than 10% of total energy intake; reducing trans-fats to less than 1% of total energy intake; and replacing both saturated fats and trans-fats to unsaturated fats.\n" +
                    "\n" +
                    "The preferable unsaturated fats are found in fish, avocado and nuts, and in sunflower, soybean, canola and olive oils; saturated fats are found in fatty meat, butter, palm and coconut oil, cream, cheese, ghee and lard; and trans-fats are found in baked and fried foods, and pre-packaged snacks and foods, such as frozen pizza, cookies, biscuits, and cooking oils and spreads."
        ),
        WhoGuidelinesEntity(
            "4. Avoid harmful use of alcohol",
            "4. Avoid harmful use of alcohol"
        ),
        WhoGuidelinesEntity(
            "5. Don’t smoke",
            "Smoking tobacco causes NCDs such as lung disease, heart disease and stroke. Tobacco kills not only the direct smokers but even non-smokers through second-hand exposure. Currently, there are around 15.9 million Filipino adults who smoke tobacco but 7 in 10 smokers are interested or plan to quit.\n" +
                    "\n" +
                    "If you are currently a smoker, it’s not too late to quit. Once you do, you will experience immediate and long-term health benefits. If you are not a smoker, that’s great! Do not start smoking and fight for your right to breathe tobacco-smoke-free air."
        ),
        WhoGuidelinesEntity(
            "6. Be active",
            "Physical activity is defined as any bodily movement produced by skeletal muscles that requires energy expenditure. This includes exercise and activities undertaken while working, playing, carrying out household chores, travelling, and engaging in recreational pursuits. The amount of physical activity you need depends on your age group but adults aged 18-64 years should do at least 150 minutes of moderate-intensity physical activity throughout the week. Increase moderate-intensity physical activity to 300 minutes per week for additional health benefits."
        ),
        WhoGuidelinesEntity(
            "7. Check your blood pressure regularly",
            "Hypertension, or high blood pressure, is called a “silent killer”. This is because many people who have hypertension may not be aware of the problem as it may not have any symptoms. If left uncontrolled, hypertension can lead to heart, brain, kidney and other diseases. Have your blood pressure checked regularly by a health worker so you know your numbers. If your blood pressure is high, get the advice of a health worker. This is vital in the prevention and control of hypertension."
        ),
        WhoGuidelinesEntity(
            "8. Get tested",
            "Getting yourself tested is an important step in knowing your health status, especially when it comes to HIV, hepatitis B, sexually-transmitted infections (STIs) and tuberculosis (TB). Left untreated, these diseases can lead to serious complications and even death. Knowing your status means you will know how to either continue preventing these diseases or, if you find out that you’re positive, get the care and treatment that you need. Go to a public or private health facility, wherever you are comfortable, to have yourself tested."
        ),
        WhoGuidelinesEntity(
            "9. Get vaccinated",
            "Vaccination is one of the most effective ways to prevent diseases. Vaccines work with your body’s natural defences to build protection against diseases like cervical cancer, cholera, diphtheria, hepatitis B, influenza, measles, mumps, pneumonia, polio, rabies, rubella, tetanus, typhoid, and yellow fever.\n" +
                    "\n" +
                    "In the Philippines, free vaccines are provided to children 1 year old and below as part of the Department of Health’s routine immunization programme. If you are an adolescent or adult, you may ask your physician if to check your immunization status or if you want to have yourself vaccinated."
        ),
        WhoGuidelinesEntity(
            "10. Practice safe sex",
            "Looking after your sexual health is important for your overall health and well-being. Practice safe sex to prevent HIV and other sexually transmitted infections like gonorrhoea and syphilis. There are available prevention measures such as pre-exposure prophylaxis (PrEP) that will protect you from HIV and condoms that will protect you from HIV and other STIs."
        ),
        WhoGuidelinesEntity(
            "11. Cover your mouth when coughing or sneezing",
            "Diseases such as influenza, pneumonia and tuberculosis are transmitted through the air. When an infected person coughs or sneezes, infectious agents may be passed on to others through airborne droplets. When you feel a cough or sneeze coming on, make sure you have covered your mouth with a face mask or use a tissue then dispose it carefully. If you do not have a tissue close by when you cough or sneeze, cover your mouth as much as possible with the crook (or the inside) of your elbow."
        ),
        WhoGuidelinesEntity(
            "12. Prevent mosquito bites",
            "Mosquitoes are one of the deadliest animals in the world. Diseases like dengue, chikungunya, malaria and lymphatic filariasis are transmitted by mosquitoes and continue to affect Filipinos. You can take simple measures to protect yourself and your loved ones against mosquito-borne diseases. If you’re traveling to an area with known mosquito-borne diseases, consult a physician for a vaccine to prevent diseases such as Japanese encephalitis and yellow fever or if you need to take antimalarial medicines. Wear light-coloured, long-sleeved shirts and pants and use insect repellent. At home, use window and door screens, use bed nets and clean your surroundings weekly to destroy mosquito breeding sites."
        ),
        WhoGuidelinesEntity(
            "13. Follow traffic laws",
            "Road crashes claim over one million lives around the world and millions more are injured. Road traffic injuries are preventable through a variety of measures implemented by the government such as strong legislation and enforcement, safer infrastructure and vehicle standards, and improved post-crash care. You yourself can also prevent road crashes by ensuring that you follow traffic laws such as using the seatbelt for adults and child restraint for your kids, wearing a helmet when riding a motorcycle or bicycle, not drinking and driving, and not using your mobile phone while driving."
        ),
        WhoGuidelinesEntity(
            "14. Drink only safe water",
            "Drinking unsafe water can lead to water-borne diseases such as cholera, diarrhoea, hepatitis A, typhoid and polio. Globally, at least 2 billion people use a drinking water source contaminated with faeces. Check with your water concessionaire and water refilling station to ensure that the water you’re drinking is safe. In a setting where you are unsure of your water source, boil your water for at least one minute. This will destroy harmful organisms in the water. Let it cool naturally before drinking."
        ),
        WhoGuidelinesEntity(
            "15. Breastfeed babies from 0 to 2 years and beyond",
            "Breastfeeding is the best way to provide the ideal food for newborns and infants. WHO recommends that mothers initiate breastfeeding within one hour of birth. Breastfeeding for the first six months is crucial for the baby to grow up healthy. It is recommended that breastfeeding is continued for up to two years and beyond. Aside from being beneficial to babies, breastfeeding is also good for the mother as it reduces the risk of breast and ovarian cancer, type II diabetes, and postpartum depression."
        ),
        WhoGuidelinesEntity(
            "16. Talk to someone you trust if you're feeling down",
            "Depression is a common illness worldwide with over 260 million people affected. Depression can manifest in different ways, but it might make you feel hopeless or worthless, or you might think about negative and disturbing thoughts a lot or have an overwhelming sense of pain. If you’re going through this, remember that you are not alone. Talk to someone you trust such as a family member, friend, colleague or mental health professional about how you feel. If you feel that you are in danger of harming yourself, contact the National Center for Mental Health hotline at 0917-899-USAP (8727)."
        ),
        WhoGuidelinesEntity(
            "17. Take antibiotics only as prescribed",
            "Antibiotic resistance is one of the biggest public health threats in our generation. When antibiotics lose their power, bacterial infections become harder to treat, leading to higher medical costs, prolonged hospital stays, and increased mortality. Antibiotics are losing their power because of misuse and overuse in humans and animals. Make sure you only take antibiotics if prescribed by a qualified health professional. And once prescribed, complete the treatment days as instructed. Never share antibiotics."
        ),
        WhoGuidelinesEntity(
            "18. Clean your hands properly",
            "Hand hygiene is critical not only for health workers but for everyone. Clean hands can prevent the spread of infectious illnesses. You should handwash using soap and water when your hands are visibly soiled or handrub using an alcohol-based product."
        ),
        WhoGuidelinesEntity(
            "19. Prepare your food correctly",
            "Unsafe food containing harmful bacteria, viruses, parasites or chemical substances, causes more than 200 diseases – ranging from diarrhoea to cancers. When buying food at the market or store, check the labels or the actual produce to ensure it is safe to eat. If you are preparing food, make sure you follow the Five Keys to Safer Food: \n(1) keep clean; \n(2) separate raw and cooked; \n(3) cook thoroughly; \n(4) keep food at safe temperatures; \n(5) use safe water and raw materials."
        ),
        WhoGuidelinesEntity(
            "20. Have regular check-ups",
            "Regular check-ups can help find health problems before they start. Health professionals can help find and diagnose health issues early, when your chances for treatment and cure are better. Go to your nearest health facility to check out the the health services, screenings and treatment that are accessible to you."
        )

    )

}