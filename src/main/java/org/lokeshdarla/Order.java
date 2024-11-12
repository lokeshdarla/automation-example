package org.lokeshdarla;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
  Date date;
  String status;
  List<OrderDetail> orderDetails = new ArrayList<>();
  List<Payment> payments = new ArrayList<>();

  public Order(Date date, String status) {
    this.date = date;
    this.status = status;
  }

  public double calcSubTotal() {
    double subTotal = 0;
    for (OrderDetail detail : orderDetails) {
      subTotal += detail.calcSubTotal();
    }
    return subTotal;
  }

  public double calcTax() {
    double tax = 0;
    for (OrderDetail detail : orderDetails) {
      tax += detail.calcTax();
    }
    return tax;
  }

  public String getStatus() {
    return this.status;
  }

  public double calcTotal() {
    return calcSubTotal() + calcTax();
  }

  public double calcTotalWeight() {
    double totalWeight = 0;
    for (OrderDetail detail : orderDetails) {
      totalWeight += detail.calcWeight();
    }
    return totalWeight;
  }

  public void addOrderDetail(OrderDetail detail) {
    orderDetails.add(detail);
  }

  public void addPayment(Payment payment) {
    payments.add(payment);
  }

  public double totalPayment() {
    double tp = 0;
    for (Payment payment : payments) {
      tp += payment.amount;
    }
    return tp;
  }

  public List<OrderDetail> getOrderDetails() {
    return this.orderDetails;
  }

  public void billClear() {
    if (this.calcTotal() == this.totalPayment()) {
      System.out.println("Bill Paid Successfully");
    } else if (this.calcTotal() > this.totalPayment()) {
      System.out.println("Customer Paid " + (this.calcTotal() - this.totalPayment()) + " Extra");
    } else {
      System.out.println("Customer need to pay " + (this.totalPayment() - this.calcTotal()));
    }
  }
}
