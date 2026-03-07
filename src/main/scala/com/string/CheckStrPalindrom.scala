package com.string

object CheckStrPalindrom {

  def main(args: Array[String]): Unit = {
    var inputStr : String = "abba"

    println("is palindrom :: " + checkPalindrom(inputStr))
  }

  def checkPalindrom(str: String): Boolean = {
     str.equalsIgnoreCase(str.reverse)
  }

}
