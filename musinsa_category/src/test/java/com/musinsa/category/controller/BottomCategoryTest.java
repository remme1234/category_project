package com.musinsa.category.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.musinsa.category.domain.BottomCategoryDTO;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BottomCategoryTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BottomCategoryTest.class);
	
	@Autowired
	protected MockMvc mockMvc;
	
	@Autowired
	protected ObjectMapper objectMapper;
	
	
	@Test
	@Order(4)
	public void getTest() throws Exception {
		String url = "/middle-category/1/bottom-category";
		
		mockMvc.perform(MockMvcRequestBuilders.get(url)
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(result -> {
				MockHttpServletResponse response = result.getResponse();
				logger.info(response.getContentAsString());
			});
	}
	
	@Test
	@Order(1)
	public void postTest() throws Exception {
		String url = "/bottom-category";
		BottomCategoryDTO dto = new BottomCategoryDTO();
		dto.setMiddleId((long) 1);
		dto.setBrandId((long) 1);
		dto.setBottomName("test_name");
		
		String content = objectMapper.writeValueAsString(dto);
		logger.info("post content : " + content);
		
		
		mockMvc.perform(MockMvcRequestBuilders.post(url)
			.content(content)
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(result -> {
				MockHttpServletResponse response = result.getResponse();
				logger.info(response.getContentAsString());
			});
	}
	
	
	@Test
	@Order(2)
	public void putTest() throws Exception {
		String url = "/bottom-category/1";
		BottomCategoryDTO dto = new BottomCategoryDTO();
		dto.setMiddleId((long) 1);
		dto.setBrandId((long) 1);
		dto.setBottomName("test_name_change");
		
		String content = objectMapper.writeValueAsString(dto);
		logger.info("put content : " + content);
		
		
		mockMvc.perform(MockMvcRequestBuilders.put(url)
			.content(content)
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(result -> {
				MockHttpServletResponse response = result.getResponse();
				logger.info(response.getContentAsString());
			});
	}
	
	@Test
	@Order(3)
	public void deleteTest() throws Exception {
		String url = "/bottom-category/5";
		BottomCategoryDTO dto = new BottomCategoryDTO();
		
		String content = objectMapper.writeValueAsString(dto);
		logger.info("delete content : " + content);
		
		
		mockMvc.perform(MockMvcRequestBuilders.delete(url)
				.content(content)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(result -> {
			MockHttpServletResponse response = result.getResponse();
			logger.info(response.getContentAsString());
		});
	}
}
