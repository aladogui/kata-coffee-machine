package com.arolla.coffeemachine.kata;

import com.arolla.coffeemachine.kata.types.Drink;

public class Order {

  private Drink drinkType;
  private int numberOfSugar;
  private boolean withStick;
  private boolean extraHot;

  public Order(final Drink drinkType) {

    this.drinkType = drinkType;
  }

  public Order(final Drink drinkType, final int numberOfSugar) {
    this.drinkType = drinkType;
    this.numberOfSugar = numberOfSugar;
    this.withStick = numberOfSugar != 0;
  }

  public Order(final Drink drinkType, final boolean extraHot) {
    this.drinkType = drinkType;
    this.extraHot = extraHot && drinkType.isPermittedExtraHotOption();
  }

  public Order(final Drink drinkType, final int numberOfSugar, final boolean extraHot) {
    this.drinkType = drinkType;
    this.numberOfSugar = numberOfSugar;
    this.withStick = numberOfSugar != 0;
    this.extraHot = extraHot && drinkType.isPermittedExtraHotOption();
  }

  public boolean isExtraHot() {
    return extraHot;
  }

  public boolean hasSugar() {
    return numberOfSugar != 0;
  }

  public boolean hasStick() {
    if (hasSugar()) {
      withStick = true;
    }
    return withStick;
  }

  public void addOneSugar() {
    this.withStick= true;
    this.numberOfSugar = numberOfSugar + 1;
  }

  public void addTwoSugar() {
    this.withStick= true;
    this.numberOfSugar = numberOfSugar + 2;
  }

  public int getNumberOfSugar() {
    return numberOfSugar;
  }

  public Drink getDrinkType() {
    return drinkType;
  }

  public String toString() {
    return this.drinkType.getCode()
        + (this.isExtraHot() ? "h" : "")
        + ":"
        + (this.numberOfSugar != 0 ? this.numberOfSugar : "")
        + ":"
        + (this.withStick ? 0 : "");
  }

}
