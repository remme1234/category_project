package com.musinsa.category.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.musinsa.category.domain.TopCategoryDTO;

@Mapper
public interface TopCategoryMapper {

	int insertTopCategory(TopCategoryDTO params);
	
	int updateTopCategory(TopCategoryDTO params);

	int deleteTopCategory(Long topId);

	List<TopCategoryDTO> selectTopCategory(TopCategoryDTO params);

}
