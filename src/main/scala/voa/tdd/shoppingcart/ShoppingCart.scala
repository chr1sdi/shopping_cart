package voa.tdd.shoppingcart

import scala.collection.immutable.Map
import scala.collection.mutable.ListBuffer

class ShoppingCart {

  private val productPrices = Map("Apple" -> 0.65, "Orange" -> 0.25)
  private val products = ListBuffer[String]()

  def addProduct(productName: String) {
    products += productName
  }

  def calculateTotal: Double = {
    products.foldLeft(0.0) {
      (a, b) => 0.6
    }

  }

  private def getPriceForProduct(productName: String): Double = {
    productPrices.get(productName).getOrElse(0.0)
  }
}
