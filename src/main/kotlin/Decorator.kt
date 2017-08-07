// Component
interface CoffeeMachine {
    fun makeSmallCoffee()
    fun makeLargeCoffee()
}

// Concreate Component
class NormalCoffeeMachine : CoffeeMachine {
    override fun makeSmallCoffee() = println("Normal: Making small coffee")

    override fun makeLargeCoffee() = println("Normal: Making large coffee")
}

//Decorator:
class EnhancedCoffeeMachine(val coffeeMachine: CoffeeMachine)
    : CoffeeMachine by coffeeMachine {

    // overriding behaviour
    override fun makeLargeCoffee() {
        println("Enhanced: Making large coffee")
        coffeeMachine.makeLargeCoffee()
    }

    // extended behaviour
    fun makeCoffeeWithMilk() {
        println("Enhanced: Making coffee with milk")
        coffeeMachine.makeSmallCoffee()
        println("Enhanced: Adding milk")
    }
}

////Decorator:
//class EnhancedCoffeeMachineTest(val coffeeMachine: CoffeeMachine)
//    : CoffeeMachine {
//
//    // overriding behaviour
//    override fun makeLargeCoffee() {
//        println("Enhanced: Making large coffee")
//        coffeeMachine.makeLargeCoffee()
//    }
//}

fun main(args: Array<String>) {
    val normalMachine = NormalCoffeeMachine()
    val enhancedMachine = EnhancedCoffeeMachine(normalMachine)

    println(normalMachine)
    println(enhancedMachine)


    // non-overridden behaviour
    enhancedMachine.makeSmallCoffee()

    // overriding behaviour
    enhancedMachine.makeLargeCoffee()
    // extended behaviour
    enhancedMachine.makeCoffeeWithMilk()
}
