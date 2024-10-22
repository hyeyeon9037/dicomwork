package com.study.dicom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dicom.domain.StudyTab;
import com.study.dicom.repository.StudyTabRepository;

@Service
public class StudyTabService {

    @Autowired
    StudyTabRepository studyTabRepository;

    // 기본 목록 조회
    public List<StudyTab> list() {
        return studyTabRepository.findAllByOrderByStudyKeyDesc();
    }

    // 기존 필터 검색 (pid, pname, reportStatus, modality)
    public List<StudyTab> searchStudyTab(String pid, String pname, Long reportStatus, String modality) {
        return studyTabRepository.findStudyTabsByCriteria(pid, pname, reportStatus, modality);
    }

    // studyDate를 기준으로 날짜 범위 검색
    public List<StudyTab> findStudyByDateRange(String startDate, String endDate) {
        return studyTabRepository.findByStudyDateBetween(startDate, endDate);
    }
}
