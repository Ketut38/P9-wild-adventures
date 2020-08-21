package com.wildadventures.msadventures.bean;

import com.wildadventures.msadventures.model.Adventure;

import java.time.LocalDate;

public class SessionBean {

    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Adventure adventure;

    public SessionBean() {
    }

    public Integer getId() {
        return id;
    }

    public SessionBean setId(Integer id) {
        this.id = id;
        return this;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public SessionBean setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public SessionBean setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public Adventure getAdventure() {
        return adventure;
    }

    public SessionBean setAdventure(Adventure adventure) {
        this.adventure = adventure;
        return this;
    }
}
