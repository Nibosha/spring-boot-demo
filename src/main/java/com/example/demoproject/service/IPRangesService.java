package com.example.demoproject.service;

import com.example.demoproject.model.AWSIPRangesResponseDto;

public interface IPRangesService {
	
	AWSIPRangesResponseDto getIpRanges(String region);

}
