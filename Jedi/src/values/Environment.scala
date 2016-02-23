package values

import expressions._
import ui._
import scala.collection.mutable.HashMap

class Environment(var prevE: Environment = null) extends HashMap[Identifier, Value] with Value {

  override def contains(id: Identifier): Boolean = {
    super.contains(id) || (prevE != null && prevE.contains(id))
  }
  
  override def apply(id: Identifier): Value = {
    if (super.contains(id)) {
      super.apply(id)
    } else if (prevE != null) {
      prevE.apply(id)
    } else {
      throw new UndefinedException(id.value)
    }
  }
}