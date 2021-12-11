package com.musinsa.category.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.musinsa.category.domain.BrandCodeMstDTO;

@Mapper
public interface BrandCodeMstMapper {
	
	public int insertBrandCodeMst(BrandCodeMstDTO params);
	
	public int updateBrandCodeMst(BrandCodeMstDTO params);

	public int deleteBrandCodeMst(Long brandId);

	public List<BrandCodeMstDTO> selectBrandCodeMst(BrandCodeMstDTO idx);
}
