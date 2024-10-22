package com.study.dicom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.dicom.domain.StudyTab;

@Repository
public interface StudyTabRepository extends JpaRepository<StudyTab, Long> {

    // 기본 목록 조회: StudyKey 내림차순 정렬
    List<StudyTab> findAllByOrderByStudyKeyDesc();

    // 기존 검색 메서드: pid, pname, reportStatus, modality 필터를 이용한 검색
    @Query("SELECT s FROM STUDYTAB s WHERE "
            + "(:pid IS NULL OR s.pid LIKE %:pid%) "
            + "AND (:pname IS NULL OR s.pname LIKE %:pname%) "
            + "AND (:reportStatus = 0 OR s.reportStatus = :reportStatus) "
            + "AND (:modality IS NULL OR s.modality = :modality)")
    List<StudyTab> findStudyTabsByCriteria(@Param("pid") String pid,
                                           @Param("pname") String pname,
                                           @Param("reportStatus") Long reportStatus,
                                           @Param("modality") String modality);

    // 날짜 범위로 studyDate 필드에 따른 검색 메서드
    @Query("SELECT s FROM STUDYTAB s WHERE s.studyDate BETWEEN :startDate AND :endDate")
    List<StudyTab> findByStudyDateBetween(@Param("startDate") String startDate, 
                                          @Param("endDate") String endDate);
}
