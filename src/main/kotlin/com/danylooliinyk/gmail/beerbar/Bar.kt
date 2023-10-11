package com.danylooliinyk.gmail.beerbar

interface Bar {
    val capacity: Int
    val menu: Menu
}

data class Menu(val prices: Map<String,Int>)
