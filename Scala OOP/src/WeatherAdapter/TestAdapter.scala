package WeatherAdapter

/**
 * @author Benton
 */
object TestAdapter extends App {
  println((new FarenTemp).getMeanTemperature(List("San Francisco, San Jose, Oakland")))
}