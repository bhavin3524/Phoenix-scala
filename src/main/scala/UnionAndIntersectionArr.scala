import scala.collection.mutable.ListBuffer

object UnionAndIntersectionArr {

  def main(args: Array[String]): Unit = {


    var resultList = intersectionOfArr(ListBuffer(23, 33, 44, 55, 66, 77), ListBuffer(33, 44, 77, 11, 88, 51))

    println(resultList.mkString(" "))

    var unionList = unionOfArr(ListBuffer(23, 33, 44, 55, 66, 77), ListBuffer(33, 44, 77, 11, 88, 51))
    println(unionList)
  }


  def intersectionOfArr(list1: ListBuffer[Int], list2: ListBuffer[Int]): ListBuffer[Int] = {

    val intersectionList: ListBuffer[Int] = list1.intersect(list2);

     intersectionList

  }

  def unionOfArr(list1: ListBuffer[Int], list2: ListBuffer[Int]): ListBuffer[Int] = {
    var unionList = list1.concat(list2)

     unionList
  }
}
