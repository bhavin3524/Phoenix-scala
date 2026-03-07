import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object TripletSum {

  def main(args: Array[String]): Unit = {
    var resultMap = getAllTripletArraySum(ListBuffer(1, 4, 45, 6, 10, 8), 13)

//    println(resultMap.mkString(" "))

    for(entry <- resultMap)
    {
      var key = entry._1
      var value = entry._2

      println(key + " --> " + value)
    }

//    for(var entry <- resultMap)
  }

  def getAllTripletArraySum(listBuffer: ListBuffer[Int], target: Int) : mutable.Map[ListBuffer[Int], Int] = {

    var subsetResult = listBuffer.combinations(3)

    var tripletListSum = mutable.Map[ListBuffer[Int], Int]()
    for(subSet <- subsetResult)
      {
        if(subSet.sum == target)
          {
            tripletListSum.put(subSet, subSet.sum)
          }
      }

    return tripletListSum
  }

}
