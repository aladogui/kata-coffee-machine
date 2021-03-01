package com.arolla.coffeemachine.kata.types;

import java.util.Objects;

public class Tea extends Drink{

  private final char code ='T';

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
    final Tea tea = (Tea) o;
    return code == tea.code;
  }

  @Override
  public int hashCode() {
    return Objects.hash(code);
  }

  @Override
  public String toString() {
    return "Tea";
  }
}
