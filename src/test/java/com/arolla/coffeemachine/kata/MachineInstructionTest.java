package com.arolla.coffeemachine.kata;

import static org.mockito.MockitoAnnotations.initMocks;

import com.arolla.coffeemachine.kata.types.Coffee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

public class MachineInstructionTest {

  public static final String DRINK_PROCESSING = "M:Drink processing ...";
  Order order;

  @Mock
  DrinkMaker drinkMaker;

  @Mock
  BeverageQuantityChecker beverageQuantityChecker;

  @Mock
  EmailNotifier emailNotifier;

  @InjectMocks
  MachineInstruction machineInstruction;

  @BeforeEach
  void setUp() {
    initMocks(this);
    order = new Order(new Coffee());
    doNothing().when(drinkMaker).sendRequest(any(Order.class));
  }

  @Test
  public void should_return_shortage_water_message(){
    doNothing().when(emailNotifier).notifyMissingDrink(anyString());
    when(beverageQuantityChecker.isEmpty("water")).thenReturn(true);
    Assertions.assertEquals("Shortage water!", machineInstruction.makeDrink(0.8f, order));
    verify(emailNotifier, times(1)).notifyMissingDrink(anyString());
  }

  @Test
  public void should_return_shortage_milk_message(){
    doNothing().when(emailNotifier).notifyMissingDrink(anyString());
    when(beverageQuantityChecker.isEmpty("milk")).thenReturn(true);
    Assertions.assertEquals("Shortage milk!", machineInstruction.makeDrink(0.8f, order));
    verify(emailNotifier).notifyMissingDrink(anyString());
  }


  @Test
  public void should_return_formatted_message(){
    String messageContent = "Please wait ...";
    Assertions.assertEquals("M:"+messageContent,machineInstruction.getMessage(messageContent));
  }

  @Test
  public void should_return_missing_money_message_when_enough_money(){
    Assertions.assertEquals("M:Missing € 0.4", machineInstruction.makeDrink(0.2f, order));
    verify(drinkMaker).sendMessage("M:Missing € 0.4");

  }

  @Test
  public void should_call_drinkMaker_to_make_drink(){
    Assertions.assertEquals(DRINK_PROCESSING, machineInstruction.makeDrink(0.8f, order));
    verify(drinkMaker).sendRequest(any(Order.class));
  }

  @Test
  public void should_return_formatted_message_of_missing_money(){
    Assertions.assertEquals("M:Missing € 0.1", machineInstruction.getMissingMoneyMessage(0.1f));
  }


}