package DnD

/**
 * @author Benton
 */
class Dragon(val name: String, var hp: Int = 100) {
  
  def attack(victim: Knight, damage: Int) {
    victim.hp -= damage
  }  
}

object Dragon {
  def apply(name: String, health: Int) = new Dragon(name, health)
}