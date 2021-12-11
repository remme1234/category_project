package com.musinsa.category.domain;

public class TopCategoryDTO {

	
	private Long topId;
	private String topName;
	private String creator;
	private String createDttm;
	private String updater;
	private String updateDttm;
	public Long getTopId() {
		return topId;
	}
	public void setTopId(Long topId) {
		this.topId = topId;
	}
	public String getTopName() {
		return topName;
	}
	public void setTopName(String topName) {
		this.topName = topName;
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
		return "TopCategoryDTO [topId=" + topId + ", topName=" + topName + ", creator=" + creator + ", createDttm="
				+ createDttm + ", updater=" + updater + ", updateDttm=" + updateDttm + "]";
	}
	
	
	
	
	
}
