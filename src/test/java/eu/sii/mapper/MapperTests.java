package eu.sii.mapper;

import com.sun.tools.internal.ws.wsdl.framework.NoSuchEntityException;
import eu.sii.BaseTest;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.mapper.reflect.ConstructorMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MapperTests extends BaseTest {

  //In this test we are selecting employee with id 103 and creating a new employee object from this row
  //then we create same object manually and compare them.
  //To map row to employee class we use .map(new EmployeeMapper()) RowMapper
  @Test
  public void getEmployWithId103() {
    Employee employee = handle.createQuery(
            "SELECT * FROM HR.EMPLOYEES WHERE EMPLOYEE_ID = ?")
            .bind(0, 103)
            .map(new EmployeeMapper())
            .findFirst()
            .orElseThrow(() -> new NoSuchEntityException("Not found"));
    Assertions.assertEquals(employee, new Employee(
            103,
            "Alexander",
            "Hunold",
            "AHUNOLD"));
  }


  //This is a mapper that tells how to map each row to Employee class, so here we write
  //which column is which field of employee object.
  static class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee map(ResultSet rs, StatementContext ctx) throws SQLException {
      return new Employee(
              rs.getInt("EMPLOYEE_ID"),
              rs.getString("FIRST_NAME"),
              rs.getString("LAST_NAME"),
              rs.getString("EMAIL")
      );
    }
  }


  //In this tests we use ConstructorMapper instead RowMapper to create Employee object
  //in Employee.class we have such constructor
  //@JdbiConstructor
  //  public Employee(
  //          @ColumnName("EMPLOYEE_ID") int id,
  //          @ColumnName("FIRST_NAME") String firstName,
  //          @ColumnName("LAST_NAME") String lastName,
  //          @ColumnName("EMAIL") String email) {
  //    this.id = id;
  //    this.firstName = firstName;
  //    this.lastName = lastName;
  //    this.email = email;
  //  }
  //and base on that constructor we can tell which columns are mapped to what fields
  @Test
  public void getEmployWithId103ByConstructorMapper() {
    handle.registerRowMapper(ConstructorMapper.factory(Employee.class));
    Employee employee = handle.createQuery(
            "SELECT * FROM HR.EMPLOYEES WHERE EMPLOYEE_ID = ?")
            .bind(0, 103)
            .mapTo(Employee.class)
            .findFirst()
            .orElseThrow(() -> new NoSuchEntityException("Not found"));
    Assertions.assertEquals(employee, new Employee(
            103,
            "Alexander",
            "Hunold",
            "AHUNOLD"));
  }

  //Create employees list from table and check it size
  @Test
  public void getEmployeesByConstructorMapper() {
    handle.registerRowMapper(ConstructorMapper.factory(Employee.class));
    List<Employee> employee = handle.createQuery(
            "SELECT * FROM HR.EMPLOYEES")
            .mapTo(Employee.class)
            .list();
    Assertions.assertEquals(107, employee.size());
  }
}
