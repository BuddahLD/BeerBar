package com.danylooliinyk.gmail.beerbar

class BeerDrinker {
    private val stomachSize: Byte = FIVE_LITRES
    private var isInBar: Boolean = false


    fun drinkBeer() {
        if (isInBar) {
            println("Можна замовити пива")
        } else {
            println("Я ще не в барі")

        }
    }

    fun enterBar() {
        isInBar = true
    }

    fun exitBar(){
        isInBar = false
    }

    companion object {
        private const val FIVE_LITRES = 5.toByte()
    }
}
