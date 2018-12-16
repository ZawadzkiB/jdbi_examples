package eu.sii._3sqlObject;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.stream.Stream;

@RegisterRowMapper(EmployeesMapper.class)
public interface EmployeeDAO {

  @SqlQuery("select * from HR.EMPLOYEES")
  Stream<Employees> getEmployees();
}
