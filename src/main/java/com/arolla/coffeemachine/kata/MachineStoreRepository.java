package com.arolla.coffeemachine.kata;

import com.arolla.coffeemachine.kata.types.Drink;
import java.util.ArrayList;
import java.util.List;

public class MachineStoreRepository {

  List<Order> orders;

  public MachineStoreRepository() {
    this.orders = new ArrayList<>();
  }

  public void addOrder(Order newOrder){

  }

  public long getNumberOfOrderByDrinkType(char drinkType){
    return 0;
  }

  public double getTotalAmountEarned(){
    return 0d;
  }

  public List<Drink> getListOfOrderedDrinkType(){
    return new ArrayList<>();
  }

  public List<Order> getOrders(){
    if(orders == null){
      orders =  new ArrayList<>();
    }
    return orders;
  }

  public String printReport(){
    return "";
  }
}
