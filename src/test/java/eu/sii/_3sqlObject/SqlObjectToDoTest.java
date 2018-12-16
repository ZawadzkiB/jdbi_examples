package eu.sii._3sqlObject;

import eu.sii.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class SqlObjectToDoTest extends BaseTest {

  private EmployeeDAO employeeDAO;

  @BeforeEach
  public void setUp() {
    employeeDAO = handle.attach(EmployeeDAO.class);
  }

  //TODO: go to Employees, EmployeesDAO and EmployeesMapper and implement missing parts

  /**
   * make this test working
   */
  @Test
  public void getAllEmployees() {
    List<Employees> employeesList = employeeDAO.getEmployees().collect(Collectors.toList());
    Assertions.assertEquals(107, employeesList.size());
  }

  /**
   * Write more tests for:
   * 1. get employees by id
   * 2. get employees by salary higher that 5000 and job id equal IT_PROG
   * 3. get top5 employees with highest salary
   */

}
