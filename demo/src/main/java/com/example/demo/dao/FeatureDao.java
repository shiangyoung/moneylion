package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Feature;
import com.example.demo.model.FeaturePk;

/**
 * DAO class for feature
 * @author Shawn Tan
 *
 */
public interface FeatureDao extends JpaRepository<Feature, FeaturePk>{
	
}
