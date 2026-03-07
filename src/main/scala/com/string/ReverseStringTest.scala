package com.string

object ReverseStringTest {

  def main(args: Array[String]): Unit = {

    val inputStr: String = "abhishek"

    println(inputStr.reverse)

    println("Reverse Str using Recursion ::" + reverseStrTest(inputStr))

  }

  def reverseStrTest(inputStr: String): String = {

    if (inputStr.isEmpty) {
      return inputStr
    }

    return reverseStrTest(inputStr.substring(1)) + inputStr.charAt(0)
  }

  def reverseStr(str: String) : String = {
    if(str.isEmpty)
    {
      return str
    }

    reverseStr("str.substring")
  }

}
