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
            theater.setName(rs.getString("theater_name"));
            theater.setRows(rs.getInt("theater_rows"));
            theater.setSeatsPerRow(rs.getInt("theater_seats_per_row"));
        }
        return theater;
    }

    public List<Theater> findAllTheaters() {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM theater");
        List<Theater> theaterList = new ArrayList();
        Theater theater = new Theater();
        while (rs.next()) {
            theater.setTheaterId(rs.getInt("theater_id"));
            theater.setName(rs.getString("theater_name"));
            theater.setRows(rs.getInt("theater_rows"));
            theater.setSeatsPerRow(rs.getInt("theater_seats_per_row"));

            theaterList.add(theater);
        }
        return theaterList;
    }


}
