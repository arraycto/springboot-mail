package com.lin.module.mail.service;

public interface MailService {

	/**
	 * 简易邮件发送
	 * @param to
	 * @param subject
	 * @param content
	 */
	public void sendSimpleEmail(String to, String subject, String content);
	
	/**
	 * 发送 HTML 格式的邮件
	 * @param to
	 * @param subject
	 * @param content
	 */
	public void sendHTMLEmail(String to, String subject, String content);
	
	/**
	 * 带附件邮件
	 * @param to
	 * @param subject
	 * @param content
	 * @param fileName
	 * @param filePath
	 */
	public void sendAttachmentsMail(String to, String subject, String content, String fileName, String filePath);
}
