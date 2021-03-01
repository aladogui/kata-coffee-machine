package com.arolla.coffeemachine.kata.types;

import java.util.Objects;

public class Coffee extends Drink {

  private final char code ='C';
  private final float price =0.6f;
  private final boolean isPermittedExtraHotOption = true;


  public boolean isPermittedExtraHotOption() {
    return isPermittedExtraHotOption;
  }

  public float getPrice() {
    return price;
  }

  public char getCode() {
    return code;
  }

  @Override
  public String toString() {
    return "Coffee";
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Coffee coffee = (Coffee) o;
    return code == coffee.code;
  }

  @Override
  public int hashCode() {
    return Objects.hash(code);
  }
}
