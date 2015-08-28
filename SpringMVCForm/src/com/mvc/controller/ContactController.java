package com.mvc.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.form.Contact;
 
@Controller
@SessionAttributes
public class ContactController {
 
    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact")
                            Contact contact, BindingResult result) {
         
        System.out.println("First Name:" + contact.getFirstname() + 
                    "Last Name:" + contact.getLastname()
                    
        		);
        Contact contact1 = new Contact();
    	contact1.setFirstname(contact.getFirstname());
    	contact1.setLastname(contact.getLastname());
    	contact1.setEmail(contact.getEmail());
    	contact1.setTelephone(contact.getTelephone());
    	Configuration con=new Configuration();
    	con.configure();
    	
    	@SuppressWarnings("deprecation")
		SessionFactory sf=con.buildSessionFactory();
    	
    	Session s1=sf.openSession();
    	s1.beginTransaction();
    	s1.save(contact);
    	s1.getTransaction().commit();
    	s1.flush();
    	System.out.println("success");
    	
         
        
        
        return "redirect:contacts.html";
    }
     
    @RequestMapping("/contacts")
    public ModelAndView showContacts() {
         
        return new ModelAndView("contact", "command", new Contact());
    }
    
    public void addEmpployee()
    {
    	Contact contact = new Contact();
    	contact.setFirstname(contact.getFirstname());
    	contact.setLastname(contact.getLastname());
    	contact.setEmail(contact.getEmail());
    	contact.setTelephone(contact.getTelephone());
    	Configuration con=new Configuration();
    	con.configure();
    	
    	@SuppressWarnings("deprecation")
		SessionFactory sf=con.buildSessionFactory();
    	
    	Session s1=sf.openSession();
    	s1.beginTransaction();
    	s1.save(contact);
    	s1.getTransaction().commit();
    	s1.flush();
    	System.out.println("success");
    	
    	
    	
    	
    	
    }
    
}
