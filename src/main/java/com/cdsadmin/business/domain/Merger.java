package com.cdsadmin.business.domain;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * A Merger.
 */
public class Merger {

    private Long id;

    private LocalDate effectiveDate;

    private Long customerFrom;

    private Long customerTo;

    private String action;

    private String mergingEntity;

    private ZonedDateTime timeStamp;

    private Set<Note> notes = new HashSet<>();
    
    private Set<Systems> systems = new HashSet<>();

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

    public String getMergingEntity() {
        return mergingEntity;
    }

    public void setMergingEntity(String mergingEntity) {
        this.mergingEntity = mergingEntity;
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

    public Set<Systems> getSystems() {
		return systems;
	}

	public void setSystems(Set<Systems> systems) {
		this.systems = systems;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Merger)) {
            return false;
        }
        return id != null && id.equals(((Merger) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Merger{" +
            "id=" + getId() +
            ", effectiveDate='" + getEffectiveDate() + "'" +
            ", customerFrom=" + getCustomerFrom() +
            ", customerTo=" + getCustomerTo() +
            ", action='" + getAction() + "'" +
            ", mergingEntity='" + getMergingEntity() + "'" +
            ", timeStamp='" + getTimeStamp() + "'" +
            "}";
    }
}
