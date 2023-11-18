package com.danylooliinyk.gmail.beerbar

/**
 * The entry point of our stepBasedBar.
 */
fun main() {
    val player = BeerDrinker()
    // Навчити BeerDrinker говорити
    while (true) {
        println("Введіть команду:")
        print("> ")
        val userInput = readln()
        val beerDrinkerCommand = handleCommand(command = userInput)
        player.executeCommand(beerDrinkerCommand)
    }
}

fun handleCommand(command: String): BeerDrinkerCommand = when (command) {
    "увійти" -> BeerDrinkerCommand.УВІЙТИ
    "вийти" -> BeerDrinkerCommand.ВИЙТИ
    "сьорб" -> BeerDrinkerCommand.СЬОРБ
    "риг" -> BeerDrinkerCommand.РИГ
    "де" -> BeerDrinkerCommand.ДЕ
    "хелп" -> BeerDrinkerCommand.ХЕЛП
    else -> BeerDrinkerCommand.РИГ

}



