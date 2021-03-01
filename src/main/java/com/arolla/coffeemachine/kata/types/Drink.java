package com.arolla.coffeemachine.kata.types;

public abstract class Drink {

  protected Drink() {
  }

  public abstract char getCode();
  public abstract float getPrice();

  public boolean isPermittedExtraHotOption(){
    return true;
  }

  public boolean isEnoughMoney(float amount){
    return getPrice() >= amount;
  }

  public float getMissingMoney(final float insertedAmount){
    return isEnoughMoney(insertedAmount) ? (Math.round((getPrice() - insertedAmount)*100f)/100f) : 0.0f;
  }

}
