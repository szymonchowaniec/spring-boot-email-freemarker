package com.javatechie.email.api.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.javatechie.email.api.dto.MailRequest;
import com.javatechie.email.api.dto.MailResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private Configuration config;
	
	public MailResponse sendEmail(MailRequest request, Map<String, Object> model) {
		MailResponse response = new MailResponse();
		MimeMessage message = sender.createMimeMessage();
		try {
			// set mediaType
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			// add attachment
			helper.addAttachment("logo.png", new ClassPathResource("logo.png"));

			Template t = config.getTemplate("email-template.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t,model);

			helper.setTo("szymonchowaniec@gmail.com");
			helper.setText(html, true);
			helper.setSubject("JavaTechie Notification");
			helper.setFrom("120wspolnota@gmail.com");
			sender.send(message);

			response.setMessage("mail send to : " + request.getTo());
			response.setStatus(Boolean.TRUE);

		} catch (MessagingException | IOException | TemplateException e) {
			response.setMessage("Mail Sending failure : "+e.getMessage());
			response.setStatus(Boolean.FALSE);
		}

		return response;
	}

	@Scheduled(cron = "0 40 13 * * 3")
	public MailResponse sendEmail( ) {
		MailResponse response = new MailResponse();
		MimeMessage message = sender.createMimeMessage();

		Map<String, String> model = new HashMap<>();

		model.put("to","szymonchowaniec@gmail.com");
		model.put("from","szymonchowaniec@gmail.com");
		model.put("subject","JavaTechie Notification");
		model.put("name","Szymon Chowaniec");
		model.put("Name", "Szymon Chowaniec");
		model.put("location", "Bangalore,India");

		try {
			// set mediaType
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			// add attachment
			helper.addAttachment("logo.png", new ClassPathResource("logo.png"));

			Template t = config.getTemplate("email-template.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t,model);

			helper.setTo("szymonchowaniec@gmail.com");
			helper.setText(html, true);
			helper.setSubject("JavaTechie Notification");
			helper.setFrom("120wspolnota@gmail.com");
			sender.send(message);

			response.setMessage("mail send to : " + model.get("to"));
			response.setStatus(Boolean.TRUE);

		} catch (MessagingException | IOException | TemplateException e) {
			response.setMessage("Mail Sending failure : "+e.getMessage());
			response.setStatus(Boolean.FALSE);
		}

		return response;
	}
	

}
