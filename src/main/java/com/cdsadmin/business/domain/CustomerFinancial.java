package com.cdsadmin.business.domain;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A CustomerFinancial.
 */
public class CustomerFinancial {

    private Long id;

    private String customerNumber;

    private Double toatlAsset;

    private String cmpFlag;

    private LocalDate updateDate;

    private Double mtg14FamilyAmt;

    private Double totalRFHA;

    private Double mvaPercentage;

    private String capitalCompliantLevel;

    private String watchStatus;

    private Double creditScore;

    private LocalDate watchStatusEffectiveDate;

    private Double totalEligibileCollateralAmount;

    private Double securityEligibileCollateralAmount;


    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public Double getToatlAsset() {
		return toatlAsset;
	}

	public void setToatlAsset(Double toatlAsset) {
		this.toatlAsset = toatlAsset;
	}

	public String getCmpFlag() {
		return cmpFlag;
	}

	public void setCmpFlag(String cmpFlag) {
		this.cmpFlag = cmpFlag;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	public Double getMtg14FamilyAmt() {
		return mtg14FamilyAmt;
	}

	public void setMtg14FamilyAmt(Double mtg14FamilyAmt) {
		this.mtg14FamilyAmt = mtg14FamilyAmt;
	}

	public Double getTotalRFHA() {
		return totalRFHA;
	}

	public void setTotalRFHA(Double totalRFHA) {
		this.totalRFHA = totalRFHA;
	}

	public Double getMvaPercentage() {
		return mvaPercentage;
	}

	public void setMvaPercentage(Double mvaPercentage) {
		this.mvaPercentage = mvaPercentage;
	}

	public String getCapitalCompliantLevel() {
		return capitalCompliantLevel;
	}

	public void setCapitalCompliantLevel(String capitalCompliantLevel) {
		this.capitalCompliantLevel = capitalCompliantLevel;
	}

	public String getWatchStatus() {
		return watchStatus;
	}

	public void setWatchStatus(String watchStatus) {
		this.watchStatus = watchStatus;
	}

	public Double getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(Double creditScore) {
		this.creditScore = creditScore;
	}

	public LocalDate getWatchStatusEffectiveDate() {
		return watchStatusEffectiveDate;
	}

	public void setWatchStatusEffectiveDate(LocalDate watchStatusEffectiveDate) {
		this.watchStatusEffectiveDate = watchStatusEffectiveDate;
	}

	public Double getTotalEligibileCollateralAmount() {
		return totalEligibileCollateralAmount;
	}

	public void setTotalEligibileCollateralAmount(Double totalEligibileCollateralAmount) {
		this.totalEligibileCollateralAmount = totalEligibileCollateralAmount;
	}

	public Double getSecurityEligibileCollateralAmount() {
		return securityEligibileCollateralAmount;
	}

	public void setSecurityEligibileCollateralAmount(Double securityEligibileCollateralAmount) {
		this.securityEligibileCollateralAmount = securityEligibileCollateralAmount;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CustomerFinancial)) {
            return false;
        }
        return id != null && id.equals(((CustomerFinancial) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "CustomerFinancial{" +
            "id=" + getId() +
            ", customerNumber='" + getCustomerNumber() + "'" +
            ", toatlAsset=" + getToatlAsset() +
            ", cmpFlag='" + getCmpFlag() + "'" +
            ", updateDate='" + getUpdateDate() + "'" +
            ", mtg14FamilyAmt=" + getMtg14FamilyAmt() +
            ", totalRFHA=" + getTotalRFHA() +
            ", mvaPercentage=" + getMvaPercentage() +
            ", capitalCompliantLevel='" + getCapitalCompliantLevel() + "'" +
            ", watchStatus='" + getWatchStatus() + "'" +
            ", creditScore=" + getCreditScore() +
            ", watchStatusEffectiveDate='" + getWatchStatusEffectiveDate() + "'" +
            ", totalEligibileCollateralAmount=" + getTotalEligibileCollateralAmount() +
            ", securityEligibileCollateralAmount=" + getSecurityEligibileCollateralAmount() +
            "}";
    }
}
