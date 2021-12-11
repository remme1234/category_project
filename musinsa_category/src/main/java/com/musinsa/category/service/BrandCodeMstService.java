package com.musinsa.category.service;

import java.util.List;

import com.musinsa.category.domain.BrandCodeMstDTO;

public interface BrandCodeMstService {

	public boolean insertBrandCodeMst(BrandCodeMstDTO params) throws Exception;

	public boolean deleteBrandCodeMst(Long middleId) throws Exception;
	
	public boolean updateBrandCodeMst(BrandCodeMstDTO params) throws Exception;

	public List<BrandCodeMstDTO> selectBrandCodeMst(BrandCodeMstDTO params) throws Exception;
}
