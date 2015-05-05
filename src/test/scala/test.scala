package voa.tdd.test.shoppingcart

import org.scalatest._
import voa.tdd.shoppingcart.ShoppingCart


class ShoppingCartTests extends FlatSpec  with Matchers {

   it should "return £0.0 without any products" in {
     val sut = createNewShoppingCart()
     sut.calculateTotal should be("£0.0")
   }

  it should "sum the total price of 1 apple correctly" in {
    val sutSC = createNewShoppingCart()

    sutSC.addProduct("Apple")

    sutSC.calculateTotal should be("£0.6")
  }

  it should "sum the total price of 1 orange correctly" in {
    val sutSC = createNewShoppingCart()

    sutSC.addProduct("Orange")

    sutSC.calculateTotal should be("£0.25")
  }

  it should "sum the total price of multiple apples correctly" in {
    val sutSC = createNewShoppingCart()

    sutSC.addProducts(List("Apple", "Apple", "Apple"))

    sutSC.calculateTotal should be("£1.8")
  }

  it should "sum the total price of multiple oranges correctly" in {
    val sutSC = createNewShoppingCart()

    sutSC.addProducts(List("Orange", "Orange", "Orange"))

    sutSC.calculateTotal should be("£0.75")
  }

  it should "sum the total price of multiple items correctly" in {
    val sutSC = createNewShoppingCart()

    sutSC.addProducts(List("Orange", "Apple", "Apple", "Orange", "Orange"))

    sutSC.calculateTotal should be("£1.95")
  }

  it should "sum the total price of added independently multiple items correctly" in {
    val sutSC = createNewShoppingCart()

    sutSC.addProduct("Orange")
    sutSC.addProduct("Orange")
    sutSC.addProduct("Apple")
    sutSC.addProduct("Orange")
    sutSC.addProduct("Apple")
    sutSC.addProduct("Apple")

    sutSC.calculateTotal should be("£2.55")
  }

  behavior of "Apple deal 2 for 1"
  "ShoppingCart with apple deal" should "sum 2 apples for the price of 1" in {
    val sutSC = createNewShoppingCart(withAppleDeal = true)

    sutSC.addProduct("Apple")
    sutSC.addProduct("Apple")

    sutSC.calculateTotal should be("£0.6")
  }

  it should "sum 2 apples for the price of 1 for multiple items" in {
    val sutSC = createNewShoppingCart(withAppleDeal = true)

    sutSC.addProduct("Apple")
    sutSC.addProduct("Apple")
    sutSC.addProduct("Orange")
    sutSC.addProduct("Apple")
    sutSC.addProduct("Apple")
    sutSC.addProduct("Orange")
    sutSC.addProduct("Apple")

    sutSC.calculateTotal should be("£2.3")
  }





  private def createNewShoppingCart(withAppleDeal: Boolean = false): ShoppingCart = new ShoppingCart(withAppleDeal)


}
