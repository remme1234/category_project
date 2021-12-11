package com.musinsa.category;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.musinsa.category.domain.TopCategoryDTO;
import com.musinsa.category.service.TopCategoryService;

@SpringBootTest
public class TopCategoryTest {

	
	@Autowired
	private TopCategoryService topCategoryService;
	
	
	@Test
	public void getCommentList() throws Exception {
		TopCategoryDTO params = new TopCategoryDTO();
		params.setTopId((long)4); // 댓글을 추가할 게시글 번호

		List<TopCategoryDTO> resultList = topCategoryService.selectTopCategory(params);
		
		System.out.println(resultList);
		
	}
}
