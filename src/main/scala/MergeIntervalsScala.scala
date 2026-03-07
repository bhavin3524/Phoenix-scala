import scala.collection.mutable.ListBuffer

object MergeIntervalsScala {

  def main(args: Array[String]): Unit = {
    val testCases: List[ListBuffer[ListBuffer[Int]]] = List(

      // 1. Basic overlapping intervals
      ListBuffer(
        ListBuffer(1, 3),
        ListBuffer(2, 6),
        ListBuffer(8, 10),
        ListBuffer(15, 18)
      ),

      // 2. Fully contained intervals
      ListBuffer(
        ListBuffer(1, 10),
        ListBuffer(2, 3),
        ListBuffer(4, 8),
        ListBuffer(11, 12)
      ),

      // 3. No overlaps
      ListBuffer(
        ListBuffer(1, 2),
        ListBuffer(4, 5),
        ListBuffer(7, 8),
        ListBuffer(10, 11)
      ),

      // 4. All intervals merge into one
      ListBuffer(
        ListBuffer(1, 4),
        ListBuffer(2, 5),
        ListBuffer(3, 6),
        ListBuffer(4, 7)
      ),

      // 5. Touching intervals (merge)
      ListBuffer(
        ListBuffer(1, 3),
        ListBuffer(3, 5),
        ListBuffer(5, 7),
        ListBuffer(8, 10)
      ),

      // 6. Mixed overlapping and non-overlapping
      ListBuffer(
        ListBuffer(1, 2),
        ListBuffer(2, 4),
        ListBuffer(10, 12),
        ListBuffer(11, 13)
      ),

      // 7. Single interval
      ListBuffer(
        ListBuffer(3, 8)
      ),

      // 8. Already merged intervals
      ListBuffer(
        ListBuffer(1, 10),
        ListBuffer(11, 20)
      )
    )

    // Run all test cases
    var testCaseNum = 1
    for (intervals <- testCases) {

      val sortedInput = intervals.sortBy(_(0))

      val result = mergeIntervalsTest(
        ListBuffer(sortedInput.head.clone()),
        sortedInput.tail.map(_.clone()).to(ListBuffer)
      )

      // Convert ListBuffer[ListBuffer[Int]] to flat string of numbers
      def flattenIntervals(list: ListBuffer[ListBuffer[Int]]): String = {
        list.map(inner => inner.mkString(" ")).mkString(" ")
      }

      println(s"Test Case $testCaseNum:")
      println(s"Input:  ${sortedInput.mkString(" ")}")
      println(s"Output: ${flattenIntervals(result)}")
      println("-------------------------------------")

      testCaseNum += 1
    }
  }

  def mergeIntervalsTest(resultList: ListBuffer[ListBuffer[Int]], inputIntervalList: ListBuffer[ListBuffer[Int]]): ListBuffer[ListBuffer[Int]] = {

    if (inputIntervalList.isEmpty) {
      return resultList
    }

    // [[1,3],[2,6],[8,10],[15,18]]

    var currentInterval = inputIntervalList(0)

    var previousInterval = resultList(0)

    var currentFirst = currentInterval(0)
    var currentSecond = currentInterval(1)

    var previousFirst = previousInterval(0)
    var previousSecond = previousInterval(1)

    var newInterval = ListBuffer[Int]()
    if (currentFirst <= previousSecond) {
      newInterval.addOne(previousFirst)
      newInterval.addOne(currentSecond)

      var tempResult = resultList.slice(0, resultList.size - 1)

      tempResult.addOne(newInterval)
      return mergeIntervalsTest(tempResult, inputIntervalList.slice(1, inputIntervalList.size))


    } else {
      newInterval.addOne(currentFirst)
      newInterval.addOne(currentSecond)

      resultList.addOne(newInterval)
      return mergeIntervalsTest(resultList, inputIntervalList.slice(1, inputIntervalList.size))
    }


  }
}
