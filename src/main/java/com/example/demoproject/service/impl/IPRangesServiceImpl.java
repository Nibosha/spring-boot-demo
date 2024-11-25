package com.example.demoproject.service.impl;

import com.example.demoproject.model.AWSIPRangesResponseDto;
import com.example.demoproject.model.Prefix;
import com.example.demoproject.service.ExternalCallService;
import com.example.demoproject.service.IPRangesService;
import com.example.demoproject.service.IPRangesValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.example.demoproject.utils.Constants.REGION_ALL;

@Service
@RequiredArgsConstructor
public class IPRangesServiceImpl implements IPRangesService {

    private final IPRangesValidator ipRangesValidator;
    private final ExternalCallService externalCallService;

    @Override
    public AWSIPRangesResponseDto getIpRanges(String region) {
        ipRangesValidator.validateRegion(region);
        AWSIPRangesResponseDto awsipRangesResponseDto = externalCallService.callAWSIPRanges();
        AWSIPRangesResponseDto filteredResponse = filterAWSResponseByRegion(awsipRangesResponseDto, region);
        return filteredResponse;
    }

    private AWSIPRangesResponseDto filterAWSResponseByRegion(AWSIPRangesResponseDto awsResponse, String region) {
        return AWSIPRangesResponseDto.builder().createDate(awsResponse.getCreateDate()).syncToken(awsResponse.getSyncToken()).prefixes(filerPrefixesByRegion(awsResponse.getPrefixes(), region)).build();
    }

    private List<Prefix> filerPrefixesByRegion(List<Prefix> prefixes, String region) {
        Map<String, List<Prefix>> map = prefixes.stream().collect(Collectors.groupingBy(Prefix::getRegion));
        if(region == null){
            return Collections.emptyList();
        }
        if (prefixes == null || prefixes.isEmpty() || REGION_ALL.equals(region)) {
            return prefixes;
        }
        return prefixes.stream().filter(Objects::nonNull).filter(prefix -> prefix.getRegion().toUpperCase().contains(region)).toList();
    }
}
