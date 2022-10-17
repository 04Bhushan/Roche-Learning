package com.kafka.KafkaTesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	KafkaProducer producer;
	
	@GetMapping("/kafkatest")
	public ResponseEntity<String> kafkaTest(@RequestParam String message) {
//		producer.addToCart(obj);
		System.out.println(message);
		producer.sendMessage(message);
		return ResponseEntity.ok("message sent");
	}

}
