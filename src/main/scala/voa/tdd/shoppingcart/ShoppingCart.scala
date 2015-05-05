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

  def calculateTotal: Double = {
    productList.foldLeft(0) {
      (a, b) => a + getPriceForProduct(b)
    }.toDouble / 100
  }

  private def getPriceForProduct(productName: String): Int = {
    productPrices.get(productName).getOrElse(0)
  }
}
