import scala.collection.mutable.ListBuffer

case class Employee(name: String, salary: Int, age: Int)

object ListSortTest {

  def main(args: Array[String]): Unit = {

    var employeeList = ListBuffer[Employee]()

    var emp1 =  Employee("Abhishek", 4300, 21)
    var emp2 =  Employee("Vaibhavi", 2100, 32)
    var emp3 =  Employee("Pratik", 7322, 24)

    employeeList.addOne(emp1)
    employeeList.addOne(emp2)
    employeeList.addOne(emp3)

    println("Original empList :: ")

    printArrListElement(employeeList)

    var sorted = employeeList.sortBy(emp => emp.name)


    println("Sorted List ::" + sorted)
    printArrListElement(sorted)


  }

  def printArrListElement(listBuffer: ListBuffer[Employee]) {
    listBuffer.foreach(emp => println(emp))
  }

}
