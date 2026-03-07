import scala.collection.mutable

object NashTechTest {

  def targetSum(arr: Array[Int], target: Int): Int = {

    val subArraySumMap: mutable.Map[String, Int] = mutable.Map[String, Int]()

    for (i <- arr.indices) {
      for (j <- i until arr.length) {

        val subArr: Array[Int] = arr.slice(i, j + 1)

        val totalSum: Int = calculateSum(subArr)

        if (target == totalSum) {
          subArraySumMap(subArr.mkString(",")) = totalSum
        }
      }
    }

    println(subArraySumMap)

    subArraySumMap.size
  }

  def calculateSum(arr: Array[Int]): Int = {
    var sum: Int = 0

    for (i <- arr.indices) {
      sum = sum + arr(i)
    }
    sum
  }

  def main(args: Array[String]): Unit = {
    var result: Int = targetSum(Array(1, 2, -1, 1), 3)
  }
}
