package Jawa

class Number (val value: Double) extends Literal { 
  override def toString() = {
    value.toString()
  }
}

//tostring