package dk.kea.project.biotrio.Domain;


import dk.kea.project.biotrio.Generator.BookingGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @Column(columnDefinition="VARCHAR(64)")
    @GeneratedValue(generator = BookingGenerator.generatorName)
    @GenericGenerator(name = BookingGenerator.generatorName, strategy = "dk.kea.project.biotrio.Generator.BookingGenerator")
    private String id;

    @OneToOne
    User user;

    @OneToOne
    Screening screening;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<Ticket> tickets = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "MM/dd/yyyy hh:mm a")
    private Date bookingDateTime;

    public Booking() {
    }

    public Date getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(Date bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
