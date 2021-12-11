package com.musinsa.category.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musinsa.category.domain.TopCategoryDTO;
import com.musinsa.category.mapper.TopCategoryMapper;
import com.musinsa.category.service.TopCategoryService;

@Service
public class TopCategoryServiceImpl implements TopCategoryService {

//	private static final Logger logger = LoggerFactory.getLogger(TopCategoryServiceImpl.class);
	
	@Autowired
	private TopCategoryMapper topCategoryMapper;
	
	
	@Override
	public boolean insertTopCategory(TopCategoryDTO params) throws Exception {
		
		int insertResult = topCategoryMapper.insertTopCategory(params);
		
		return (insertResult == 1) ? true : false;
	}

	@Override
	public boolean deleteTopCategory(Long topId) throws Exception {
		
		int deleteResult = topCategoryMapper.deleteTopCategory(topId);
		
		return (deleteResult == 1) ? true : false;
	}

	@Override
	public boolean updateTopCategory(TopCategoryDTO params) throws Exception {
		
		int updatetResult = topCategoryMapper.updateTopCategory(params);
		
		return (updatetResult == 1) ? true : false;
	}

	
	@Override
	public List<TopCategoryDTO> selectTopCategory(TopCategoryDTO params) throws Exception {
		
		List<TopCategoryDTO> resultList = new ArrayList<>();
		
		resultList = topCategoryMapper.selectTopCategory(params);
		
		return resultList;
	}

}
