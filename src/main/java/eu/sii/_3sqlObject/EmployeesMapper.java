package eu.sii._3sqlObject;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeesMapper implements RowMapper<Employees> {
  @Override
  public Employees map(ResultSet rs, StatementContext ctx) throws SQLException {
    return new Employees(); //TODO: create new employees object using ResultSet rs
  }
}
