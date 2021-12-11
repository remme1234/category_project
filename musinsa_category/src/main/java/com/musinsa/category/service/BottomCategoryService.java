package com.musinsa.category.service;

import java.util.List;

import com.musinsa.category.domain.BottomCategoryDTO;

public interface BottomCategoryService {

	public boolean insertBottomCategory(BottomCategoryDTO params) throws Exception;

	public boolean deleteBottomCategory(Long middleId) throws Exception;
	
	public boolean updateBottomCategory(BottomCategoryDTO params) throws Exception;

	public List<BottomCategoryDTO> selectBottomCategory(BottomCategoryDTO params) throws Exception;
}
