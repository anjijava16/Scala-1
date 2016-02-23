package DnD

object Dungeon {
  
  def main(args: Array[String]) {
      val random = new scala.util.Random(System.nanoTime())
      val k = Knight("Flaaf", 100)
      val d = Dragon("Mr. D", 100)
      
      var timer = 0 // time to track turns (0 is knight, 1 is dragon)
      while (k.hp > 0 && d.hp > 0) {
        if (timer == 0) {
          var kdamage = random.nextInt(k.hp)
          k.attack(d, kdamage)
          println("Knight " + k.name + " attacked Dragon " + d.name + " for " + kdamage + " damage." + " Dragon " + d.name + " is at " + d.hp)
          timer = 1
        } else {
          var ddamage = random.nextInt(d.hp)
          d.attack(k, ddamage)
          println("Dragon " + d.name + " attacked Knight " + k.name + " for " + ddamage + " damage." + " Knight " + k.name + " is at " + k.hp)
          timer = 0
        }
      }
      if(k.hp <= 0) println("Knight " + k.name + " has died. RIP") else println("Dragon " + d.name + " has died. RIP");
    }
}