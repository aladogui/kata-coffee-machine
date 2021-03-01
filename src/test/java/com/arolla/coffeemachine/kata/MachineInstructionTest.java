package com.arolla.coffeemachine.kata;

import static org.mockito.MockitoAnnotations.initMocks;

import com.arolla.coffeemachine.kata.types.Coffee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

public class MachineInstructionTest {

  public static final String DRINK_PROCESSING = "M:Drink processing...";
  MachineInstruction machineInstruction;
  Order order;

  @Mock
  DrinkMaker drinkMaker;

  @BeforeEach
  void setUp() {
    initMocks(this);
    machineInstruction= new MachineInstruction();
    order = new Order(new Coffee());
    doNothing().when(drinkMaker).sendRequest(any(Order.class));
  }

  @Test
  public void should_return_formatted_message(){
    String messageContent = "Please wait ...";
    Assertions.assertEquals("M:"+messageContent,machineInstruction.getMessage(messageContent));
  }

  @Test
  public void should_return_missing_money_message_when_enough_money(){
    Assertions.assertEquals("M:Missing € 0.4", machineInstruction.makeDrink(0.2f, order));
  }

  @Test
  public void should_return_formatted_message_of_missing_money(){
    Assertions.assertEquals("M:Missing € 0.1", machineInstruction.getMissingMoneyMessage(0.1f));
  }


}