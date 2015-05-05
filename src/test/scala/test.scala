package voa.tdd.test.shoppingcart

import org.scalatest._
import voa.tdd.shoppingcart.ShoppingCart


class ShoppingCartTests extends FlatSpec  with Matchers {

   it should "return 0.0 without any products" in {
     val sut = new ShoppingCart()
     sut.calculateTotal should be(0.0)
   }

  it should "sum price of 1 apple correctly" in {
    val sutSC = new ShoppingCart()

    sutSC.addProduct("Apple")

    sutSC.calculateTotal should be(0.6)
  }




}
