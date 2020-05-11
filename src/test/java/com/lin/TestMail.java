package com.lin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.lin.module.mail.service.MailService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LinMMMailApplication.class)
public class TestMail {

	@Autowired
	private MailService mailService;
	
    @Autowired
    TemplateEngine templateEngine;
	
	@Test
	public void testSimpleMail() {
		String to = "1632284989@qq.com";
		String subject = "【实名认证助手意见反馈邮件】";
		String content = "测试邮件内容";
		mailService.sendSimpleEmail(to, subject, content);
	}
	
    @Test
    public void sendHTMLTemplateMail() {
        Context context = new Context();
        context.setVariable("code", "123456");
        String emailHTMLContent = templateEngine.process("email", context);
        mailService.sendHTMLEmail("1632284989@qq.com", "测试 HTML 模版邮件", emailHTMLContent);
    }
    
    @Test
    public void sendAttachmentsMail() {

        String fileName = "图片.jpg";
        String filePath = "C:\\Users\\EDZ\\Desktop\\hello-1-2020-05-07 11_47_38.jpeg";

        mailService.sendAttachmentsMail("1632284989@qq.com", "测试带附件的邮件", "详细请查阅附件", fileName, filePath);
    }
}
