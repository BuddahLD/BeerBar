package com.danylooliinyk.gmail.beerbar

/**
 * The entry point of our app.
 */
fun main() {
//    val beerMenu = mapOf(
//        "1" to "Світле",
//        "2" to "Темне",
//        "3" to "Моча",
//        "4" to "Смачне",
//        "5" to "Бланш",
//        "6" to "Жигулівське",
//    )
//
//    spirtln("Шо міс'є бажає?")
//    spirtln("Наш ассортимент, пупсік:")
//    beerMenu.forEach { (position, beerName) ->
//        println("$position - $beerName")
//    }
//    val choice = readChoice()
//
//    beerMenu.keys.find { key -> key == choice }
//
//    when (choice) {
//        "1" -> println("Ти вибрав світле!")
//        "2" -> println("Любиш негрів?")
//        "3" -> println("Дебіл сука")
//        "4" -> println("Хтоб сумнівався")
//        "5" -> println("welcome to the club buddy")
//        "6" -> println("нирки досвідос")
//    }
    val beerDrinker = BeerDrinker()
    beerDrinker.drinkBeer()
    beerDrinker.enterBar()
    beerDrinker.drinkBeer()
    beerDrinker.exitBar()
    beerDrinker.drinkBeer()
}
