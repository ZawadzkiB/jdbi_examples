package eu.sii._4crud;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegionsMapper implements RowMapper<Regions> {
    @Override
    public Regions map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Regions()
                .setId(rs.getInt("REGION_ID"))
                .setName(rs.getString("REGION_NAME"));
    }
}
