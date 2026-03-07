import scala.collection.mutable.ListBuffer

object CyclicallyRotateList {

  def main(args: Array[String]): Unit = {

    var resultList: ListBuffer[Int] = cyclicallyRotate(ListBuffer(1, 2, 3, 4, 5, 6, 7), 3)

    println(resultList.mkString(" "))
  }

  //  Input: nums = [1,2,3,4,5,6,7], k = 3
  //  Output: [5,6,7,1,2,3,4]
  //  Explanation:
  //    rotate 1 steps to the right: [7,1,2,3,4,5,6]
  //    rotate 2 steps to the right: [6,7,1,2,3,4,5]
  //    rotate 3 steps to the right: [5,6,7,1,2,3,4]

  def cyclicallyRotate(inputList: ListBuffer[Int], target: Int): ListBuffer[Int] = {



    if (target == 0) {
      return inputList
    }

    var subArrList = inputList.slice(0, inputList.size - 1)

    val t = target - 1

    var list = List(34, 22, 18, 44)

    list = 47 +: list

    var subList = list.slice(2, list.size)
    println(subList)

    val appendElement: ListBuffer[Int] = inputList.slice(inputList.size - 1, inputList.size)

    subArrList = appendElement ++ subArrList

    cyclicallyRotate(subArrList, t)

  }

}
