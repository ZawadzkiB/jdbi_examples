package eu.sii._4crud;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Optional;
import java.util.stream.Stream;

@RegisterRowMapper(RegionsMapper.class)
public interface RegionsDAO {

    //CRUD -> Create, Read, Update, Delete

    //READ
    @SqlQuery("select * from HR.REGIONS")
    Stream<Regions> getRegions();

    //READ
    //Here we are using @bind annotation to say that this param will be used in :id place
    @SqlQuery("select * from HR.REGIONS WHERE REGION_ID = :id")
    Optional<Regions> getRegionById(@Bind("id") int id);

    //CREATE
    @SqlUpdate("INSERT INTO HR.REGIONS values (?,?)")
    boolean insertRegionsWithParams(int id, String name);

    //CREATE
    //:id and :name are fields names of Regions object
    @SqlUpdate("INSERT INTO HR.REGIONS values (:id,:name)")
    boolean insertRegion(@BindBean Regions regions);

    //UPDATE
    //Here we are using @bind annotation to say that this params will be used in :id and :name places
    @SqlUpdate("UPDATE HR.REGIONS SET REGION_NAME = :name WHERE REGION_ID = :id")
    boolean updateNameById(@Bind("id") int id, @Bind("name") String name);

    //DELETE
    @SqlUpdate("DELETE FROM HR.REGIONS WHERE REGION_ID = :id")
    boolean deleteById(@Bind("id") int id);

}
