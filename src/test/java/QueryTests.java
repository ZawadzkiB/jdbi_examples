import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class QueryTests extends BaseTest {

  @Test
  public void selectNameWhereId() {
    String name = handle.createQuery("SELECT FIRST_NAME FROM HR.EMPLOYEES WHERE EMPLOYEE_ID = :id")
            .bind("id", 102)
            .mapTo(String.class)
            .findOnly();
    Assertions.assertEquals("Lex", name);
  }

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
    Assertions.assertEquals(employees.size(),10);
  }

  enum JOBS {
    SA_REP, SA_MAN, ST_CLERK;
  }

}
