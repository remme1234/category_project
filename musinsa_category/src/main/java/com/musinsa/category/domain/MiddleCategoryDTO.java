package com.musinsa.category.domain;

public class MiddleCategoryDTO {

	private Long middleId;
	private String middleName;
	private Long topId;
	private String creator;
	private String createDttm;
	private String updater;
	private String updateDttm;
	public Long getMiddleId() {
		return middleId;
	}
	public void setMiddleId(Long middleId) {
		this.middleId = middleId;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public Long getTopId() {
		return topId;
	}
	public void setTopId(Long topId) {
		this.topId = topId;
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
		return "MiddleCategoryDTO [middleId=" + middleId + ", middleName=" + middleName + ", topId=" + topId
				+ ", creator=" + creator + ", createDttm=" + createDttm + ", updater=" + updater + ", updateDttm="
				+ updateDttm + "]";
	}

	
}
