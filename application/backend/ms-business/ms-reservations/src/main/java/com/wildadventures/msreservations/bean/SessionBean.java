package com.wildadventures.msreservations.bean;

import java.time.LocalDate;

public class SessionBean {

    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;

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
}
