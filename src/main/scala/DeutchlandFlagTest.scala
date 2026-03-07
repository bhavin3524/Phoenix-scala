import scala.collection.mutable.ListBuffer

object DeutchlandFlagTest {
  def main(args: Array[String]): Unit = {

    var listBuffer: ListBuffer[Int] = ListBuffer(0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1)

//    println("Head :: " + listBuffer.head)
//
//    println("Tail :: " + listBuffer.tail)

    println("input list :: " + listBuffer.mkString(" "))

    var resultedSortedList = sortAnArr(listBuffer)
    println(resultedSortedList.mkString(" "))


  }

  def sortAnArr(listBuffer: ListBuffer[Int]): ListBuffer[Int] = {

    if (listBuffer.isEmpty) {
      return listBuffer
    }


    var resultList = sortAnArr(listBuffer.slice(1, listBuffer.length))

    var firstElement: Int = listBuffer.head

    if (resultList.isEmpty) {
      resultList.addOne(listBuffer.head)
    }

    if (firstElement == 0) {

      resultList.insert(0, firstElement)

    }

    if (firstElement == 2) {
      resultList.addOne(firstElement)
    }

    if (firstElement == 1) {
      var lastIndexOfZero: Int = resultList.lastIndexOf(0)
      var firstIndexOfTwo = resultList.indexOf(2)



      if (lastIndexOfZero != -1) {
        resultList.insert(lastIndexOfZero + 1, firstElement)
        return resultList
      }
      if (firstIndexOfTwo != -1) {
        resultList.insert(firstIndexOfTwo, firstElement)
        return resultList

      }
      resultList.addOne(firstElement)

    }

    resultList
  }
}
