package com.nt.cms;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nt.client.IBillingServiceRestController;

@RestController
@RequestMapping("/billing")
public class BillingServiceOperationController {

	@Autowired
	private IBillingServiceRestController clientComp;

	@GetMapping("/get")
	public ResponseEntity<String> showBillingAmount() {

		double billAmount = new Random().nextDouble(1000000.0);

		System.out.println("Billing Service Controller   " + clientComp.getClass().getName());

		String finalResult = "Bill Amount   " + billAmount + "    And Payment option are:::: "
				+ clientComp.fetchAllService();
		return new ResponseEntity<String>(finalResult, HttpStatus.OK);

	}

}
