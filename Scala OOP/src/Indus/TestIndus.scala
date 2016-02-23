package Indus

import scala.collection.mutable.ArrayBuffer

/**
 * @author Benton
 */
object TestIndus extends App {
  var Inventory = new ArrayBuffer[Item]
  var matrix = Item(Description("The Matrix DVD", 15.50, "DVD World"))
  var terminator = Item(Description("The Terminator DVD", 13.25, "DVD World"))
  var ironman = Item(Description("The IronMan DVD", 18.00, "DVD Planet"))
  
  Inventory+= matrix
  Inventory+= matrix
  Inventory+= matrix
  Inventory+= matrix
  Inventory+= matrix
  Inventory += terminator
  Inventory += terminator
  Inventory += terminator
  Inventory+= ironman
  Inventory+= ironman
  
  println(Inventory)
}