package dk.kea.project.biotrio;

import java.time.LocalDateTime;

public class Screening {

    private int screeningIid;
    private LocalDateTime screeningDateTime;

    //constructors

    public Screening(int screeningIid, LocalDateTime screeningDateTime) {
        this.screeningIid = screeningIid;
        this.screeningDateTime = screeningDateTime;
    }

    //getters and setters
    public int getScreeningIid() {
        return screeningIid;
    }

    public void setScreeningIid(int screeningIid) {
        this.screeningIid = screeningIid;
    }

    public LocalDateTime getScreeningDateTime() {
        return screeningDateTime;
    }

    public void setScreeningDateTime(LocalDateTime screeningDateTime) {
        this.screeningDateTime = screeningDateTime;
    }

    @Override
    public String toString() {
        return "Screening{" +
                "screeningIid=" + screeningIid +
                ", screeningDateTime=" + screeningDateTime +
                '}';
    }
}

