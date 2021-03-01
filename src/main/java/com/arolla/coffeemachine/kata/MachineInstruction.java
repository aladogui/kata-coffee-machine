package com.arolla.coffeemachine.kata;

public class MachineInstruction {

  Order order;
  DrinkMaker drinkMaker;
  MachineStoreRepository machineStoreRepository;
  BeverageQuantityChecker beverageQuantityChecker;
  EmailNotifier emailNotifier;

  public MachineInstruction() {
    this.machineStoreRepository = new MachineStoreRepository();
  }

  public String getMessage(String messageContent){
    return "M:" + messageContent;
  }

  public String makeDrink(float amount, Order order) {
    if (isMissingBeverage()) {
      if (isMissingWater()) {
        emailNotifier.notifyMissingDrink("water");
        return "Shortage water!";
      }
      if (isMissingMilk()) {
        emailNotifier.notifyMissingDrink("milk");
        return "Shortage milk!";
      }
    }
    if (order.getDrinkType().isNotEnoughMoney(amount)) {
      float missingMoney = order.getDrinkType().getMissingMoney(amount);
      String missingMoneyMessage= getMissingMoneyMessage(missingMoney);
      drinkMaker.sendMessage(missingMoneyMessage);
      return missingMoneyMessage;
    } else {
      drinkMaker.sendRequest(order);
      machineStoreRepository.addOrder(order);
      return getMessage("Drink processing ...");
    }
  }

  public String getMissingMoneyMessage( float missingMoney){
    return getMessage("Missing € " + missingMoney );
  }

  private boolean isMissingBeverage() {
    return isMissingMilk() || isMissingWater();
  }

  private boolean isMissingWater() {
    return beverageQuantityChecker.isEmpty("water") ;
  }

  private boolean isMissingMilk() {
    return beverageQuantityChecker.isEmpty("milk") ;
  }


}

