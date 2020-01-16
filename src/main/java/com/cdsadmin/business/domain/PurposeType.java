package com.cdsadmin.business.domain;

public class PurposeType {
	private Long id;
	private String purposeTypeCode;
	private String purposeTypeDescription;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPurposeTypeCode() {
		return purposeTypeCode;
	}
	public void setPurposeTypeCode(String purposeTypeCode) {
		this.purposeTypeCode = purposeTypeCode;
	}
	public String getPurposeTypeDescription() {
		return purposeTypeDescription;
	}
	public void setPurposeTypeDescription(String purposeTypeDescription) {
		this.purposeTypeDescription = purposeTypeDescription;
	}
	@Override
	public String toString() {
		return "PurposeType [id=" + id + ", purposeTypeCode=" + purposeTypeCode + ", purposeTypeDescription="
				+ purposeTypeDescription + "]";
	}
}
