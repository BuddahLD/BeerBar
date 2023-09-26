class BeerDrinker {
    private val stomachSize: Byte = FIVE_LITRES

    fun drinkBeer(skoka: Byte) {
        if (skoka <= stomachSize) {
            println("О клас я випив пива")
        } else {
            println("Йойо стільки не влізе")
        }
    }

    fun drinkBeer(glass: Glass): Glass = when(glass.isFull) {
        true -> {
            println("Норм йобнув")
            glass.isFull = false
            glass
        }
        false -> glass
    }

    companion object {
        private const val FIVE_LITRES = 5.toByte()
    }
}
