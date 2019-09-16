package com.bpi.enterpriseapi.configuration;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bpi.enterpriseapi.configuration.properties.CheckbookDbcrSoapConfigProperties;
import com.bpi.framework.component.soap.SoapApiConfigurerComponent;
import com.bpi.framework.config.SoapConfigurerAdapter;
import com.ibcb1in.ibcboc1a.IBCBOC1APort;

@Configuration
public class SoapEndpointConfig extends SoapConfigurerAdapter{
	
	@Autowired
	private SoapApiConfigurerComponent configurer;
	
	@Autowired
	private CheckbookDbcrSoapConfigProperties eolNgCheckbookDbcrSoapConfigProperties;
	
	 @Bean
		public IBCBOC1APort eolNgCheckbookDbcrPort() {
			return configurer.configure(eolNgCheckbookDbcrSoapConfigProperties, IBCBOC1APort.class);
	 }
	 
	 @Override
	    public void addPorts(Set<Object> ports) {
		 ports.add(eolNgCheckbookDbcrPort());
	 }
	 
}
	

