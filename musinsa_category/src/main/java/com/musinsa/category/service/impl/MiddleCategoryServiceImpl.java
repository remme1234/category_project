package com.musinsa.category.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musinsa.category.domain.MiddleCategoryDTO;
import com.musinsa.category.mapper.MiddleCategoryMapper;
import com.musinsa.category.service.MiddleCategoryService;

@Service
public class MiddleCategoryServiceImpl implements MiddleCategoryService {

//	private static final Logger logger = LoggerFactory.getLogger(MiddleCategoryServiceImpl.class);
	
	@Autowired
	private MiddleCategoryMapper middleCategoryMapper;
	
	
	@Override
	public boolean insertMiddleCategory(MiddleCategoryDTO params) throws Exception {
		
		int insertResult = middleCategoryMapper.insertMiddleCategory(params);
		
		return (insertResult == 1) ? true : false;
	}

	@Override
	public boolean deleteMiddleCategory(Long middleId) throws Exception {
		
		int deleteResult = middleCategoryMapper.deleteMiddleCategory(middleId);
		
		return (deleteResult == 1) ? true : false;
	}

	@Override
	public boolean updateMiddleCategory(MiddleCategoryDTO params) throws Exception {
		
		int updatetResult = middleCategoryMapper.updateMiddleCategory(params);
		
		return (updatetResult == 1) ? true : false;
	}

	
	@Override
	public List<MiddleCategoryDTO> selectMiddleCategory(MiddleCategoryDTO params) throws Exception {
		
		List<MiddleCategoryDTO> resultList = new ArrayList<>();
		
		resultList = middleCategoryMapper.selectMiddleCategory(params);
		
		return resultList;
	}
}
