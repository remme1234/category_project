package com.musinsa.category.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.musinsa.category.domain.MiddleCategoryDTO;

@Mapper
public interface MiddleCategoryMapper {
	
	public int insertMiddleCategory(MiddleCategoryDTO params);
	
	public int updateMiddleCategory(MiddleCategoryDTO params);

	public int deleteMiddleCategory(Long topId);

	public List<MiddleCategoryDTO> selectMiddleCategory(MiddleCategoryDTO idx);
}
