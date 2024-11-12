package org.lokeshdarla;

public abstract class Payment {
  float amount;

  public Payment(float amount) {
    this.amount = amount;
  }

  public float getAmount() {
    return this.amount;
  }
}
