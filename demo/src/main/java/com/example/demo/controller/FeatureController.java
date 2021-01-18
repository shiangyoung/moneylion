package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.FeatureDao;
import com.example.demo.model.Feature;

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
	@PutMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Add feature")
	public Feature addFeature(Feature feature) {
		return featureDao.save(feature);
	}
	
	/**
	 * Get feature by primary key (Feature Id)
	 * @param featId Feature Id
	 * @return Result of the feature Id
	 */
	@GetMapping(path = "/{featId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Get feature by feature id")
	public Optional<Feature> getFeature(@PathVariable("featId") Integer featId) {
		return featureDao.findById(featId);
	}
	
	/**
	 * Update Feature 
	 * @param feature {@link Feature}
	 * @return {@link Feature} object after update
	 */
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update feature")
	public ResponseEntity<Feature> updateFeature(Feature feature) {
		Optional<Feature> featureOption = featureDao.findById(feature.getFeatId());
		if(featureOption.isPresent()) {
			return new ResponseEntity<>(featureDao.save(feature), HttpStatus.OK);
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
		List<Feature> featureList = featureDao.findByEmailNFeatName(email, featName);
		if(!CollectionUtils.isEmpty(featureList)) {
			Feature feature = featureList.get(0);
			access = feature.getAccess();
		}
		result.put("canAccess", access);
		return result;
	}

}
