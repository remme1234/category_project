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
import com.musinsa.category.domain.MiddleCategoryDTO;
import com.musinsa.category.service.MiddleCategoryService;

@RestController
public class MiddleCategoryController {
	
	private static final Logger logger = LoggerFactory.getLogger(MiddleCategoryController.class);
	
	@Autowired
	private MiddleCategoryService middleCategoryService;
	
	@GetMapping(value="/top-category/{topId}/middle-category/{middleId}")
	public JsonObject selectMiddleCategoryList(@PathVariable("topId") Long topId, @PathVariable("middleId") Long middleId,
			@ModelAttribute("params") MiddleCategoryDTO params) {
		
		JsonObject resultObject = null;
		
		if(params.getTopId() == null || params.getTopId() == 0) {
			throw new IllegalStateException("select middle-category 'topId' data is essential");
		}
		
		try {
			resultObject = selectMiddleCategory(params);
		} catch (Exception e) {
			logger.error(String.format("fail to select middleCategoryList, param : %s, error.detail => %s", params.toString(), e.getMessage()), e);
			resultObject.addProperty("message", "중위 메뉴를 조회할 수 없습니다.");
		}
		logger.info("resultObject : " + resultObject);
		
		return resultObject;
	}
	
	
	@GetMapping(value="/top-category/{topId}/middle-category")
	public JsonObject selectMiddleCategoryListAll (@PathVariable("topId") Long topId, @ModelAttribute("params") MiddleCategoryDTO params) {

		JsonObject resultObject = new JsonObject();
		try {
			resultObject = selectMiddleCategory(params);
		} catch (Exception e) {
			logger.error(String.format("fail to selectJob, param : %s, error.detail => %s", params.toString(), e.getMessage()), e);
			resultObject.addProperty("message", "중위 메뉴를 조회할 수 없습니다.");
		}
		logger.info("jsonObject : " + resultObject);

		return resultObject;
	}
	
	
	
	/**
	 * @param middleId
	 * @param params
	 * 
	 * sample json)
	 * 		{"topId" : 1, "middleName" : "insert_top_category_change"}
	 * @return
	 */
	@RequestMapping(value = { "/middle-category", "/middle-category/{middleId}" }, method = { RequestMethod.POST, RequestMethod.PUT })
	public JsonObject registerMiddleCategory(@PathVariable(value = "middleId", required = false) Long middleId, @RequestBody MiddleCategoryDTO params) {

		JsonObject jsonObj = new JsonObject();
		boolean isSuccess = false;
		try {

			if(params.getTopId() == null || params.getTopId() == 0) {
				throw new IllegalStateException("register middle-category 'topId' data is essential");
			}
			
			if (middleId != null) {
				params.setMiddleId(middleId);
				
				isSuccess = middleCategoryService.updateMiddleCategory(params);
			} else {
				isSuccess = middleCategoryService.insertMiddleCategory(params);
			}

			jsonObj.addProperty("result", isSuccess);

		} catch (Exception e) {
			logger.error(String.format("fail to registerJob, param : %s, error.detail => %s", params.toString(), e.getMessage()) ,e);
			jsonObj.addProperty("message", "시스템에 문제가 발생하였습니다.");
		}

		return jsonObj;
	}
	
	
	
	@DeleteMapping(value = "/middle-category/{middleId}")
	public JsonObject deleteMiddleCategory(@PathVariable("middleId") final Long middleId) {

		JsonObject jsonObj = new JsonObject();

		try {
			boolean isDeleted = middleCategoryService.deleteMiddleCategory(middleId);
			jsonObj.addProperty("result", isDeleted);

		} catch (Exception e) {
			logger.error(String.format("fail to deleteJob, param : %d, error.detail => %s", middleId, e.getMessage()) ,e);
			jsonObj.addProperty("message", "시스템에 문제가 발생하였습니다.");
		}

		return jsonObj;
	}
	
	
	
	
	private JsonObject selectMiddleCategory(MiddleCategoryDTO params) throws Exception {
		
		JsonObject resultObject = new JsonObject();
		JsonArray selectResultArr = new JsonArray();
		
		List<MiddleCategoryDTO> topCategoryList = middleCategoryService.selectMiddleCategory(params);
		selectResultArr = new Gson().toJsonTree(topCategoryList).getAsJsonArray();
		
		resultObject.add("middleCategoryList", selectResultArr);
		
		return resultObject;
	}
	
	
}
