package voa.tdd.shoppingcart

import scala.collection.immutable.Map
import scala.collection.mutable.ListBuffer

class ShoppingCart(appleDeal:Boolean = false) {

  private val productPrices = Map("Apple" -> 60, "Orange" -> 25)
  private val productList = ListBuffer[String]()
//  private val appleDealValid

//  def apply(appleDeal:Boolean = false)

  def addProduct(productName: String) {
    productList += productName
  }

  def addProducts(products: List[String]){
    productList ++= products
  }

  def calculateTotal: String = {
    val appleAmount = productList.count(_ == "Apple")
    val orangeAmount = productList.count(_ == "Orange")

    val appleTotalCost = appleDeal match {
      case true => ((appleAmount / 2) + (appleAmount % 2)) * getPriceForProduct("Apple")
      case false => appleAmount * getPriceForProduct("Apple")
    }

    val orangeTotalCost = orangeAmount * getPriceForProduct("Orange")

    toPoundFormat(appleTotalCost + orangeTotalCost)
  }

  private def getPriceForProduct(productName: String): Int = {
    productPrices.get(productName).getOrElse(0)
  }

  private def toPoundFormat(pence: Int): String = {
    "£" + (pence.toDouble / 100)
  }

}
