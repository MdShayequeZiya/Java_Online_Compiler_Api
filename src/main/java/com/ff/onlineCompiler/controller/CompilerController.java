package com.ff.onlineCompiler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ff.onlineCompiler.service.CompilerService;
import com.ff.onlineCompiler.util.Code;

@RestController
@RequestMapping("/api/compiler")
public class CompilerController {
	
	
	@Autowired
	private CompilerService compilerService;

	@PostMapping("/compile")
	public String compileAndRun(@RequestBody Code code) {
		
		return compilerService.compileAndRun(code.getCode());
		
	}
	
	@GetMapping("/test")
	public String test() {
		return "Testing done successfully";
	}
}
