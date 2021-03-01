package com.arolla.coffeemachine.kata.types;

import java.util.Objects;

public class Juice extends Drink{

  private final char code ='O';
  private final float price = 0.6f;
  private final boolean isPermittedExtraHotOption = false;


  public boolean isPermittedExtraHotOption() {
    return isPermittedExtraHotOption;
  }

  public char getCode() {
    return code;
  }

  public float getPrice() {
    return price;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Juice juice = (Juice) o;
    return code == juice.code;
  }

  @Override
  public int hashCode() {
    return Objects.hash(code);
  }

  @Override
  public String toString() {
    return "Orange juice";
  }
}
