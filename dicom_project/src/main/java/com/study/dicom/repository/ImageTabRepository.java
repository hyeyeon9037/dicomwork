package com.study.dicom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.dicom.domain.ImageTab;
import com.study.dicom.domain.ImageTabId;

@Repository
public interface ImageTabRepository extends JpaRepository<ImageTab, ImageTabId>{
	
	

}
