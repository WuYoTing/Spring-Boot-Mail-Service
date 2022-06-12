package com.example.Spring.Boot.Mail.Service.pojo.response;

import com.example.Spring.Boot.Mail.Service.pojo.vo.ProgressStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MessageResponse {
	private ProgressStatus progressStatus;
	private String message;
}
