package basic;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.Query;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class App {

  public static void main(String[] args) {

    //create connection
    Jdbi jdbi = Jdbi.create("jdbc:oracle:thin:@localhost:49161:xe","system","oracle");

    //get list of names from employess table
    List<String> names = new ArrayList<>();
    jdbi.useHandle(handle ->
      names.addAll(handle.createQuery("select FIRST_NAME from HR.EMPLOYEES")
              .mapTo(String.class).list())
    );

    //get list of employess using row mapper
    List<Employee> employees;
    try(Query query = jdbi.open().createQuery("select EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL from HR.EMPLOYEES")){
      employees = query.map(new EmployeeMapper()).list();
    }

  }

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
}
