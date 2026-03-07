package com.string

import scala.collection.mutable

object FindDuplicateCharacters {

  def main(args: Array[String]): Unit = {

    var str = "hello#abhishek#vishnubhai"

    coundCharacters(str)
  }

  def coundCharacters(str: String): Map[Char, Int] = {


    var chCountMap: Map[Char, String] = str.groupBy(ch => ch)

//    var list = List("Abhi", "Vaidi", "Vishnu", "Bhavin", "Abhi", "Vaidi")
//
//    for (elem <- list.groupBy(word => word)) {
//      var k = elem._1
//      var v = elem._2
//
//      println(k + " --> " + v)
//    }

    for (entry <- chCountMap) {
      var k = entry._1
      var v = entry._2

      println(k + " --> " + v)
    }
    return Map()
  }

}
