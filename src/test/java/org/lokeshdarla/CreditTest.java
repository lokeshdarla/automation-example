package org.lokeshdarla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.Calendar;

public class CreditTest {

  private Credit credit;
  private float amount = 100.0f;
  private String name = "John Doe";
  private String type = "Visa";
  private Date expDate;

  @BeforeEach
  public void setUp() {
    // Set expiration date to a future date
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.YEAR, 1);
    expDate = calendar.getTime();
    credit = new Credit(amount, name, type, expDate);
  }

  @Test
  public void testConstructor() {
    // Test the constructor to ensure fields are set correctly
    assertEquals(amount, credit.amount, "Amount should be set correctly");
    assertEquals(name, credit.name, "Name should be set correctly");
    assertEquals(type, credit.type, "Type should be set correctly");
    assertEquals(expDate, credit.expDate, "Expiration date should be set correctly");
  }

  @Test
  public void testAuthorized() {
    // Test the authorized method to ensure it returns true
    assertTrue(credit.authorized(), "The authorized method should return true");
  }
}
