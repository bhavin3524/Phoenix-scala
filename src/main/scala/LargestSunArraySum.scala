import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object LargestSunArraySum {

  def main(args: Array[String]): Unit = {
    val target = 11
    var resultMap = largestSumArraySum(ListBuffer(2, 3, -8, 7, -1, 2, 3), target)

    var listBuffer = ListBuffer(1, 5, 8, 10)

    var subsets = ListBuffer[ListBuffer[Int]]()

    for(i <- 0 to listBuffer.size by 1)
      {
        var combi = listBuffer.combinations(i)

       while(combi.hasNext)
         {
           subsets.addOne(combi.next())
         }

      }

    for( sub <- subsets)
    {
      println(sub.mkString(" "))
    }

    var str = "abhishek"

    //    for(var entry <- resultMap.)

//    for (elem <- resultMap) {
//      val key = elem._1
//      val values = elem._2
//
//      println(key.mkString(" ") + " -> " + values)
//    }

//    println(resultMap.mkString(" "))
  }

  def largestSumArraySum(listBuffer: ListBuffer[Int], target: Int): mutable.Map[ListBuffer[Int], Int] = {

    var subArrSumMap = mutable.Map[ListBuffer[Int], Int]()
    for (i <- 0 to listBuffer.size by 1) {
      for (j <- i to listBuffer.size by 1) {
        val subArrList: ListBuffer[Int] = listBuffer.slice(i, j);
        val subArrListSum: Int = calculateSum(subArrList)
        if (subArrListSum == target) {
          subArrSumMap.put(subArrList, subArrListSum)
        }
      }
    }

    subArrSumMap
  }

  def calculateSum(subArrList: ListBuffer[Int]): Int = {
    subArrList.sum
  }

}
