package WeatherAdapter

/**
 * @author Benton
 */
trait IThermometer {
   def getMeanTemperature(cities : List[String]): Double
}