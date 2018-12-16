package eu.sii._3sqlObject;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.Optional;
import java.util.stream.Stream;


/**
 * it our single place of methods to access data, this DAO is for Countries table
 * at class declaration we provide row mapper which we want to use for deserialization of our rows to Countries object, this can be registered for each method separately.
 * And we just declare methods and annotate it with @SqlQuery and query which we want to use
 * in first method we don't have any parameter in second we use id parameter to find only one country.
 */
@RegisterRowMapper(CountriesMapper.class)
public interface CountriesDAO {

  @SqlQuery("SELECT * FROM HR.COUNTRIES")
  Stream<Countries> getCountries();

  @SqlQuery("SELECT * FROM HR.COUNTRIES WHERE COUNTRY_ID = ?")
  Optional<Countries> getCountries(String id);

}
