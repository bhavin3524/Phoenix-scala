import scala.collection.mutable.ListBuffer

object ReverseAnArray {

  def main(args: Array[String]): Unit = {
//    println(reverseArr(Array("abhi", "vaidi", "pratik")))

    var inputList = ListBuffer("Abhi", "Vaidi", "Pratik", "Geeta", "Vishnu");

    println("sortedList -> " + inputList.sorted)
    println("reversedList ->" + inputList.reverse)
    println("reversedList -> " + reverseArrList(inputList))


  }

  def reverseArrList(listBuffer: ListBuffer[String]): ListBuffer[String] = {

    if(listBuffer.isEmpty)
      {
        return listBuffer
      }

    var reversedList = reverseArrList(listBuffer.slice(1, listBuffer.size))
    reversedList.addOne(listBuffer(0))



    reversedList
  }

  def reverseArr(array: Array[String]): Array[String] = {

    var i: Int = 0
    var j: Int = array.length - 1

    while (i < j) {
      swapElements(array, i, j)
      i = i + 1;
      j = j - 1;
    }
    array
  }

  def swapElements(array: Array[String], i: Int, j: Int): Unit = {
    val temp = array(i)
    array(i) = array(j)
    array(j) = temp
  }

}
