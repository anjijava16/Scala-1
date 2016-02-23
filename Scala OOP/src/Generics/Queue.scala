package Generics

import scala.collection.mutable.ArrayBuffer

/**
 * @author Benton
 */
class Queue[T] {

  private var queue = new ArrayBuffer[T]
  var size = 0

  def enqueue(e: T) {
    queue += e
    size += 1
  }

  def dequeue(): T = {
    if (size == 0) throw new Exception("Empty queue")
    queue.remove(0)
  }

  def isEmpty() = {
    if (queue.isEmpty) {
      true
    } else false
  }

  override def toString(): String = {
    queue.toString()
  }
}

object Queue {
  def apply = new Queue

}

object Test extends App {
  var waitingList = new Queue[String]
  waitingList.enqueue("Jim")
  waitingList.enqueue("Bob")
  waitingList.enqueue("Joe")
  waitingList.enqueue("Flaaf")
  waitingList.enqueue("Tay")

  while (!waitingList.isEmpty()) {
    println(waitingList.dequeue().toString())
  }
}