package com.study.dicom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.study.dicom.service.ImageTabService;

@Controller
public class ImageTabController {
	
	
	@Autowired
	ImageTabService imageTabService;

	
	
	
}
