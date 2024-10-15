package com.study.dicom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.dicom.domain.PatientTab;

@Repository
public interface PatientTabRepository extends JpaRepository <PatientTab , String> {

}
