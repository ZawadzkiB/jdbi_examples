package basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class QueryToDoTest extends BaseTest {

  //TODO: "Fix tests"

  /**
   * Find country name for BR id
   */
  @Test
  public void selectCountryNameByIdBR() {
    String query = "SELECT COUNTRY_NAME FROM HR.COUNTRIES WHERE COUNTRY_ID = ?";
    String countryName = handle.createQuery(query)
            //.bind(?,?) <-- fix me
            .mapTo(String.class)
            .findOnly();
    Assertions.assertEquals(countryName, "Brazil");
  }

  /**
   * Find country name for DK id
   */
  @Test
  public void selectCountryNameByIdDK() {
    String query = "SELECT COUNTRY_NAME FROM HR.COUNTRIES WHERE COUNTRY_ID = :countryId";
    String countryName = handle.createQuery(query)
            //.bind(?,?) <-- fix me
            .mapTo(String.class)
            .findOnly();
    Assertions.assertEquals(countryName, "Denmark");
  }

  /**
   * Check that region id = 2 contains countries: [Canada,Mexico]
   */
  @Test
  public void checkThatRegionId2ContainsCanadaAndMexico() {
    String query = "SELECT COUNTRY_NAME FROM HR.COUNTRIES ..."; //<-- fix query
    List<String> countryNames = handle.createQuery(query)
            //.bind(?, ?) <-- fix me
            .mapTo(String.class)
            .list();
    Assertions.assertTrue(countryNames.containsAll(
            Arrays.asList("Canada", "Mexico")
    ));
  }
}
