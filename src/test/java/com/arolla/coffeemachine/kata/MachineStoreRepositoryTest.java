package com.arolla.coffeemachine.kata;

import static org.junit.jupiter.api.Assertions.*;

import com.arolla.coffeemachine.kata.types.Chocolate;
import com.arolla.coffeemachine.kata.types.Coffee;
import com.arolla.coffeemachine.kata.types.Drink;
import com.arolla.coffeemachine.kata.types.Juice;
import com.arolla.coffeemachine.kata.types.Tea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MachineStoreRepositoryTest {

  MachineStoreRepository machineRepository;

  @BeforeEach
  void setUp() {
    machineRepository = new MachineStoreRepository();
    machineRepository.addOrder(new Order(new Coffee()));
    machineRepository.addOrder(new Order(new Coffee()));
    machineRepository.addOrder(new Order(new Tea()));
    machineRepository.addOrder(new Order(new Chocolate()));
    machineRepository.addOrder(new Order(new Juice()));
    machineRepository.addOrder(new Order(new Juice()));
  }

  @Test
  public void should_return_list_of_drink_ordered(){
    Drink[] orderedDrink = new Drink[]{new Coffee(), new Tea(), new Juice(), new Chocolate()};
    Assertions.assertArrayEquals(orderedDrink, machineRepository.getListOfOrderedDrinkType().toArray());
  }

  @Test
  public void should_return_total_number_of_ordered_drink_by_type(){
    Assertions.assertEquals(2, machineRepository.getNumberOfOrderByDrinkType('C'));
  }

  @Test
  public void should_return_total_amount_earned(){
    Assertions.assertEquals(3.3, machineRepository.getTotalAmountEarned());
  }

  @Test
  public void should_return_report() {

    final String report =
        "{" + "C: " + 2 + ";" + "T: " + 1 + ";" + "H: " + 1 + ";" + "O: " + 2 + "}";
    Assertions.assertEquals(report, machineRepository.printReport());
  }
}