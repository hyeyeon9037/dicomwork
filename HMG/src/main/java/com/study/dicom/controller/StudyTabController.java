package com.study.dicom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.dicom.domain.StudyTab;
import com.study.dicom.service.StudyTabService;

@Controller
public class StudyTabController {

    @Autowired
    StudyTabService studyTabService;

    // 기본 StudyTab 목록 조회
    @GetMapping("/StudyTabList")
    public String list(Model model) {
        List<StudyTab> study = studyTabService.list();
        model.addAttribute("study", study);
        return "admin/Study/StudyList";
    }

    // 기존 필터 검색 (pid, pname, reportStatus, modality)
    @GetMapping("/search")
    public String search(@RequestParam(value = "pid", required = false) String pid,
                         @RequestParam(value = "pname", required = false) String pname,
                         @RequestParam(value = "reportStatus", required = false) Long reportStatus,
                         @RequestParam(value = "modality", required = false) String modality, 
                         Model model) {

        List<StudyTab> study = studyTabService.searchStudyTab(pid, pname, reportStatus, modality);
        model.addAttribute("study", study);
        return "admin/Study/StudyList";
    }

    // 날짜 범위 검색 (studyDate를 기준으로)
    @GetMapping("/searchByDate")
    public String searchByDate(@RequestParam("startDate") String startDate,
                               @RequestParam("endDate") String endDate,
                               Model model) {

        List<StudyTab> studyList = studyTabService.findStudyByDateRange(startDate, endDate);
        model.addAttribute("study", studyList);  // 키값도 똑같이 해줘야함 StudyList에 
        return "admin/Study/StudyList";
    }
    
    // 새로운 달력페이지 넘어가게 검색
    @GetMapping("/calendar")
    public String calendar() {
        return "fragments/calendar"; // calendar.html로 이동
    }
    

    
}
