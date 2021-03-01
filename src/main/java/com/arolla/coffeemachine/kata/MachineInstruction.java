package com.arolla.coffeemachine.kata;

public class MachineInstruction {

  Order order;

  public String getMessage(String messageContent){
    return "M:" + messageContent;
  }

  public String makeDrink(float amount, Order order){
    return null;
  }

  public String getMissingMoneyMessage( float missingMoney){
    return "";
  }

}

