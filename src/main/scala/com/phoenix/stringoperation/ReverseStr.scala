

object ReverseStr
{
    def main(args: Array[String]): Unit = {
        val str = "abhishek"
        println(s"Original String: $str")
        val reversed = reverseStr(str)
        println(s"Reversed String: $reversed")
    }

    def reverseStr(str: String): String = {
        if(str.isEmpty)
        {
            return str
        }


    return reverseStr(str.substring(1)) + str.charAt(0)
    }
}