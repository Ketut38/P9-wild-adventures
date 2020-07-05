package com.wildadventures.mssession.model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "session")
public class Session implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "adventure_id")
    private Integer adventureId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    public Session(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Session() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdventureId() {
        return adventureId;
    }

    public void setAdventureId(Integer adventureId) {
        this.adventureId = adventureId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", startdate=" + startDate +
                ", enddate=" + endDate +
                '}';
    }
}
