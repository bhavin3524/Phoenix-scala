import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object BestTimeBuySellStock {

  def main(args: Array[String]): Unit = {
    var hashMap = mutable.LinkedHashMap[ListBuffer[Int], Int]()
        val resultMap = bestTimeBuySell(ListBuffer(7, 1, 5, 3, 6, 4), hashMap)

//    val resultMap = bestTimeBuySellStocks(ListBuffer(7, 1, 5, 3, 6, 4))

    for (result <- resultMap) {
      val k = result._1
      val v = result._2

      println("[" + k.mkString(" ") + "] ---> " + v)
    }
  }

  def bestTimeBuySellStocks(stockPriceList: ListBuffer[Int]): mutable.LinkedHashMap[ListBuffer[Int], Int] = {
    val stockBuySellDifference = mutable.LinkedHashMap[ListBuffer[Int], Int]()


    for (i <- 0 to stockPriceList.size - 1) {
      for (j <- i to stockPriceList.size - 1) {
        val stockPriceSubList = stockPriceList.slice(i, j + 1)
        println(stockPriceSubList)

        val buyPrice = stockPriceSubList(0)
        val sellPrice = stockPriceSubList(stockPriceSubList.size - 1)

        val result = sellPrice - buyPrice

        stockBuySellDifference.put(stockPriceSubList, result)
      }
    }


    stockBuySellDifference
  }

  def bestTimeBuySell(stockPriceList: ListBuffer[Int], resultMap: mutable.LinkedHashMap[ListBuffer[Int], Int]): mutable.Map[ListBuffer[Int], Int] = {

    if (stockPriceList.isEmpty) {
      return resultMap
    }


    for (i <- 0 to stockPriceList.size - 1 by 1) {

      var subList = stockPriceList.slice(0, i + 1)

      val buyPrice = subList(0)
      val sellPrice = stockPriceList(subList.length - 1)

      val result = sellPrice - buyPrice

      resultMap.put(subList, result)
    }

    bestTimeBuySell(stockPriceList.slice(1, stockPriceList.size), resultMap)


  }

}
