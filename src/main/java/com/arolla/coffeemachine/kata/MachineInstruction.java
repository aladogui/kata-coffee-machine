package com.arolla.coffeemachine.kata;

public class MachineInstruction {

  Order order;
  DrinkMaker drinkMaker;

  public String getMessage(String messageContent){
    return "M:" + messageContent;
  }

  public String makeDrink(float amount, Order order) {
    if (order.getDrinkType().isEnoughMoney(amount)) {
      float missingMoney = order.getDrinkType().getMissingMoney(amount);
      return getMissingMoneyMessage(missingMoney);
    } else {
      drinkMaker.sendRequest(order);
      return getMessage("Drink processing ...");
    }
  }

  public String getMissingMoneyMessage( float missingMoney){
    return getMessage("Missing € " + missingMoney );
  }

}

