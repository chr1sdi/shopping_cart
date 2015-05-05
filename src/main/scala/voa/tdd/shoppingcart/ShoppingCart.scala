package voa.tdd.shoppingcart

import scala.collection.immutable.Map
import scala.collection.mutable.ListBuffer

class ShoppingCart {

  private val productPrices = Map("Apple" -> 60, "Orange" -> 25)
  private val productList = ListBuffer[String]()

  def addProduct(productName: String) {
    productList += productName
  }

  def addProducts(products: List[String]){
    productList ++= products
  }

  def calculateTotal: String = {
    val sumInPence = productList.foldLeft(0) {
      (a, b) => a + getPriceForProduct(b)
    }

    toPoundFormat(sumInPence)
  }

  private def getPriceForProduct(productName: String): Int = {
    productPrices.get(productName).getOrElse(0)
  }

  private def toPoundFormat(pence: Int): String = {
    "£" + (pence.toDouble / 100)
  }

}
