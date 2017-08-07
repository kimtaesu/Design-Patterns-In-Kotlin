// Adapter
interface Temperature {
    var temperature: Double
}

// Adaptee
class CelsiusTemperature(override var temperature: Double) : Temperature

// Target
class FahrenheitTemperature(var celsiusTemperature: CelsiusTemperature) : Temperature {

    override var temperature: Double
        get() {
            println("call get() ${convertCelsiusToFahrenheit(celsiusTemperature.temperature)}")
            return convertCelsiusToFahrenheit(celsiusTemperature.temperature)
        }
        set(temperatureInF) {
            println("call set(temperatureInF) ${temperatureInF}")
            celsiusTemperature.temperature = convertFahrenheitToCelsius(temperatureInF)
        }

    private fun convertFahrenheitToCelsius(f: Double): Double = (f - 32) * 5 / 9

    private fun convertCelsiusToFahrenheit(c: Double): Double = (c * 9 / 5) + 32
}

fun main(args: Array<String>) {
    val celsiusTemperature = CelsiusTemperature(0.0)
    val fahrenheitTemperature = FahrenheitTemperature(celsiusTemperature)

    celsiusTemperature.temperature = 36.6
    println("${celsiusTemperature.temperature} C -> ${fahrenheitTemperature.temperature} F")

    fahrenheitTemperature.temperature = 100.0
    println("${fahrenheitTemperature.temperature} F -> ${celsiusTemperature.temperature} C")
}
