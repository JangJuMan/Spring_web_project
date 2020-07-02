package com.project.omeran;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */



@Controller
public class HomeController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "index";
	}
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home_2() {
		
		return "index";
	}
	@RequestMapping(value = "/p2", method = RequestMethod.GET)
	public String home2() {
		
		return "p2";
	}
	@RequestMapping(value = "/p3", method = RequestMethod.GET)
	public String home3() {
		
		return "p3";
	}
	@RequestMapping(value = "/p4", method = RequestMethod.GET)
	public String home4() {
		
		return "p4";
	}
	@RequestMapping(value = "/p5", method = RequestMethod.GET)
	public String home5() {
		
		return "p5";
	}
	 // mailForm
	  @RequestMapping(value = "/mailForm")
	  public String mailForm() {
	   
	    return "mailForm";
	  }  
	 
	  // mailSending 코드
	  @RequestMapping(value = "/mailSending")
	  public String mailSending(HttpServletRequest request) {
	   
	    String setfrom = "21700633@handong.edu";         
	    String tomail  = request.getParameter("tomail");     // 받는 사람 이메일
	    String title   = request.getParameter("title");      // 제목
	    String content = request.getParameter("content");    // 내용
	   
	    try {
	      MimeMessage message = mailSender.createMimeMessage();
	      MimeMessageHelper messageHelper 
	                        = new MimeMessageHelper(message, true, "UTF-8");
	 
	      messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
	      messageHelper.setTo(tomail);     // 받는사람 이메일
	      messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
	      messageHelper.setText(content);  // 메일 내용
	     
	      mailSender.send(message);
	    } catch(Exception e){
	      System.out.println(e);
	    }
	   
	    return "redirect:index";
	  }

	
}