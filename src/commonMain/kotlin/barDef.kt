interface IBar {
    val beerVolume: Int
    val capacity: Int
    val menu: Menu
    val employees: List<Employee>
    var isOpen: Boolean

    fun open()

    fun close()

    fun serveBeer()
}

class Bar : IBar {
    override val beerVolume: Int = 500
    override val capacity: Int = 50
    override val menu: Menu = fillMenu()
    override val employees: List<Employee> = hireEmployees()
    override var isOpen: Boolean = false

    override fun open() {
        isOpen = true
    }

    override fun close() {
        isOpen = false
    }

    override fun serveBeer() {
        TODO("Not yet implemented")
    }

    private fun fillMenu(): Menu {
        val prices = mapOf(
            "Світле" to 20,
            "Темне" to 40,
            "Моча" to 15,
            "Смачне" to 35,
            "Бланш" to 70,
            "Жигулівське" to 50,
        )
        return Menu(prices)
    }

    private fun hireEmployees(): List<Employee> =
        listOf(
            Employee(name = "Бармен"),
            Employee(name = "Вишибала"),
            Employee(name = "Клафілінщіца"),
            Employee(name = "Директор"),
            Employee(name = "Офіціант")
        )
}

data class Menu(val prices: Map<String, Int>)

data class Employee(val name: String)
