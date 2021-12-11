package com.musinsa.category.domain;

public class BrandCodeMstDTO {

	
	private Long brandId;
	private String brandName;
	private String creator;
	private String createDttm;
	private String updater;
	private String updateDttm;
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCreateDttm() {
		return createDttm;
	}
	public void setCreateDttm(String createDttm) {
		this.createDttm = createDttm;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public String getUpdateDttm() {
		return updateDttm;
	}
	public void setUpdateDttm(String updateDttm) {
		this.updateDttm = updateDttm;
	}
	@Override
	public String toString() {
		return "BrandCodeMstDTO [brandId=" + brandId + ", brandName=" + brandName + ", creator=" + creator
				+ ", createDttm=" + createDttm + ", updater=" + updater + ", updateDttm=" + updateDttm + "]";
	}
	
	
}
