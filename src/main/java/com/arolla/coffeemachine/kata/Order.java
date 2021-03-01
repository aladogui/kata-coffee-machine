package com.arolla.coffeemachine.kata;

import com.arolla.coffeemachine.kata.types.Drink;

public class Order {

  private Drink drinkType;
  private int numberOfSugar;
  private boolean withStick;

  public Order(final Drink drinkType) {
    this.drinkType = drinkType;
  }

  public Order(final Drink drinkType, final int numberOfSugar) {
    this.drinkType = drinkType;
    this.numberOfSugar = numberOfSugar;
  }

  public boolean hasSugar(){
    return false;
  }

  public boolean hasStick(){
    return false;
  }

  public void addOneSugar(){

  }

  public void addTwoSugar(){

  }

  public int getNumberOfSugar() {
    return numberOfSugar;
  }

  public Drink getDrinkType() {
    return drinkType;
  }

  public String toString(){
    return "";
  }

}
