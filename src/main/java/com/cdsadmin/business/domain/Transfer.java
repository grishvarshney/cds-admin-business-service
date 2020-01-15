package com.cdsadmin.business.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * A Transfer.
 */
public class Transfer {

    private Long id;

    private LocalDate effectiveDate;

    private Long customerFrom;

    private Long customerTo;

    private String action;

    private String transferringEntity;

    private ZonedDateTime timeStamp;

    private Set<Note> notes = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Long getCustomerFrom() {
        return customerFrom;
    }

    public void setCustomerFrom(Long customerFrom) {
        this.customerFrom = customerFrom;
    }

    public Long getCustomerTo() {
        return customerTo;
    }

    public void setCustomerTo(Long customerTo) {
        this.customerTo = customerTo;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTransferringEntity() {
        return transferringEntity;
    }

    public void setTransferringEntity(String transferringEntity) {
        this.transferringEntity = transferringEntity;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(ZonedDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Transfer)) {
            return false;
        }
        return id != null && id.equals(((Transfer) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Transfer{" +
            "id=" + getId() +
            ", effectiveDate='" + getEffectiveDate() + "'" +
            ", customerFrom=" + getCustomerFrom() +
            ", customerTo=" + getCustomerTo() +
            ", action='" + getAction() + "'" +
            ", transferringEntity='" + getTransferringEntity() + "'" +
            ", timeStamp='" + getTimeStamp() + "'" +
            "}";
    }
}
