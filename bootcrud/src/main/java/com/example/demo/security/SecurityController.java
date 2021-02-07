package com.example.demo.security;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//jwt.io 에서 검증가능
@RestController
@RequestMapping("/security")
public class SecurityController {
	@Autowired
	private SecurityService securityService;
	
	// get Method에 /security/create/token?subject={id} 입력 시 token key 반환
	@GetMapping("/create/token")
	public Map<String, Object> createToken(@RequestParam(value = "subject") String subject) {
		String token = securityService.createToken(subject, (2*1000*60));
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("result",  token);
		return map;
	}
	
	@GetMapping("/get/subject")
	public Map<String, Object> getSubject(@RequestParam(value = "token") String token) {
		String subject = securityService.getSubject(token);
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("result",  subject);
		return map;
	}
}
