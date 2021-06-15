package com.vdab.rdcar.controllers;

import com.vdab.rdcar.domain.Contact;
import com.vdab.rdcar.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping(value = "/contact")
    public String showContactPage(){
        return "contact";
    }

    @PostMapping(value = "/contact/send")
    public String sendContactEmail(@ModelAttribute Contact contact){
        contactService.sendEmail(contact);
        return "redirect:/";
    }
}
