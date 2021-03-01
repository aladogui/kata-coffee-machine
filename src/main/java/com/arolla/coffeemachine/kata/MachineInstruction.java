package com.arolla.coffeemachine.kata;

public class MachineInstruction {

  Order order;

  public String getMessage(String messageContent){
    return "M:" + messageContent;
  }

}

