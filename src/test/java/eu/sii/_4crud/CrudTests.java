package eu.sii._4crud;

import eu.sii.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrudTests extends BaseTest {

    //Declaring our regions dao
    private RegionsDAO regionsDAO;

    //Initializing regions dao
    @BeforeEach
    public void setupDAO() {
        regionsDAO = handle.attach(RegionsDAO.class);
    }

    //insert region by parameters
    @Test
    public void insertRegion() {
        Assertions.assertTrue(regionsDAO.insertRegionsWithParams(6, "Africa"));
    }

    //insert region by object
    @Test
    public void insertRegionUsingObject() {
        Regions region = new Regions().setId(666).setName("Hell");
        Assertions.assertTrue(regionsDAO.insertRegion(region));
    }

    //update regions using parameters
    @Test
    public void updateRegion() {
        Assertions.assertTrue(regionsDAO.updateNameById(6, "Africa2"));
    }

    //delete region by id
    @Test
    public void deleteRegion() {
        Assertions.assertTrue(regionsDAO.deleteById(6));
    }
}
