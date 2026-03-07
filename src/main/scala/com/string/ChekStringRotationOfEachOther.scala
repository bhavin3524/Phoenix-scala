package com.string

import scala.collection.mutable.ListBuffer

object ChekStringRotationOfEachOther {

  def main(args: Array[String]): Unit = {
    var str1 = "XY12"
    var permutationList = allPermutationsOfStr(str1)
    println(permutationList.mkString(" "))

  }

  def allPermutationsOfStr(str: String): List[String] = {
    if (str.isEmpty) {
      return List("")
    }

    var permutationListIterator = str.permutations

    var permutatonList = permutationListIterator
      .map(element => element).toList

    return permutatonList
  }
}
