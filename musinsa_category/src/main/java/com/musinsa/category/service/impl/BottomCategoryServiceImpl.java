package com.musinsa.category.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musinsa.category.domain.BottomCategoryDTO;
import com.musinsa.category.mapper.BottomCategoryMapper;
import com.musinsa.category.service.BottomCategoryService;

@Service
public class BottomCategoryServiceImpl implements BottomCategoryService {

//	private static final Logger logger = LoggerFactory.getLogger(BottomCategoryServiceImpl.class);
	
	@Autowired
	private BottomCategoryMapper bottomCategoryMapper;
	
	
	@Override
	public boolean insertBottomCategory(BottomCategoryDTO params) throws Exception {
		
		int insertResult = bottomCategoryMapper.insertBottomCategory(params);
		
		return (insertResult == 1) ? true : false;
	}

	@Override
	public boolean deleteBottomCategory(Long bottomId) throws Exception {
		
		int deleteResult = bottomCategoryMapper.deleteBottomCategory(bottomId);
		
		return (deleteResult == 1) ? true : false;
	}

	@Override
	public boolean updateBottomCategory(BottomCategoryDTO params) throws Exception {
		
		int updatetResult = bottomCategoryMapper.updateBottomCategory(params);
		
		return (updatetResult == 1) ? true : false;
	}

	
	@Override
	public List<BottomCategoryDTO> selectBottomCategory(BottomCategoryDTO params) throws Exception {
		
		List<BottomCategoryDTO> resultList = new ArrayList<>();
		
		resultList = bottomCategoryMapper.selectBottomCategory(params);
		
		return resultList;
	}
}
