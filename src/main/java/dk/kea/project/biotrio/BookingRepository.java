package dk.kea.project.biotrio;

import dk.kea.project.biotrio.Domain.Booking;
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
public class BookingRepository {
    @Autowired
    private JdbcTemplate jdbc;

    public Booking findBooking(int id) {

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM booking WHERE bookingId" + id);
        Booking booking = new Booking();
        while (rs.next()) {
            booking.setCustomerId(rs.getInt("customerId"));
            booking.setMovieId(rs.getInt("movieId"));
            booking.setTheaterId(rs.getInt("theaterId"));
            booking.setScreeningId(rs.getInt("screeningId"));
            booking.setSeatId(rs.getInt("seatId"));
        }
        return booking;
    }

    public List<Booking> findAllBookings() {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM booking ");
        List<Booking> bookingList = new ArrayList();
        while (rs.next()) {
            Booking booking = new Booking();
            booking.setCustomerId(rs.getInt("customerId"));
            booking.setMovieId(rs.getInt("movieId"));
            booking.setTheaterId(rs.getInt("theaterId"));
            booking.setScreeningId(rs.getInt("screeningId"));
            booking.setSeatId(rs.getInt("seatId"));
        }
        return bookingList;
    }

    public Booking insert(Booking booking) {
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                String sql = "INSERT INTO screening VALUES(null , ?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                ps.setInt(1, booking.getCustomerId());
                ps.setInt(2, booking.getMovieId());
                ps.setInt(3, booking.getTheaterId());
                ps.setInt(4, booking.getScreeningId());
                ps.setInt(5, booking.getSeatId() );

                return ps;
            }
        };
        KeyHolder id = new GeneratedKeyHolder();
        jdbc.update(psc, id);
        booking.setBookingId(id.getKey().intValue());
        return booking;
    }

    public void delete(int id) {
        jdbc.update("DELETE FROM booking WHERE bookingId = " + id);
    }


}
