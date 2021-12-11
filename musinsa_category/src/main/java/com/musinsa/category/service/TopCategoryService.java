package com.musinsa.category.service;

import java.util.List;

import com.musinsa.category.domain.TopCategoryDTO;

public interface TopCategoryService {

	public boolean insertTopCategory(TopCategoryDTO params) throws Exception;

	public boolean deleteTopCategory(Long topId) throws Exception;
	
	public boolean updateTopCategory(TopCategoryDTO params) throws Exception;

	public List<TopCategoryDTO> selectTopCategory(TopCategoryDTO params) throws Exception;
}
