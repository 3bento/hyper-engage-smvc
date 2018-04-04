package com.kennycode.hyperengagesmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

	@RequestMapping("/")
	@ResponseBody
	String name() {
		return "Hello world!";
	}
}
