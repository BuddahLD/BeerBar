package com.danylooliinyk.gmail.beerbar

class BeerDrinker(var isInBar: Boolean = false) {
    private val stomachSize: Byte = FIVE_LITRES
    private val stomach: IStomach = Stomach()

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

    fun exitBar() {
        isInBar = false
    }

    companion object {
        private const val FIVE_LITRES = 5.toByte()
    }
}

fun BeerDrinker.executeCommand(command: BeerDrinkerCommand) = when(command) {
    BeerDrinkerCommand.УВІЙТИ -> enterBar()
    BeerDrinkerCommand.ВИЙТИ -> exitBar()
    BeerDrinkerCommand.СЬОРБ -> println("команда ще в розробці")
    BeerDrinkerCommand.РИГ -> println("команда ще в розробці")
    BeerDrinkerCommand.ДЕ -> println("команда ще в розробці")
}

interface IStomach {

    fun fill(volume: Byte)
}


private class Stomach : IStomach {
    private var stomachFilling: Int = 0

    override fun fill(volume: Byte) {
        if (volume < 0) {
            println("в шлунку вакууму не буває")
            return
        }
        stomachFilling += volume
        if ((stomachFilling + volume) <= STOMACH_SIZE) {
            stomachFilling += volume
            println("заповненість шлунку: $stomachFilling/$STOMACH_SIZE")
        } else {
            println("ти луснув")
            return
        }
        if (stomachFilling == STOMACH_SIZE) {
            println("фатить")
        }
    }

    companion object {
        const val STOMACH_SIZE = 5
    }
}

enum class BeerDrinkerCommand {
    УВІЙТИ,
    ВИЙТИ,
    СЬОРБ,
    РИГ,
    ДЕ,
}

