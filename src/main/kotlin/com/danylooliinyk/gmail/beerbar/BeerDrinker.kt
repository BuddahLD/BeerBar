package com.danylooliinyk.gmail.beerbar

import com.danylooliinyk.gmail.beerbar.Stomach.Companion.STOMACH_SIZE

class BeerDrinker(var isInBar: Boolean = false) {
    private val stomachSize: Byte = FIVE_LITRES
    private val stomach: IStomach = Stomach()
    val stomachFillingString: String
        get() = stomach.stomachFillingString

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

fun BeerDrinker.location() = when (isInBar) {
    true -> "В барі"
    false -> "Не в барі"
}

val commands = mutableMapOf(
    "увійти" to "Зайти в бар",
    "вийти" to "Вийти з бару",
    "сьорб" to "Випити пива",
    "риг" to "Відригнути",
    "де" to "Я в барі?",
    "Хелп" to "Доступні команди"
)

fun BeerDrinker.executeCommand(command: BeerDrinkerCommand) = when (command) {
    BeerDrinkerCommand.УВІЙТИ -> enterBar()
    BeerDrinkerCommand.ВИЙТИ -> exitBar()
    BeerDrinkerCommand.СЬОРБ -> println("команда ще в розробці")
    BeerDrinkerCommand.РИГ -> println("команда ще в розробці")
    BeerDrinkerCommand.ДЕ -> println(location())
    BeerDrinkerCommand.ХЕЛП -> {
        println("Доступні команди:")
        commands.forEach { entry ->
            println("${entry.key} -> ${entry.value} ")
        }
    }
}

interface IStomach {
    var stomachFilling: Int

    fun fill(volume: Byte)
}

val IStomach.stomachFillingString: String
    get() = "$stomachFilling/$STOMACH_SIZE"

class Stomach : IStomach {
    override var stomachFilling: Int = 0

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
    ХЕЛП,
}
