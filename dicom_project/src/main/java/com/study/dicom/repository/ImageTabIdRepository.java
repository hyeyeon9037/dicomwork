package com.study.dicom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.dicom.domain.ImageTabId;

@Repository
public interface ImageTabIdRepository extends JpaRepository<ImageTabId, Long> {
	
}
