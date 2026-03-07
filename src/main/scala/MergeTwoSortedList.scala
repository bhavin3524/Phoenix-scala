import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object MergeTwoSortedList {

  def main(args: Array[String]): Unit = {
    val resultListBuffer: ListBuffer[Int] = mergeTwoSortedArrList(ListBuffer(1, 2, 9, 10), ListBuffer(3, 4, 5, 6), ListBuffer())
    println(resultListBuffer.mkString(" "))
  }

  def mergeTwoSortedArrList(list1: ListBuffer[Int], list2: ListBuffer[Int], resultList: ListBuffer[Int]): ListBuffer[Int] = {


    @tailrec
    def processList(list1: ListBuffer[Int], list2: ListBuffer[Int], resultList: ListBuffer[Int]) : ListBuffer[Int] = {
      if (list1.isEmpty) {
        resultList.addAll(list2)
        return resultList
      }

      if (list2.isEmpty) {
        resultList.addAll(list1)
        return resultList;
      }

      if (list1(0) > list2(0)) {
        resultList.addOne(list2(0))
        processList(list1, list2.slice(1, list2.size), resultList)
      } else {
        resultList.addOne(list1(0))
        processList(list1.slice(1, list1.size), list2, resultList)
      }

    }


     var result =  processList(list1, list2, resultList)
    return result
  }

}
