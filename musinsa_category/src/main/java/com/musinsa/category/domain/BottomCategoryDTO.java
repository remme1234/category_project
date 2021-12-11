package com.musinsa.category.domain;

public class BottomCategoryDTO {

	private Long bottomId;
	private String bottomName;
	private Long middleId;
	private Long brandId;
	private boolean bestItem;
	private String creator;
	private String createDttm;
	private String updater;
	private String updateDttm;
	public Long getBottomId() {
		return bottomId;
	}
	public void setBottomId(Long bottomId) {
		this.bottomId = bottomId;
	}
	public String getBottomName() {
		return bottomName;
	}
	public void setBottomName(String bottomName) {
		this.bottomName = bottomName;
	}
	public Long getMiddleId() {
		return middleId;
	}
	public void setMiddleId(Long middleId) {
		this.middleId = middleId;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public boolean isBestItem() {
		return bestItem;
	}
	public void setBestItem(boolean bestItem) {
		this.bestItem = bestItem;
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
		return "BottomCategoryDTO [bottomId=" + bottomId + ", bottomName=" + bottomName + ", middleId=" + middleId
				+ ", brandId=" + brandId + ", bestItem=" + bestItem + ", creator=" + creator + ", createDttm="
				+ createDttm + ", updater=" + updater + ", updateDttm=" + updateDttm + "]";
	}
	
	
	
}
