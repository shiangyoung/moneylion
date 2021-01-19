package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.FeatureDao;
import com.example.demo.model.Feature;
import com.example.demo.model.FeaturePk;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * REST Controller for feature
 * @author Shawn Tan
 *
 */
@Controller
@RestController
@RequestMapping("/feature")
@Api(tags = "Feature")
public class FeatureController {
	
	@Autowired
	FeatureDao featureDao;
	
	/**
	 * Add feature
	 * @param feature {@link Feature}
	 * @return result of the added feature
	 */
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Add feature")
	public Feature addFeature(@RequestBody Feature feature) {
		return featureDao.save(feature);
	}
	
	/**
	 * Get feature by primary key (Feature Id)
	 * @param featId Feature Id
	 * @return Result of the feature Id
	 */
	@GetMapping(path = "/email/{email}/featureName/{featureName}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Get feature by email and feature name")
	public Optional<Feature> getFeature(@PathVariable("email") String email, @PathVariable("featureName") String featName) {
		FeaturePk featurePk = new FeaturePk(email, featName);
		return featureDao.findById(featurePk);
	}
	
	/**
	 * Update Feature 
	 * @param feature {@link Feature}
	 * @return {@link Feature} object after update
	 */
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update feature")
	public ResponseEntity<Feature> updateFeature(@RequestBody Feature feature) {
		FeaturePk featurePk = new FeaturePk(feature.getEmail(), feature.getFeatName());
		Optional<Feature> featureOption = featureDao.findById(featurePk);
		if(featureOption.isPresent()) {
			featureDao.save(feature);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}
	
	/**
	 * Get access indicator based on email and feature name
	 * @param email Email
	 * @param featName Feature Name
	 * @return Result of the access 
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get access by email and feature name")
	public Object getAccess (@RequestParam(value = "email", required = true) String email, 
			@RequestParam(value = "featureName", required = true) String featName) {
		Map<String, Object> result = new HashMap<>();
		boolean access = false;
		FeaturePk featurePk = new FeaturePk(email, featName);
		Optional<Feature>  featureOption = featureDao.findById(featurePk);
		if(featureOption.isPresent()) {
			access = featureOption.get().getAccess();
		}
		result.put("canAccess", access);
		return result;
	}

	/**
	 * Delete by primary key (Feature Id)
	 * @param featId Feature Id
	 */
	@DeleteMapping(path = "/email/{email}/featureName/{featureName}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Delete feature by email and feature name")
	public void deleteByPk(@PathVariable("email") String email, @PathVariable("featureName") String featName) {
		FeaturePk featurePk = new FeaturePk(email, featName);
		featureDao.deleteById(featurePk);
	}
}
