package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.model.Feature;

/**
 * DAO class for feature
 * @author Shawn Tan
 *
 */
public interface FeatureDao extends JpaRepository<Feature, Integer>{

	@Query("FROM Feature WHERE email = ?1 AND featName = ?2")
	List<Feature> findByEmailNFeatName(String email, String featName);
	
}
