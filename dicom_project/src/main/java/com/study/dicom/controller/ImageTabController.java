package com.study.dicom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.dicom.service.ImageTabService;

@Controller
public class ImageTabController {
	
	
	@Autowired
	ImageTabService imageTabService;
	
	
}
