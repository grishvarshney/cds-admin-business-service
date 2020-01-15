package com.cdsadmin.business.domain;

import java.time.LocalDate;

/**
 * A Note.
 */
public class Note {


    private Long id;

    private String noteNo;

    private String industry;

    private LocalDate effectiveDate;

    private String instrumentType;

    
    private Customer customer;

    private Merger merger;

    private Transfer transfer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoteNo() {
        return noteNo;
    }

    public void setNoteNo(String noteNo) {
        this.noteNo = noteNo;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Merger getMerger() {
        return merger;
    }

    public void setMerger(Merger merger) {
        this.merger = merger;
    }

    public Transfer getTransfer() {
        return transfer;
    }

    public void setTransfer(Transfer transfer) {
        this.transfer = transfer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Note)) {
            return false;
        }
        return id != null && id.equals(((Note) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Note{" +
            "id=" + getId() +
            ", noteNo='" + getNoteNo() + "'" +
            ", industry='" + getIndustry() + "'" +
            ", effectiveDate='" + getEffectiveDate() + "'" +
            ", instrumentType='" + getInstrumentType() + "'" +
            "}";
    }
}
