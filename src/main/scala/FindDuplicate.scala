import scala.collection.mutable.ListBuffer

object FindDuplicate {

  def main(args: Array[String]): Unit = {
    findDuplicate(ListBuffer(11, 34, 56, 32, 11, 34, 56, 99, 77))
  }

  def findDuplicate(listBuffer: ListBuffer[Int]): Map[Int, ListBuffer[Int]] = {

    var frequencyCountElementMap:Map[Int, ListBuffer[Int]] = listBuffer
      .groupBy(element => element)

    for (elem <- frequencyCountElementMap) {
      val key = elem._1
      val values = elem._2

      println(key + " -- > " + values.size)
    }

    var resultedMap = frequencyCountElementMap
      .filter(entry => entry._2.size>1)
      .toMap

    println(resultedMap.mkString(" "))



    frequencyCountElementMap
  }

}
