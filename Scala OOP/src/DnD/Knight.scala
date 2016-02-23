package DnD

/**
 * @author Benton
 */
class Knight(val name: String, var hp: Int = 100) {
  
  def attack(victim: Dragon, damage: Int) {
    victim.hp -= damage
  }
}

object Knight {
  def apply(name: String, health: Int) = new Knight(name, health)
}