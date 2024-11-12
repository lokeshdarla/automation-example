package org.lokeshdarla;

public class Item {
  double shippingWeight;
  String description;

  public Item(double shippingWeight, String description) {
    this.shippingWeight = shippingWeight;
    this.description = description;
  }

  public double getPriceForQuantity() {
    return 100.0 * shippingWeight;
  }

  public double getTax() {
    return 0.18;
  }

  public double getShippingWeight() {
    return shippingWeight;
  }

  public boolean inStock() {
    return true;
  }
}
