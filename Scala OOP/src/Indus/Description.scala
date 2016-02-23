package Indus

/**
 * @author Benton
 */
class Description(d: String, p: Double, s: String) {
  private var desc = d
  private var price = p
  private var supplier = s 
  
  override def toString() = this.desc + " | " + this.price + " | " + this.supplier
}

object Description {
  def apply(d: String, p: Double, s: String) = new Description(d, p, s)
}