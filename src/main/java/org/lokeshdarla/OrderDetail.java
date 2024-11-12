package org.lokeshdarla;

public class OrderDetail {
  int quantity;
  String taxStatus;
  Item item;

  public OrderDetail(int quantity, String taxStatus, Item item) {
    this.quantity = quantity;
    this.taxStatus = taxStatus;
    this.item = item;
  }

  public double calcWeight() {
    return item.getShippingWeight() * quantity;
  }

  public double calcTax() {
    if (this.taxStatus == "Taxable") {
      return item.getTax() * item.getPriceForQuantity() * quantity;
    } else {
      return 0;
    }
  }

  public Item getItem() {
    return this.item;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public String getTaxStatus() {
    return this.taxStatus;
  }

  public double calcSubTotal() {
    return item.getPriceForQuantity() * quantity;
  }
}
