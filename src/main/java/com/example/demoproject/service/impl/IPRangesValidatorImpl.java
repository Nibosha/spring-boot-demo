package com.example.demoproject.service.impl;

import com.example.demoproject.exception.ValidationException;
import com.example.demoproject.service.IPRangesValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demoproject.utils.Constants.REGION_ALL;

@Service
public class IPRangesValidatorImpl implements IPRangesValidator {

    @Value("${aws.ip-ranges.valid-regions}")
    private List<String> validIPRegions;

    @Override
    public void validateRegion(String region) {
        if(region == null || region.isEmpty()) {
            throw new ValidationException("Region is null or empty");
        } else if (!REGION_ALL.equals(region) && !validIPRegions.contains(region)) {
            throw new ValidationException("Invalid region: " + region);
        }
    }
}
