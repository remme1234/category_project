package com.musinsa.category.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.musinsa.category.domain.TopCategoryDTO;
import com.musinsa.category.service.TopCategoryService;

@RestController
public class TopCategoryController {
	
	private static final Logger logger = LoggerFactory.getLogger(TopCategoryController.class);
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	
	@GetMapping(value="/top-category/{topId}")
	public JsonObject selectTopCategoryList(@PathVariable("topId") Long topId, @ModelAttribute("params") TopCategoryDTO params) {
		
		JsonObject resultObject = null;
		
		try {
			resultObject = selectTopCategory(params);
		} catch (Exception e) {
			logger.error(String.format("fail to select topCategoryList, param : %s, error.detail => %s", params.toString(), e.getMessage()), e);
			resultObject.addProperty("message", "상위 메뉴를 조회할 수 없습니다.");
		}
		logger.info("resultObject : " + resultObject);
		
		return resultObject;
	}
	
	
	@GetMapping(value="/top-category")
	public JsonObject selectTopCategoryListAll () {

		JsonObject resultObject = new JsonObject();
		TopCategoryDTO params = new TopCategoryDTO();
		try {
			resultObject = selectTopCategory(params);
		} catch (Exception e) {
			logger.error(String.format("fail to select topCategoryList, param : %s, error.detail => %s", params.toString(), e.getMessage()), e);
			resultObject.addProperty("message", "상위 메뉴를 조회할 수 없습니다.");
		}
		logger.info("jsonObject : " + resultObject);

		return resultObject;
	}
	
	
	
	/**
	 * @param topId
	 * @param params
	 * 
	 * sample json)
	 * 		{"topName" : "insert_top_category"}
	 * @return
	 */
	@RequestMapping(value = { "/top-category", "/top-category/{topId}" }, method = { RequestMethod.POST, RequestMethod.PUT })
	public JsonObject registerTopCategory(@PathVariable(value = "topId", required = false) Long topId, @RequestBody TopCategoryDTO params) {

		JsonObject jsonObj = new JsonObject();
		boolean isSuccess = false;
		try {
			
			if (topId != null) {
				params.setTopId(topId);
				
				isSuccess = topCategoryService.updateTopCategory(params);
			} else {
				isSuccess = topCategoryService.insertTopCategory(params);
			}

			jsonObj.addProperty("result", isSuccess);

		} catch (Exception e) {
			logger.error(String.format("fail to registerJob, param : %s, error.detail => %s", params.toString(), e.getMessage()) ,e);
			jsonObj.addProperty("message", "시스템에 문제가 발생하였습니다.");
		}

		return jsonObj;
	}
	
	
	
	@DeleteMapping(value = "/top-category/{topId}")
	public JsonObject deleteTopCategory(@PathVariable("topId") final Long topId) {

		JsonObject jsonObj = new JsonObject();

		try {
			boolean isDeleted = topCategoryService.deleteTopCategory(topId);
			jsonObj.addProperty("result", isDeleted);

		} catch (Exception e) {
			logger.error(String.format("fail to deleteJob, param : %d, error.detail => %s", topId, e.getMessage()) ,e);
			jsonObj.addProperty("message", "시스템에 문제가 발생하였습니다.");
		}

		return jsonObj;
	}
	
	
	
	
	private JsonObject selectTopCategory(TopCategoryDTO params) throws Exception {
		
		JsonObject resultObject = new JsonObject();
		JsonArray selectResultArr = new JsonArray();
		
		List<TopCategoryDTO> topCategoryList = topCategoryService.selectTopCategory(params);
		selectResultArr = new Gson().toJsonTree(topCategoryList).getAsJsonArray();
		
		resultObject.add("topCategoryList", selectResultArr);
		
		return resultObject;
	}
	
	
}
