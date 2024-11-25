package com.example.demoproject.controller.impl;

import com.example.demoproject.controller.DemoController;
import com.example.demoproject.model.AWSIPRangesResponseDto;
import com.example.demoproject.service.IPRangesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demoproject.utils.Constants.IP_RANGES_BASE_PATH;

@RestController
@RequestMapping(IP_RANGES_BASE_PATH)
@RequiredArgsConstructor
public class DemoControllerImpl implements DemoController {

    private final IPRangesService ipRangesService;

    @Override
    @GetMapping
    public ResponseEntity<AWSIPRangesResponseDto> getIps(String region) {
        return ResponseEntity.ok(ipRangesService.getIpRanges(region));
    }
}
