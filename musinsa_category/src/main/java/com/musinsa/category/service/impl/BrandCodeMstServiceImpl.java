package com.musinsa.category.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musinsa.category.domain.BrandCodeMstDTO;
import com.musinsa.category.mapper.BrandCodeMstMapper;
import com.musinsa.category.service.BrandCodeMstService;

@Service
public class BrandCodeMstServiceImpl implements BrandCodeMstService {

//	private static final Logger logger = LoggerFactory.getLogger(BrandCodeMstServiceImpl.class);
	
	@Autowired
	private BrandCodeMstMapper bottomCategoryMapper;
	
	
	@Override
	public boolean insertBrandCodeMst(BrandCodeMstDTO params) throws Exception {
		
		int insertResult = bottomCategoryMapper.insertBrandCodeMst(params);
		
		return (insertResult == 1) ? true : false;
	}

	@Override
	public boolean deleteBrandCodeMst(Long bottomId) throws Exception {
		
		int deleteResult = bottomCategoryMapper.deleteBrandCodeMst(bottomId);
		
		return (deleteResult == 1) ? true : false;
	}

	@Override
	public boolean updateBrandCodeMst(BrandCodeMstDTO params) throws Exception {
		
		int updatetResult = bottomCategoryMapper.updateBrandCodeMst(params);
		
		return (updatetResult == 1) ? true : false;
	}

	
	@Override
	public List<BrandCodeMstDTO> selectBrandCodeMst(BrandCodeMstDTO params) throws Exception {
		
		List<BrandCodeMstDTO> resultList = new ArrayList<>();
		
		resultList = bottomCategoryMapper.selectBrandCodeMst(params);
		
		return resultList;
	}
}
