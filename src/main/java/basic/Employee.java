package basic;

import org.jdbi.v3.core.mapper.reflect.ColumnName;


public class Employee {

  @ColumnName("EMPLOYEE_ID") private int id;
  @ColumnName("FIRST_NAME") private String firstName;
  @ColumnName("LAST_NAME") private String lastName;
  @ColumnName("EMAIL") private String email;

  public Employee(int id, String firstName, String lastName, String email) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public Employee setId(int id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public Employee setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public Employee setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public Employee setEmail(String email) {
    this.email = email;
    return this;
  }
}
