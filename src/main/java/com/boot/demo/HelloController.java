package com.boot.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Autowired
	private DiscoveryClient discoveryClient;
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	
	@GetMapping("/hello")
	public String sayHello(){
		ServiceInstance instances = discoveryClient.getLocalServiceInstance();
//		String id0 = discoveryClient.getServices().get(0);
//		discoveryClient.getInstances(id0).get(0).getHost();
		
		logger.info("/hello ,host:{} ,service_id:{}" , instances.getHost() , instances.getServiceId());
		return   instances.getHost() +" ;  "+instances.getServiceId() ;
	}

}
