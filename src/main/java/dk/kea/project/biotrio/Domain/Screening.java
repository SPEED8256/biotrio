package dk.kea.project.biotrio.Domain;

import java.time.LocalTime;

public class Screening {

    private int screeningId;
    private LocalTime screeningTime;

    //constructors

    public Screening() {
    }

    public Screening(int screeningId, LocalTime screeningTime) {
        this.screeningId = screeningId;
        this.screeningTime = screeningTime;
    }

    //getters and setters

    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }

    public LocalTime getScreeningTime() {
        return screeningTime;
    }

    public void setScreeningTime(LocalTime screeningTime) {
        this.screeningTime = screeningTime;
    }

    @Override
    public String toString() {
        return "Screening{" +
                "screeningId=" + screeningId +
                ", screeningTime=" + screeningTime +
                '}';
    }
}

