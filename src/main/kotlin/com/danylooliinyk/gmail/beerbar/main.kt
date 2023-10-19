package com.danylooliinyk.gmail.beerbar

/**
 * The entry point of our stepBasedBar.
 */
fun main() {
    println(
        """
            Команди: 
            - Зайти в бар -> зайти
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
