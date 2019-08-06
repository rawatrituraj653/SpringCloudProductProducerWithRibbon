package com.shivam.motors.maruti.consumer;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MarutiModelConsumer {

	@Autowired
	private LoadBalancerClient client;
	
	public String  getMsg() {
		System.out.println(client.getClass().getName());
		
		ServiceInstance instance= client.choose("MODEL-PROD");
		URI uri =instance.getUri();
		String url=uri+"/model/show";
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<String> entity=
				restTemplate.getForEntity(url,String.class);
		
		String string=entity.getBody();
		
		String getClass=client.getClass().getName();
		
		return getClass+"..."+string;
	}
	 
	public String getOneModel() {
		
		ServiceInstance instance=client.choose("MODEL-PROD");
		URI uri=instance.getUri();
	String data=new RestTemplate().getForEntity(uri+"/model/one",String.class).getBody();
		
		return data;
	} 
	
	public String getAllModel() {
		ServiceInstance instance=client.choose("MODEL-PROD");
		URI uri=instance.getUri();
		
	return new RestTemplate()
			.getForEntity(uri+"/model/all", String.class)
			.getBody();
	}
	
	
	
	
}
