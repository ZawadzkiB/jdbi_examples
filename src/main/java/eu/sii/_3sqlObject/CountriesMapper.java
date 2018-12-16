package eu.sii._3sqlObject;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Just normal mapper for countries table, create new Countries object from row, where we are telling which value from which column
 * should be use in Countries class field.
 */
public class CountriesMapper implements RowMapper<Countries> {
  @Override
  public Countries map(ResultSet rs, StatementContext ctx) throws SQLException {
    //this should be builder not constructor
    return new Countries(
            rs.getString("COUNTRY_ID"),
            rs.getString("COUNTRY_NAME"),
            rs.getInt("REGION_ID")
    );
  }
}
