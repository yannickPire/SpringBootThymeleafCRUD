package com.personal.controllers;

import com.personal.models.Contact;
import com.personal.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class ContactController {

    private ContactService contactService;

    //Retrieve all contacts in the database
    @RequestMapping(method = RequestMethod.GET)
    public String home(Map<String, Object> model) {
        List<Contact> contacts = contactService.findEveryContact();
        model.put("contacts", contacts);
        return "home";
    }

    //Navigating to the new contact form
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "register";
    }

    //Pushing the new contact to the database
    @PostMapping("/submit")
    public String registerSubmit(@Valid @ModelAttribute Contact contact, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "submit";
        } else {
            contactService.saveContact(contact);
            return "redirect:/";
        }

    }

    //Navigating to the update contact form
    @GetMapping("/update/{id}")
    public String updateForm(Model model, @PathVariable Long id) {
        Contact contact = contactService.findSingleContact(id);
        model.addAttribute("contact", contact);
        return "update";
    }

    @PostMapping("/update")
    public String updateSubmit(@Valid @ModelAttribute Contact contact, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "update";
        } else {
            contactService.updateContact(contact);
            return "redirect:/";
        }

    }

    //Removing the contact
    @GetMapping("/remove/{id}")
    public String removeContact(@PathVariable Long id) {
        Contact contact = contactService.findSingleContact(id);
        if (contact != null) {
            contactService.removeContact(id);
        }
        return "redirect:/";
    }


}
