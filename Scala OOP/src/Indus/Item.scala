package Indus

/**
 * @author Benton
 */
class Item(i: Int, d: Description) {
  private var id = i
  private var desc = d
  
  def getID() = this.id
  def getDesc() = this.desc.toString()
  
  override def toString() = "[ID: " + this.getID + " | Description: " + this.getDesc() +"]" +"\n"
  
}

object Item {
  private var nextID = 500
  def apply(d: Description) = new Item(getNextID(), d)
  def getNextID() : Int = {
    nextID +=1
    nextID
  }
}