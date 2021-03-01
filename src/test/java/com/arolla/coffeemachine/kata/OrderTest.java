package com.arolla.coffeemachine.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.arolla.coffeemachine.kata.types.Coffee;
import com.arolla.coffeemachine.kata.types.Juice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderTest {

  private Order order;

  @BeforeEach
  void setUp() {
    order = new Order(new Coffee());
  }

  @Test
  public void should_return_coffee_instruction_order_with_sugar(){
    order.addOneSugar();
    assertEquals("C:1:0",order.toString());
  }

  @Test
  public void should_add_stick_when_create_order_with_sugar(){
    order = new Order(new Coffee(), 2);
    assertTrue(order.hasStick());
  }

  @Test
  public void should_return_coffee_instruction_order() {
    assertEquals("C::", order.toString());
  }

  @Test
  public void should_return_hasSugar_true_when_sugar_present() {
    order.addOneSugar();
    assertTrue(order.hasSugar());
  }

  @Test
  public void should_return_withStick_true_when_sugar_exist() {
    order.addOneSugar();
    assertTrue(order.hasStick());
  }

  @Test
  public void should_return_current_number_of_sugar_plus_one_when_add_one_sugar() {
    assertEquals(order.getNumberOfSugar(), 0);
    order.addOneSugar();
    assertEquals(order.getNumberOfSugar(), 1);
  }

  @Test
  public void should_return_current_number_of_sugar_plus_two_when_add_two_sugar() {
    assertEquals(order.getNumberOfSugar(), 0);
    order.addTwoSugar();
    assertEquals(order.getNumberOfSugar(), 2);
  }


  @Test
  public void cannot_make_juice_order_extraHot(){
    Order juiceOrder = new Order(new Juice(), true);
    Assertions.assertFalse(juiceOrder.isExtraHot());
  }

  @Test
  public void should_return_extraHot_order_drink(){
    Order coffeeOrder = new Order(new Coffee(), true);
    Assertions.assertTrue(coffeeOrder.isExtraHot());
  }

}



