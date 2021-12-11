package com.musinsa.category.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.musinsa.category.domain.BottomCategoryDTO;

@Mapper
public interface BottomCategoryMapper {
	
	public int insertBottomCategory(BottomCategoryDTO params);
	
	public int updateBottomCategory(BottomCategoryDTO params);

	public int deleteBottomCategory(Long bottomId);

	public List<BottomCategoryDTO> selectBottomCategory(BottomCategoryDTO idx);
}
