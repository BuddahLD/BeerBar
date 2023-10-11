package com.danylooliinyk.gmail.beerbar

class BeerDrinker {
    private val stomachSize: Byte = FIVE_LITRES
    private var isInBar: Boolean = false
    private val stomach: IStomach = object : IStomach {
        override fun fill(volume: Byte) {
            println("Бахнули: $volume")
        }
    }

    fun drinkBeer(volume: Byte) {
        if (isInBar) {
            stomach.fill(volume)
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
