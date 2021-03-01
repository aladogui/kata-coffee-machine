package com.arolla.coffeemachine.kata.types;

public abstract class Drink {

  protected Drink() {
  }

  public abstract char getCode();
  public abstract float getPrice();

  public boolean isEnoughMoney(float amount){
    return getPrice() > amount;
  }

  public float getMissingMoney(final float insertedAmount){
    return 0f;
  }

}
