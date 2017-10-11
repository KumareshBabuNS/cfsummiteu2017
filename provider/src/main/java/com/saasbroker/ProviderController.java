package com.saasbroker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProviderController {
	private static final String template = "I'm a Service Template %s";


	@RequestMapping("/info")
	public String info(@RequestParam(value = "v") String name) {
		return String.format(template, name);
	}
}
