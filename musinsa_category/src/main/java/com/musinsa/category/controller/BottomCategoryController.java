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
import com.musinsa.category.domain.BottomCategoryDTO;
import com.musinsa.category.service.BottomCategoryService;

@RestController
public class BottomCategoryController {
	
	private static final Logger logger = LoggerFactory.getLogger(BottomCategoryController.class);
	
	@Autowired
	private BottomCategoryService bottomCategoryService;
	
	
	
	@GetMapping(value="/middle-category/{middleId}/bottom-category")
	public JsonObject selectBottomCategoryListAll (@PathVariable("middleId") Long middleId, @ModelAttribute("params") BottomCategoryDTO params) {

		JsonObject resultObject = new JsonObject();
		try {
			
			logger.info("####### param : " + params);
			
			resultObject = selectBottomCategory(params);
		} catch (Exception e) {
			logger.error(String.format("fail to selectJob, param : %s, error.detail => %s", params.toString(), e.getMessage()), e);
			resultObject.addProperty("message", "하위 메뉴를 조회할 수 없습니다.");
		}
		logger.info("jsonObject : " + resultObject);

		return resultObject;
	}
	
	
	@GetMapping(value="/middle-category/{middleId}/bottom-category/{bottomId}")
	public JsonObject selectBottomCategoryList(@PathVariable("middleId") Long middleId, @PathVariable("bottomId") Long bottomId,
			@ModelAttribute("params") BottomCategoryDTO params) {
		
		JsonObject resultObject = null;
		
		if(params.getMiddleId() == null || params.getMiddleId() == 0) {
			throw new IllegalStateException("select bottom-category 'middleId' data is essential");
		}
		
		try {
			resultObject = selectBottomCategory(params);
		} catch (Exception e) {
			logger.error(String.format("fail to selectJob, param : %s, error.detail => %s", params.toString(), e.getMessage()), e);
			resultObject.addProperty("message", "하위 메뉴를 조회할 수 없습니다.");
		}
		logger.info("resultObject : " + resultObject);
		
		return resultObject;
	}
	
	
	@GetMapping(value="/brand/{brandId}")
	public JsonObject selectBottomCategoryOrderBrandId (@PathVariable("brandId") Long brandId, @ModelAttribute("params") BottomCategoryDTO params) {
		
		JsonObject resultObject = new JsonObject();
		try {
			resultObject = selectBottomCategory(params);
		} catch (Exception e) {
			logger.error(String.format("fail to selectJob, param : %s, error.detail => %s", params.toString(), e.getMessage()), e);
			resultObject.addProperty("message", "하위 메뉴를 조회할 수 없습니다.");
		}
		logger.info("jsonObject : " + resultObject);
		
		return resultObject;
	}
	
	
	@GetMapping(value="/best-item/{bestItem}")
	public JsonObject selectBottomCategoryOrderBestItem (@PathVariable("bestItem") Boolean bestItem, @ModelAttribute("params") BottomCategoryDTO params) {
		
		JsonObject resultObject = new JsonObject();
		try {
			resultObject = selectBottomCategory(params);
		} catch (Exception e) {
			logger.error(String.format("fail to selectJob, param : %s, error.detail => %s", params.toString(), e.getMessage()), e);
			resultObject.addProperty("message", "하위 메뉴를 조회할 수 없습니다.");
		}
		logger.info("jsonObject : " + resultObject);
		
		return resultObject;
	}
	
	
	
	/**
	 * @param middleId
	 * @param params
	 * 
	 * sample json)
	 * 		{"middleId" : 1, "bottomName" : "insert_top_category_change", "brandId":1}
	 * @return
	 */
	@RequestMapping(value = { "/bottom-category", "/bottom-category/{bottomId}" }, method = { RequestMethod.POST, RequestMethod.PUT })
	public JsonObject registerBottomCategory(@PathVariable(value = "bottomId", required = false) Long bottomId, @RequestBody BottomCategoryDTO params) {

		JsonObject jsonObj = new JsonObject();
		boolean isSuccess = false;
		try {

			validatorParam(params);
			
			if (bottomId != null) {
				params.setBottomId(bottomId);
				
				isSuccess = bottomCategoryService.updateBottomCategory(params);
			} else {
				isSuccess = bottomCategoryService.insertBottomCategory(params);
			}

			jsonObj.addProperty("result", isSuccess);

		} catch (Exception e) {
			logger.error(String.format("fail to registerJob, param : %s, error.detail => %s", params.toString(), e.getMessage()) ,e);
			jsonObj.addProperty("message", "시스템에 문제가 발생하였습니다.");
		}

		return jsonObj;
	}
	
	
	
	@DeleteMapping(value = "/bottom-category/{bottomId}")
	public JsonObject deleteBottomCategory(@PathVariable("bottomId") final Long bottomId) {

		JsonObject jsonObj = new JsonObject();

		try {
			boolean isDeleted = bottomCategoryService.deleteBottomCategory(bottomId);
			jsonObj.addProperty("result", isDeleted);

		} catch (Exception e) {
			logger.error(String.format("fail to deleteJob, param : %d, error.detail => %s", bottomId, e.getMessage()) ,e);
			jsonObj.addProperty("message", "시스템에 문제가 발생하였습니다.");
		}

		return jsonObj;
	}
	
	
	
	
	private JsonObject selectBottomCategory(BottomCategoryDTO params) throws Exception {
		
		JsonObject resultObject = new JsonObject();
		JsonArray selectResultArr = new JsonArray();
		
		List<BottomCategoryDTO> topCategoryList = bottomCategoryService.selectBottomCategory(params);
		selectResultArr = new Gson().toJsonTree(topCategoryList).getAsJsonArray();
		
		resultObject.add("middleCategoryList", selectResultArr);
		
		return resultObject;
	}
	

	private void validatorParam(BottomCategoryDTO params) {
		
		if(params.getMiddleId() == null || params.getMiddleId() == 0) {
			throw new IllegalStateException(String.format("bottom-categroy registJob need '%s'", "middleId"));
		}
		
		if(params.getBrandId() == null || params.getBrandId() == 0) {
			throw new IllegalStateException(String.format("bottom-categroy registJob need '%s'", "brandId"));
		}
	}

}
