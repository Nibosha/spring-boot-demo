package com.example.demoproject.service.impl;

import com.example.demoproject.model.AWSIPRangesResponseDto;
import com.example.demoproject.service.ExternalCallService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ExternalCallServiceImpl implements ExternalCallService {

    @Value("${aws.ip-ranges.url}")
    private String awsIPRangesUrl;

    @Override
    public AWSIPRangesResponseDto callAWSIPRanges() {
        WebClient webClient = WebClient
                .builder()
                .baseUrl(awsIPRangesUrl)
                .exchangeStrategies(ExchangeStrategies
                        .builder()
                        .codecs(codecs -> codecs
                                .defaultCodecs()
                                .maxInMemorySize(5000 * 1024))
                        .build())
                .build();
        Mono<AWSIPRangesResponseDto> responseDtoMono = webClient.get()
                .retrieve().bodyToMono(AWSIPRangesResponseDto.class);
        return responseDtoMono.block();
    }
}
