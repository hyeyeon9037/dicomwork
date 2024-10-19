package com.study.dicom.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SeriesTabId {

	
			
	    @Column(name = "STUDYKEY", nullable = false)
	    private Long studyKey;

	    
	    @Column(name = "SERIESKEY", nullable = false)
	    private Long seriesKey;
}
