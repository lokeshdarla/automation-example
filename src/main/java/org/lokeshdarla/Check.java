package org.lokeshdarla;

public class Check extends Payment {
  String name;
  String bankID;

  public Check(float amount, String name, String bankID) {
    super(amount);
    this.name = name;
    this.bankID = bankID;
  }

  public boolean authorized() {
    return true;
  }
}
