package com.cdsadmin.business.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

/**
 * A Systems.
 */
public class Systems {

    private Long id;

    private String systemsEntity;

    private Merger merger;

    private Transfer transfer;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSystemsEntity() {
        return systemsEntity;
    }

    public void setSystemsEntity(String systemsEntity) {
        this.systemsEntity = systemsEntity;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Systems systems = (Systems) o;
        return Objects.equals(id, systems.id) &&
            Objects.equals(systemsEntity, systems.systemsEntity) &&
            Objects.equals(merger, systems.merger) &&
            Objects.equals(transfer, systems.transfer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, systemsEntity, merger, transfer);
    }

    @Override
    public String toString() {
        return "Systems{" +
            "id=" + id +
            ", systemsEntity='" + systemsEntity + '\'' +
            ", merger=" + merger +
            ", transfer=" + transfer +
            '}';
    }

}
