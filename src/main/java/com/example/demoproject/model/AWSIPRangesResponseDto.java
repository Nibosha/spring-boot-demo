package com.example.demoproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class AWSIPRangesResponseDto {
	
	@ApiModelProperty
	@JsonProperty
	private String syncToken;
	
	@ApiModelProperty
	@JsonProperty
	private String createDate;
	
	@ApiModelProperty
	@JsonProperty
	private List<Prefix> prefixes;

}
