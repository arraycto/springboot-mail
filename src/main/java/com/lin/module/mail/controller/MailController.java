package com.lin.module.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lin.common.utils.R;
import com.lin.module.mail.service.MailService;

@RestController
@RequestMapping("/mail")
public class MailController {

	@Autowired
	private MailService mailService;
	
	@RequestMapping("send")
	public R sendMail() {
		String to = "1632284989@qq.com";
		String subject = "【实名认证助手意见反馈邮件】";
		String content = "测试邮件内容";
		mailService.sendSimpleEmail(to, subject, content);
		return R.ok();
	}
}
