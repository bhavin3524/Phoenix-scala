package patternmatching

import scala.collection.mutable.ListBuffer

object Play1 {

  def main(args: Array[String]): Unit = {

    var name = "Vaidi"

    var result = processName(name)

    var inputList = ListBuffer(32, 44, 21, 45, 17)

    var resultList = processList(inputList)


    println(result)

    println(resultList)
  }

  def processName(str: String): String = {


    str match {
      case ("Abhi") => {
        return "Hello Abhishek"
      }
      case ("Vaidi") => {
        return "Hello Vaidi"
      }
      case _ => {
        return "Hello Default Case"
      }
    }


    return str
  }

  def processList(listBuffer: ListBuffer[Int]): ListBuffer[Int] = {

    var result = listBuffer match {
      case (ListBuffer(17)) => ListBuffer(32)
      case (ListBuffer(32, 44, 21, 45, 17)) => ListBuffer(32, 44, 88)
      case (ListBuffer(32, _, _, _, _)) => ListBuffer(32, 44)
      case _ => {
        var emptyList = ListBuffer[Int]()
        return emptyList
      }
    }

    return result
  }


}
