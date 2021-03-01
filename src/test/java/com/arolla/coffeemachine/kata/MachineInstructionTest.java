package com.arolla.coffeemachine.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MachineInstructionTest {

  MachineInstruction machineInstruction;

  @BeforeEach
  void setUp() {
    machineInstruction= new MachineInstruction();
  }

  @Test
  public void should_return_formatted_message(){
    String messageContent = "Please wait ...";
    Assertions.assertEquals("M:"+messageContent,machineInstruction.getMessage(messageContent));
  }


}