package com.danylooliinyk.gmail.beerbar

/**
 * The entry point of our stepBasedBar.
 */
fun main() {
    println(
        """
            Команди: 
            - Зайти в бар -> увійти
            - Вийти з бару -> вийти
            - Випити пива -> сьорб
            - Відригнути -> риг
            - Я в барі? -> де
        """.trimIndent()
    )
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



