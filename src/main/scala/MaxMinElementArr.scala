import scala.collection.mutable.ListBuffer

object MaxMinElementArr {

  def main(args: Array[String]): Unit = {
    val numbers: Array[Int] = Array(32, 54, 99, 32, 67, 21, 12, 88)

    println("Original Arr::" + numbers.mkString(" "))

    val maxNo = numbers.max
    val min = numbers.min

    println(maxNo)
    println(min)

    val sortedArr = numbers.sorted

    var listBuffer = ListBuffer(32, 54, 99, 32, 67, 21, 12, 88)

    listBuffer.max
    listBuffer.min

    println(sortedArr.mkString(", "))

    val k:Int = 3

//    val kthMin = k;

    println("Kth Min" + sortedArr(k-1))

    println("Kth Max" + sortedArr(sortedArr.length  - k))

    println("subarr :: " + sortedArr.slice(2, 6).mkString(" "))

  }

}
