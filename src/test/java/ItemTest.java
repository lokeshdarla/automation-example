import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lokeshdarla.Item;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

  private Item item;

  @BeforeEach
  public void setUp() {
    item = new Item(2.5, "Sample Item");
  }

  @Test
  public void testGetPriceForQuantity() {
    // Price should be calculated as 100 * shippingWeight
    double expectedPrice = 100.0 * 2.5;
    assertEquals(expectedPrice, item.getPriceForQuantity(), "The price for quantity is incorrect.");
  }

  @Test
  public void testGetTax() {
    // The tax is a constant value of 0.18
    double expectedTax = 0.18;
    assertEquals(expectedTax, item.getTax(), "The tax rate is incorrect.");
  }

  @Test
  public void testGetShippingWeight() {
    // The shipping weight should match the initialized value
    double expectedWeight = 2.5;
    assertEquals(expectedWeight, item.getShippingWeight(), "The shipping weight is incorrect.");
  }

  @Test
  public void testInStock() {
    // The inStock method always returns true
    assertTrue(item.inStock(), "The item should be in stock.");
  }

}
