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
import com.musinsa.category.domain.BrandCodeMstDTO;
import com.musinsa.category.service.BrandCodeMstService;

@RestController
public class BrandCodeMstController {
	
	private static final Logger logger = LoggerFactory.getLogger(BrandCodeMstController.class);
	
	@Autowired
	private BrandCodeMstService brandCodeMstService;
	
	@GetMapping(value="/brand-code-mst/{brandId}")
	public JsonObject selectBrandCodeMstList(@PathVariable("brandId") Long brandId, @ModelAttribute("params") BrandCodeMstDTO params) {
		
		JsonObject resultObject = null;
		
		try {
			resultObject = selectBrandCodeMst(params);
		} catch (Exception e) {
			logger.error(String.format("fail to select middleCategoryList, param : %s, error.detail => %s", params.toString(), e.getMessage()), e);
			resultObject.addProperty("message", "brand master table을 조회할 수 없습니다.");
		}
		logger.info("resultObject : " + resultObject);
		
		return resultObject;
	}
	
	
	@GetMapping(value="/brand-code-mst")
	public JsonObject selectBrandCodeMstListAll () {

		JsonObject resultObject = new JsonObject();
		BrandCodeMstDTO params = new BrandCodeMstDTO();
		try {
			resultObject = selectBrandCodeMst(params);
		} catch (Exception e) {
			logger.error(String.format("fail to selectJob, param : %s, error.detail => %s", params.toString(), e.getMessage()), e);
			resultObject.addProperty("message", "brand master table을 조회할 수 없습니다.");
		}
		logger.info("jsonObject : " + resultObject);

		return resultObject;
	}
	
	
	
	/**
	 * @param middleId
	 * @param params
	 * 
	 * sample json)
	 * 		{"brandName" : "brand_name_change"}
	 * @return
	 */
	@RequestMapping(value = { "/brand-code-mst", "/brand-code-mst/{brandId}" }, method = { RequestMethod.POST, RequestMethod.PUT })
	public JsonObject registerBrandCodeMst(@PathVariable(value = "brandId", required = false) Long brandId, @RequestBody BrandCodeMstDTO params) {

		JsonObject jsonObj = new JsonObject();
		boolean isSuccess = false;
		try {
			
			if (brandId != null) {
				params.setBrandId(brandId);
				
				isSuccess = brandCodeMstService.updateBrandCodeMst(params);
			} else {
				isSuccess = brandCodeMstService.insertBrandCodeMst(params);
			}

			jsonObj.addProperty("result", isSuccess);

		} catch (Exception e) {
			logger.error(String.format("fail to registerJob, param : %s, error.detail => %s", params.toString(), e.getMessage()) ,e);
			jsonObj.addProperty("message", "시스템에 문제가 발생하였습니다.");
		}

		return jsonObj;
	}
	
	
	
	@DeleteMapping(value = "/brand-code-mst/{brandId}")
	public JsonObject deleteBrandCodeMst(@PathVariable("brandId") final Long brandId) {

		JsonObject jsonObj = new JsonObject();

		try {
			boolean isDeleted = brandCodeMstService.deleteBrandCodeMst(brandId);
			jsonObj.addProperty("result", isDeleted);

		} catch (Exception e) {
			logger.error(String.format("fail to deleteJob, param : %d, error.detail => %s", brandId, e.getMessage()) ,e);
			jsonObj.addProperty("message", "시스템에 문제가 발생하였습니다.");
		}

		return jsonObj;
	}
	
	
	
	
	private JsonObject selectBrandCodeMst(BrandCodeMstDTO params) throws Exception {
		
		JsonObject resultObject = new JsonObject();
		JsonArray selectResultArr = new JsonArray();
		
		List<BrandCodeMstDTO> topCategoryList = brandCodeMstService.selectBrandCodeMst(params);
		selectResultArr = new Gson().toJsonTree(topCategoryList).getAsJsonArray();
		
		resultObject.add("middleCategoryList", selectResultArr);
		
		return resultObject;
	}
	
	
}
