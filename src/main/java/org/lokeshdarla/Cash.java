package org.lokeshdarla;

public class Cash extends Payment {
  float cashTendered;

  public Cash(float amount, float cashTendered) {
    super(amount);
    this.cashTendered = cashTendered;
  }
}
