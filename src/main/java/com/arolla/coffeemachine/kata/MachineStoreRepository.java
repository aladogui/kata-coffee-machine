package com.arolla.coffeemachine.kata;

import com.arolla.coffeemachine.kata.types.Drink;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MachineStoreRepository {

  List<Order> orders;

  public MachineStoreRepository() {
    this.orders = new ArrayList<>();
  }

  public long getNumberOfOrderByDrinkType(char drinkType){
    return orders.stream().filter(order -> order.getDateTime().isAfter(LocalDateTime.now().minusDays(1)) && order.getDrinkType().getCode() == drinkType).count();
  }

  public double getTotalAmountEarned(){
    return Math.round(orders.stream().mapToDouble(value -> value.getDrinkType().getPrice()).sum()*100d)/100d ;
  }

  public List<Drink> getListOfOrderedDrinkType(){
    return orders.stream().map(Order::getDrinkType).distinct().collect(Collectors.toList());
  }

  public void addOrder(Order order){
    orders.add(order);
  }

  public List<Order> getOrders(){
    if(orders == null){
      orders =  new ArrayList<>();
    }
    return orders;
  }

  public String printReport(){
    StringBuilder report= new StringBuilder("{");
    for (Drink drink : getListOfOrderedDrinkType()) {
      report.append(drink.getCode()).append(": ").append(getNumberOfOrderByDrinkType(drink.getCode())).append(";");
    }
    report.append("\n Total amount of money earned : ").append(getTotalAmountEarned()).append("€ ");
    report.append("}");
    System.out.println(report.toString());
    return report.toString();
  }
}
