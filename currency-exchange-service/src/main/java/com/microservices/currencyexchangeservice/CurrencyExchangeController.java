package com.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepo currencyExhangeRepo; 

    @Autowired
    private Environment environment;
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public  CurrencyExchange retrieveExchangeValue(@PathVariable String from,@PathVariable String to){

//        CurrencyExchange currencyExchange = new CurrencyExchange(100L,from,to, BigDecimal.valueOf(50));
    	CurrencyExchange currencyExchange = currencyExhangeRepo.findByFromAndTo(from, to);
    	
    	if(currencyExchange== null) {
    		throw new RuntimeException("Unabble to find the Data "+from +" to "+to);
    	}

        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        return currencyExchange;

    }
}
