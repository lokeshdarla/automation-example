package org.lokeshdarla;

import java.util.Date;

public class Credit extends Payment {
  String name;
  String type;
  Date expDate;

  public Credit(float amount, String name, String type, Date expDate) {
    super(amount);
    this.name = name;
    this.type = type;
    this.expDate = expDate;
  }

  public boolean authorized() {
    return true;
  }
}
