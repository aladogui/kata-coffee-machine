package com.arolla.coffeemachine.kata;

import com.arolla.coffeemachine.kata.types.Coffee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MachineInstructionTest {

  public static final String DRINK_PROCESSING = "Drink processing...";
  MachineInstruction machineInstruction;
  Order order;

  @BeforeEach
  void setUp() {
    machineInstruction= new MachineInstruction();
    order = new Order(new Coffee());
  }

  @Test
  public void should_return_formatted_message(){
    String messageContent = "Please wait ...";
    Assertions.assertEquals("M:"+messageContent,machineInstruction.getMessage(messageContent));
  }

  @Test
  public void should_return_missing_money_message_when_enough_money(){
    Assertions.assertEquals(DRINK_PROCESSING,machineInstruction.makeDrink(0.2f, order));
  }

  @Test
  public void should_return_formatted_message_of_missing_money(){
    Assertions.assertEquals("Missing € 0.1", machineInstruction.getMissingMoneyMessage(0.1f));
  }


}