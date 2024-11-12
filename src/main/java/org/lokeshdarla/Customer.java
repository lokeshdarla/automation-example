package org.lokeshdarla;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String name;
  private String address;
  private List<Order> orders = new ArrayList<>();

  public Customer(String name, String address) {
    this.name = name;
    this.address = address;
  }

  // Getter and Setter for name
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // Getter and Setter for address
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  // Getter for orders
  public List<Order> getOrders() {
    return orders;
  }

  // Setter for orders
  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }

  // Method to add a single order
  public void addOrder(Order order) {
    orders.add(order);
  }
}
