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
}

fun inputCommand(command: String): String =
    when (command) {
        readln("увійти") -> "Зайти в бар"
        readln("вийти") -> "Команда ще в розробці"
        readln("сьорб") -> "Команда ще в розробці"
        readln("риг") -> "Команда ще в розробці"
        readln("де") -> "Команда ще в розробці"
        else -> "Такої команди не існує і існувати не буде"
    }