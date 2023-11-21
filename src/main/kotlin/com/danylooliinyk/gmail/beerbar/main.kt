package com.danylooliinyk.gmail.beerbar

/**
 * The entry point of our stepBasedBar.
 */
fun main() {
    val player = BeerDrinker()
    while (true) {
        println("Наповненість шлунку: ${player.stomachFillingString}")
        println("Введіть команду:")
        print("> ")
        val userInput = readln()
        val beerDrinkerCommand = mapCommand(command = userInput)
        player.executeCommand(beerDrinkerCommand)
    }
}

fun mapCommand(command: String): BeerDrinkerCommand = when (command) {
    "увійти" -> BeerDrinkerCommand.УВІЙТИ
    "вийти" -> BeerDrinkerCommand.ВИЙТИ
    "сьорб" -> BeerDrinkerCommand.СЬОРБ
    "риг" -> BeerDrinkerCommand.РИГ
    "де" -> BeerDrinkerCommand.ДЕ
    "хелп" -> BeerDrinkerCommand.ХЕЛП
    else -> BeerDrinkerCommand.РИГ

}



