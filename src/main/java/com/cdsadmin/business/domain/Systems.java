package com.cdsadmin.business.domain;

/**
 * A Systems.
 */
public class Systems {

    private Long id;

    private String systemsEntity;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Systems)) {
            return false;
        }
        return id != null && id.equals(((Systems) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Systems{" +
            "id=" + getId() +
            ", systemsEntity='" + getSystemsEntity() + "'" +
            "}";
    }
}
