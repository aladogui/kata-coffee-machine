package com.arolla.coffeemachine.kata.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DrinkTest {

  Drink drink;

  @BeforeEach
  void setUp() {
    drink= new Coffee();
  }

  @Test
  public void should_return_missing_money(){
    assertEquals(0.2f, drink.getMissingMoney(0.4f));
  }

}