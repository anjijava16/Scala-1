package Jawa

class Boole(val value: Boolean) extends Literal { 
  override def toString() = {
    value.toString()
  }
}
//tostring