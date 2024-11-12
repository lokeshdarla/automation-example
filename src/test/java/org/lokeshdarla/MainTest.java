package org.lokeshdarla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

  private Customer customer;
  private Item item1;
  private Item item2;
  private Order order;
  private Payment cashPayment;
  private Payment checkPayment;
  private Payment creditPayment;

  @BeforeEach
  void setUp() {
    customer = new Customer("Vimal", "Hyderabad");
    item1 = new Item(25, "Rice");
    item2 = new Item(15, "Maize");
    order = new Order(new Date(), "Processing");

    // Set up order details
    order.addOrderDetail(new OrderDetail(5, "Taxable", item1));
    order.addOrderDetail(new OrderDetail(20, "Non-Taxable", item2));

    // Add the order to the customer
    customer.addOrder(order);

    // Set up payments
    cashPayment = new Cash(12500, 12500);
    checkPayment = new Check(2250, "Vimal", "1001");
    creditPayment = new Credit(30000, "Vimal", "Savings", new Date());

    // Add payments to the order
    order.addPayment(cashPayment);
    order.addPayment(checkPayment);
    order.addPayment(creditPayment);
  }

  @Test
  void testCustomerDetails() {
    assertEquals("Vimal", customer.getName());
    assertEquals("Hyderabad", customer.getAddress());
  }

  @Test
  void testOrderDetails() {
    assertEquals(1, customer.getOrders().size());
    Order customerOrder = customer.getOrders().get(0);
    assertEquals("Processing", customerOrder.getStatus());
    assertEquals(2, customerOrder.getOrderDetails().size());
  }

  @Test
  void testOrderDetailItems() {
    OrderDetail orderDetail1 = order.getOrderDetails().get(0);
    OrderDetail orderDetail2 = order.getOrderDetails().get(1);

    assertEquals("Rice", orderDetail1.getItem().getDescription());
    assertEquals("Maize", orderDetail2.getItem().getDescription());

    assertEquals(5, orderDetail1.getQuantity());
    assertEquals("Taxable", orderDetail1.getTaxStatus());

    assertEquals(20, orderDetail2.getQuantity());
    assertEquals("Non-Taxable", orderDetail2.getTaxStatus());
  }

  @Test
  void testTotalOrderPayment() {
    double expectedTotalPayment = 12500 + 2250 + 30000;
    assertEquals(expectedTotalPayment, order.totalPayment(), 0.01);
  }

  @Test
  void testPaymentTypes() {
    assertTrue(cashPayment instanceof Cash);
    assertTrue(checkPayment instanceof Check);
    assertTrue(creditPayment instanceof Credit);

    assertEquals(12500, cashPayment.getAmount());
    assertEquals(2250, checkPayment.getAmount());
    assertEquals(30000, creditPayment.getAmount());
  }
}
