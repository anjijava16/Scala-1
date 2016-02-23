package WeatherAdapter

/**
 * @author Benton
 */
class FarenTemp extends CenTherm with IThermometer {
  def getMeanTemperature(cities: List[String]): Double = {
    var sum = cities.map(computeTemp(_)).sum
    sum /= cities.size
    sum = sum*(9/5) + 32
    sum
  }
}