package basic;

import com.sun.tools.internal.ws.wsdl.framework.NoSuchEntityException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class QueryTests extends BaseTest {

  //Select first name and last from employees table and check that size of this list is 107
  //we are using .mapToMap() function and .list() so we are creating list of maps ;)
  //where in each map key is column name and value is from row from this column
  @Test
  public void selectNameAndLastName() {
    List<Map<String, Object>> employees = handle.createQuery(
            "SELECT FIRST_NAME FROM HR.EMPLOYEES")
            .mapToMap()
            .list();
    Assertions.assertEquals(employees.size(), 107);
  }

  //Select first name from employees tab, so after query we use .mapTo and then we are saying that we
  //want to have String.class and then we want to get first name from table so we use .findFirst()
  //but it is returning option of string so we have to use get() or some of optional methods, in this case
  //we use orElseThrow and we throw NoSuchEntityException when String(our name from table) will be null
  @Test
  public void selectName() {
    String name = handle.createQuery(
            "SELECT FIRST_NAME FROM HR.EMPLOYEES")
            .mapTo(String.class)
            .findFirst()
            .orElseThrow(() -> new NoSuchEntityException("Nothing was found"));
    Assertions.assertEquals(name, "Ellen");
  }

  //Select first name and last name from employess table where salary is higher than 9000
  //and job is 'sa_rep', here we are setting JOB_ID = ? using '?' so this is not named parameter,
  //this is position parameter we are setting in by using bind(?,?) method.
  //.bind(0, JOBS.SA_REP) and .bind(1, 9000), so for query in position 0 question mark ? we will use
  //job name JOBS.SA_REP we are
  @Test
  public void selectNameAndLastNameWhereSalaryIsHigherThanAndJobIdIsByPosition() {
    List<Map<String, Object>> employees = handle.createQuery(
            "SELECT FIRST_NAME, LAST_NAME " +
                    "FROM HR.EMPLOYEES " +
                    "WHERE JOB_ID = ? " +
                    "AND SALARY > ?")
            .bind(0, JOBS.SA_REP)
            .bind(1, 9000)
            .mapToMap()
            .list();
    Assertions.assertEquals(employees.size(), 10);
  }

  //Select first name and last name from employees where id is 102, but this time we are using
  //named parameter, so in query we are using :id instead ? and then in bind method we can use
  //.bind("id", 102) "id" instead position number
  @Test
  public void selectNameWhereId() {
    String name = handle.createQuery(
            "SELECT FIRST_NAME FROM HR.EMPLOYEES WHERE EMPLOYEE_ID = :id")
            .bind("id", 102)
            .mapTo(String.class)
            .findOnly();
    Assertions.assertEquals("Lex", name);
  }

  //Here we use query to select again first and last names, where salary is higher than 9000
  //and job name is sa_rep
  @Test
  public void selectNameAndLastNameWhereSalaryIsHigherThanAndJobIdIs() {
    List<Map<String, Object>> employees = handle.createQuery(
            "SELECT FIRST_NAME, LAST_NAME " +
                    "FROM HR.EMPLOYEES " +
                    "WHERE JOB_ID = :job " +
                    "AND SALARY > :salary")
            .bind("job", JOBS.SA_REP)
            .bind("salary", 9000)
            .mapToMap()
            .list();
    Assertions.assertEquals(employees.size(), 10);
  }

}
