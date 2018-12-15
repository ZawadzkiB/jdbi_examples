package eu.sii._2mapper;

import eu.sii.BaseTest;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.mapper.reflect.ConstructorMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperToDoTests extends BaseTest {

  /**
   * Fix that mappers, set proper column names
   */
  static class CountriesMapper implements RowMapper<Countries> {
    @Override
    public Countries map(ResultSet rs, StatementContext ctx) throws SQLException {
      return new Countries(
              rs.getString(""),
              rs.getString(""),
              rs.getInt("")
      );
    }
  }

  /**
   * Get country for id DK
   */
  @Test
  public void getCountryForDK() {
    Countries country = null;
    String query = "SELECT * FROM HR.COUNTRIES WHERE COUNTRY_ID = :countryId";
    /**
     * Write handler here and use countries mapper to create new countries object
     */
    Assertions.assertEquals(country, new Countries("DK", "Denmark", 1));
  }

  /**
   * In this test you need to go to Countries.class and add required annotations in constructor to make it working
   */
  @Test
  public void getCountryForDKUsingConstructorMapper() {
    Countries country = null;
    String query = "SELECT * FROM HR.COUNTRIES WHERE COUNTRY_ID = :countryId";
    handle.registerRowMapper(ConstructorMapper.factory(Countries.class));
    /**
     * Write handler here and use countries mapper to create new countries object
     */
    Assertions.assertEquals(country, new Countries("DK", "Denmark", 1));
  }
}
