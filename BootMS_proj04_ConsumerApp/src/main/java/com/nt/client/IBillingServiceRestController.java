package com.nt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Billing.Service")
public interface IBillingServiceRestController {
	
	@GetMapping("/billing/info")
   public String fetchAllService();	

}
