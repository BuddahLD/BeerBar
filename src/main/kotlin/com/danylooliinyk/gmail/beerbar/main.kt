package com.danylooliinyk.gmail.beerbar

/**
 * The entry point of our stepBasedBar.
 */
fun main() {
    val commands = mutableMapOf(
        "увійти" to "Зайти в бар",
        "вийти" to "Вийти з бару",
        "сьорб" to "Випити пива",
        "риг" to "Відригнути",
        "де" to "Я в барі?"
    )
    val player = BeerDrinker()
    // Навчити BeerDrinker говорити
    while (true) {
        val isInBarPhrase = if (player.isInBar) "В барі" else "Поза баром"
        println("Гравець зараз: $isInBarPhrase")
        println("Доступні команди:")
        commands.forEach { entry ->
            println("${entry.key} -> ${entry.value} ")
        }
        println("Введіть команду:")
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
    else -> BeerDrinkerCommand.РИГ
}



