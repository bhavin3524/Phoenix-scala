package com.string

import scala.collection.mutable.ListBuffer

object SubSequenceOfStr {

  def main(args: Array[String]): Unit = {
    getAllSubSequences("geeks")
  }

  def getAllSubSequences(str: String): ListBuffer[String] = {

    for (i <- 1 to str.length by 1) {
      var subsets = str.combinations(i)
      println(subsets.mkString(" "))
    }

    return ListBuffer()
  }

}
