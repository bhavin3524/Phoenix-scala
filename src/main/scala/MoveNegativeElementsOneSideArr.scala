import scala.collection.mutable.ListBuffer

object MoveNegativeElementsOneSideArr {

  def main(args: Array[String]): Unit = {
      var resultList = moveNegativeElements(ListBuffer(-12, 11, -13, -5, 6, -7, 5, -3, -6))
    println(resultList)
  }

  def moveNegativeElements(inputList: ListBuffer[Int]): ListBuffer[Int] = {

    if (inputList.isEmpty) {
      return inputList
    }

    var resultList = moveNegativeElements(inputList.slice(1, inputList.size))

    var firstElement = inputList(0);

    if(firstElement<0)
      {
        resultList.insert(0, firstElement)
      }

    if(firstElement>=0)
      {
        resultList.addOne(firstElement)
      }
    return resultList
  }

}
