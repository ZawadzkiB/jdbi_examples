package eu.sii._3sqlObject;

import com.sun.tools.internal.ws.wsdl.framework.NoSuchEntityException;
import eu.sii.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class SqlObjectTest extends BaseTest {


  //Here we are declaring our countriesDAO (data object access)
  private CountriesDAO countriesDAO;

  @BeforeEach
  public void setUp(){
    //before each test we are constructing our DAO from CountriesDAO.class using handler.attach method
    countriesDAO = handle.attach(CountriesDAO.class);
  }

  //we are using our dao to get list of all countries, actually getCountries method return stream of data so we can easily filter, map and reduce it.
  @Test
  public void getAllCountries() {
    List<Countries> countriesList = countriesDAO.getCountries().collect(Collectors.toList());
    Assertions.assertEquals(25, countriesList.size());
  }

  //her we are getting optional of country and we are searching only one record by id
  @Test
  public void getCountryById() {
    Countries country = countriesDAO.getCountries("DK").orElseThrow(() -> new NoSuchEntityException("Not found"));
    Assertions.assertEquals(country.getCountryId(),"DK");
  }
}
