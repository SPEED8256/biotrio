package dk.kea.project.biotrio;

import dk.kea.project.biotrio.Domain.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TheaterRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public Theater findTheater(int id) {

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM theater WHERE theater_id=" + id);
        Theater theater = new Theater();
        while (rs.next()) {
            theater.setTheaterId(rs.getInt("theater_id"));
            theater.setTheaterName(rs.getString("theater_name"));
        }
        return theater;
    }

    public List<Theater> findAllTheaters() {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM theater");
        List<Theater> theaterList = new ArrayList();
        Theater theater = new Theater();
        while (rs.next()) {
            theater.setTheaterId(rs.getInt("theater_id"));
            theater.setTheaterName(rs.getString("theater_name"));

            theaterList.add(theater);
        }
        return theaterList;
    }

    public Theater insert(Theater theater) {

        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                String sql = "INSERT INTO theater VALUES(null, ?)";
                PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                ps.setString(1, theater.getTheaterName());

                return ps;
            }
        };

        KeyHolder id = new GeneratedKeyHolder();
        jdbc.update(psc, id);
        theater.setTheaterId(id.getKey().intValue());
        return theater;
    }

    public void update(Theater theater) {
        jdbc.update("UPDATE theater SET theater_name=? WHERE theater_id=" + theater.getTheaterId());
    }

    public void delete(int id) {
        jdbc.update("DELETE FROM theater WHERE theater_id =" + id);
    }
}