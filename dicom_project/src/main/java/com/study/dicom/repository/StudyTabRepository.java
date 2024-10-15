package com.study.dicom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.dicom.domain.StudyTab;

public interface StudyTabRepository {

@Repository
public interface domainRepository extends JpaRepository<StudyTab, Long>{

	}
}


