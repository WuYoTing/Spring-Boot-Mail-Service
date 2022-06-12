package com.example.Spring.Boot.Mail.Service.controller;

import com.example.Spring.Boot.Mail.Service.pojo.response.MessageResponse;
import com.example.Spring.Boot.Mail.Service.pojo.vo.ProgressStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mail")
public class MailController {


	@GetMapping("Test")
	public ResponseEntity<MessageResponse> testMailSerciceApi() {
		return new ResponseEntity<>(
			new MessageResponse(ProgressStatus.Success, "Test OK"),
			HttpStatus.OK);
	}
}
