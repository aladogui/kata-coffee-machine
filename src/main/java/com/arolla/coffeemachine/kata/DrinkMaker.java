package com.arolla.coffeemachine.kata;

public interface DrinkMaker {

  void sendRequest(Order order);

  void sendMessage(String missingMoneyMessage);
}
