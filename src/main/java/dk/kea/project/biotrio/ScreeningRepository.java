package dk.kea.project.biotrio;


import dk.kea.project.biotrio.Domain.Screening;
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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScreeningRepository {
    @Autowired
    private JdbcTemplate jdbc;

    public Screening findScreening(int id) {

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM screening WHERE screening_id" + id);
        Screening screening = new Screening();
        while (rs.next()) {
            LocalTime screeningTime = rs.getTime("screeningTime").toLocalTime();
            screening.setScreeningTime(screeningTime);
        }
        return screening;
    }

    public List<Screening> findAllScreenings() {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM screening ");
        List<Screening> screeningList = new ArrayList();
        while (rs.next()) {
            Screening screening = new Screening();
            LocalTime screeningTime = rs.getTime("screeningTime").toLocalTime();
            screening.setScreeningTime(screeningTime);
            screeningList.add(screening);
        }
        return screeningList;
    }

    public Screening insert(Screening screening) {
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                String sql = "INSERT INTO screening VALUES(null , ?)";
                PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                ps.setTime(1, java.sql.Time.valueOf(screening.getScreeningTime()));
                return ps;
            }
        };
        KeyHolder id = new GeneratedKeyHolder();
        jdbc.update(psc, id);
        screening.setScreeningId(id.getKey().intValue());
        return screening;
    }

    public void update(Screening screening) {
        String sql = "UPDATE screening SET screeningtime=?, WHERE screnningId=" + screening.getScreeningId();
        jdbc.update(sql, screening.getScreeningTime());
    }

    public void delete(int id) {
        jdbc.update("DELETE FROM screening WHERE screeningId = " + id);
    }


}
