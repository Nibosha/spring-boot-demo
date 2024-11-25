package com.example.demoproject.controller;

import com.example.demoproject.model.AWSIPRangesResponseDto;
import org.springframework.http.ResponseEntity;

public interface DemoController {
	
	ResponseEntity<AWSIPRangesResponseDto> getIps(String region);

}
