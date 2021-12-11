package com.musinsa.category.service;

import java.util.List;

import com.musinsa.category.domain.MiddleCategoryDTO;

public interface MiddleCategoryService {

	public boolean insertMiddleCategory(MiddleCategoryDTO params) throws Exception;

	public boolean deleteMiddleCategory(Long middleId) throws Exception;
	
	public boolean updateMiddleCategory(MiddleCategoryDTO params) throws Exception;

	public List<MiddleCategoryDTO> selectMiddleCategory(MiddleCategoryDTO params) throws Exception;
}
