package com.bpi.enterpriseapi.configuration.properties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.bpi.framework.config.properties.SoapApiConfigProperties;

import lombok.ToString;

@Component
@ConfigurationProperties("bpi.webservice.eolng.checkbook.dbcr")
@ToString(callSuper = true)
public class CheckbookDbcrSoapConfigProperties extends SoapApiConfigProperties{
	
}
