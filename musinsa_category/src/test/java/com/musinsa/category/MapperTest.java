package com.musinsa.category;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.musinsa.category.domain.TopCategoryDTO;
import com.musinsa.category.mapper.TopCategoryMapper;

@SpringBootTest
public class MapperTest {

	
	@Autowired
	private TopCategoryMapper topCategoryMapper;
	
	
	@Test
	public void testOfSelect() {
		TopCategoryDTO param = new TopCategoryDTO();
		
		param.setTopName("test!");
		int insertResult = topCategoryMapper.insertTopCategory(param);
		System.out.println("## insertResult : " + insertResult);
		
		
		param = new TopCategoryDTO();
		List<TopCategoryDTO> selectResult = topCategoryMapper.selectTopCategory(param);
		System.out.println("## select result : " + selectResult);
	
		

		param = new TopCategoryDTO();
		param.setTopId((long) 6);
		param.setTopName("test !!!!!!!!!!");
		int updateResult = topCategoryMapper.updateTopCategory(param);
		System.out.println("## update result : " + updateResult);
		
		
		int deleteResult = topCategoryMapper.deleteTopCategory((long)6);
		System.out.println("## delete result : " + deleteResult);
		
		
		param = new TopCategoryDTO();
		param.setTopId((long)3);
		List<TopCategoryDTO> selectResult2= topCategoryMapper.selectTopCategory(param);
		System.out.println("## select result 2: " + selectResult2);
		
		
	}
}
