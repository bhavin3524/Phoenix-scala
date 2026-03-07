package com.string

import scala.collection.mutable._

object PermutationOfStr {

  def main(args: Array[String]): Unit = {
    processPermutation("ABC")
  }

  def processPermutation(str: String): ListBuffer[String] = {

    var permutations = str.permutations

//    println("All Permutations Of Str" + permutations.mkString(" "))

    for (itr <- permutations) {
      println(itr)
    }

    return ListBuffer()
  }

}
