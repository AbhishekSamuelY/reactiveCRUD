package com.abhisheksamuely.reactive.controller;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class ReactiveController {

	@GetMapping("/demo")
	public Mono<String> getDemo(){
		return getGreetings().zipWith(getUser())
		.map(value -> {
			return value.getT1() + value.getT2();
		});
	}

	private Mono<String> getGreetings() {
		return Mono.just("Hello").delayElement(Duration.ofSeconds(5));
	}
	
	private Mono<String> getUser() {
		return Mono.just(" world").delayElement(Duration.ofSeconds(5));
	}
}
