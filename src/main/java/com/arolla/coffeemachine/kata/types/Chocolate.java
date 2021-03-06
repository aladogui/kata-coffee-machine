package com.arolla.coffeemachine.kata.types;

import java.util.Objects;

public class Chocolate extends Drink{

  private final char code ='H';
  private final float price =0.5f;
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
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Chocolate chocolate = (Chocolate) o;
    return code == chocolate.code;
  }

  @Override
  public int hashCode() {
    return Objects.hash(code);
  }

  @Override
  public String toString() {
    return "Chocolate";
  }
}
