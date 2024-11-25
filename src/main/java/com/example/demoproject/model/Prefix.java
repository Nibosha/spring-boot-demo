package com.example.demoproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Prefix {
	
	@ApiModelProperty(name = "ip_prefix")
	@JsonProperty("ip_prefix")
	private String ipPrefix;
	
	@ApiModelProperty
	@JsonProperty
	private String region;
	
	@ApiModelProperty
	@JsonProperty
	private String service;
	
	@ApiModelProperty(name = "network_border_group")
	@JsonProperty("network_border_group")
	private String networkBorderGroup;

}
