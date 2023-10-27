package com.danylooliinyk.gmail.beerbar

/**
 * The entry point of our stepBasedBar.
 */
fun main() {
    val commands = mutableMapOf("увійти" to "Зайти в бар", "вийти" to "Вийти з бару", "сьорб" to "Випити пива", "риг" to "Відригнути", "де" to "Я в барі?")
    commands.forEach { entry ->
        println("${entry.key} -> ${entry.value} ")

    }
    val player = BeerDrinker()
    val isInBarPhrase = if (player.isInBar) "В барі" else "Поза баром"
    println("Гравець зараз: $isInBarPhrase")
    println("Введіть команду:")
    val userInput = readln()
    val userInputString = handleCommand(command = userInput)
    println(userInputString)
}

fun handleCommand(command: String): String = when (command) {
    "увійти" -> "Зайти в бар"
    "вийти" -> "Команда ще в розробці"
    "сьорб" -> "Команда ще в розробці"
    "риг" -> "Команда ще в розробці"
    "де" -> "Команда ще в розробці"
    else -> "Такої команди не існує і існувати не буде"
}



