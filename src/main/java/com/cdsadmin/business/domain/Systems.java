package com.cdsadmin.business.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * A Systems.
 */
public class Systems {

    private Long id;

    private String systemsEntity;

    private Set<Merger> mergers = new HashSet<>();

    private Set<Transfer> transfers = new HashSet<>();



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


    public Set<Merger> getMergers() {
        return mergers;
    }

    public void setMergers(Set<Merger> mergers) {
        this.mergers = mergers;
    }

    public Set<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(Set<Transfer> transfers) {
        this.transfers = transfers;
    }



}
