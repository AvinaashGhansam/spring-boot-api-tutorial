package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

/**
 * You can ignore fields at the class level as well
 * @JsonIgnoreProperties("value2") or @JsonIgnoreProperties({ "value1", "value2"
 * })
 */
/* @JsonIgnoreProperties({ "value1", "value2" }) */ // Static Filtering
@JsonFilter("someBeanFilter")
public class SomeBean {
  private String value1;
  /**
   * This will ignore value 2. It will not show up in the api
   */
  /* @JsonIgnore */ // Static Filtering
  private String value2;
  private String value3;

  public SomeBean(String value1, String value2, String value3) {
    this.value1 = value1;
    this.value2 = value2;
    this.value3 = value3;

  }

  /**
   * @return the value1
   */
  public String getValue1() {
    return value1;
  }

  /**
   * @return the value2
   */
  public String getValue2() {
    return value2;
  }

  /**
   * @return the value3
   */
  public String getValue3() {
    return value3;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */

  @Override
  public String toString() {
    return "SomeBean [value1=" + value1 + ", value2=" + value2 + ", value3=" + value3 + "]";
  }

}
