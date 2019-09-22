package com.onlineshop.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlineshop.model.MailForDelivery;
import com.onlineshop.service.MailForDeliveryService;

@Controller
@RequestMapping("/mail")
public class MailForDeliveryController {

	@Autowired
	private MailForDeliveryService mailForDeliveryService;
	
	@RequestMapping(value = "/sendMail",method = RequestMethod.POST)
	public String addMail(@ModelAttribute("mail") MailForDelivery mail) {
		mail.setDate(new Date());
		mailForDeliveryService.addMail(mail);
		return("redirect:/");
	}
	
	@RequestMapping("/showMails/{page}")
	public String showMails(Model model,
			@PathVariable("page") Integer page) {
		Page <MailForDelivery> pageMail = mailForDeliveryService.showAllMails(page);
		List<MailForDelivery> listMails = new ArrayList<>();
		
		for(MailForDelivery mails : pageMail) {
			listMails.add(mails);
		}
		
		int currentPageNumber=pageMail.getNumber()+1;
		int beginIndex=Math.max(1, currentPageNumber-5);
		int endIndex=Math.min(beginIndex+10, pageMail.getTotalPages());
		
		
		model.addAttribute("mails", listMails);
		
		model.addAttribute("totalPages",pageMail.getTotalPages());
		model.addAttribute("currentPageNumber",currentPageNumber);
		model.addAttribute("beginIndex",beginIndex);
		model.addAttribute("endIndex",endIndex);
		model.addAttribute("title", "E-MAILs для рассылки");
		return"Mails";
	}
	
}















