import java.net.URLConnection
import java.util.*

//Based on: http://stackoverflow.com/a/13030163/361832


// Abstract Product
interface Plant

// Concreate Product
class OrangePlant : Plant

// Concreate Product
class ApplePlant : Plant

// Abstract Factory
abstract class PlantFactory {
    abstract fun makePlant(): Plant

    companion object {
        inline fun <reified T : Plant> createFactory(): PlantFactory = when (T::class) {
            OrangePlant::class -> OrangeFactory()
            ApplePlant::class -> AppleFactory()
            else -> throw IllegalArgumentException() as Throwable
        }
    }
}

// Concreate Factory
class AppleFactory : PlantFactory() {
    override fun makePlant(): Plant = ApplePlant()
}

// Concreate Factory
class OrangeFactory : PlantFactory() {
    override fun makePlant(): Plant = OrangePlant()
}

fun main(args: Array<String>) {
    val a = ArrayList<String>()
    a.iterator()
    val plantFactory = PlantFactory.createFactory<OrangePlant>()
    val plant = plantFactory.makePlant()
    println("Created plant: $plant")
}