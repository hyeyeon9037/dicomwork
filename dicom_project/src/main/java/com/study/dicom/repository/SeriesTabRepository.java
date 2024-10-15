package com.study.dicom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.dicom.domain.SeriesTab;
import com.study.dicom.domain.SeriesTabId;

@Repository
public interface SeriesTabRepository extends JpaRepository<SeriesTab,SeriesTabId>{

}