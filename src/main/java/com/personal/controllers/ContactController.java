package com.personal.controllers;

import com.personal.dto.ContactDto;
import com.personal.mapper.ContactDtoMapper;
import com.personal.models.Contact;
import com.personal.service.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;
    private final ContactDtoMapper mapper;

    //Retrieve all contacts in the database
    @RequestMapping(method = RequestMethod.GET)
    public String home(Map<String, Object> model) {
        List<ContactDto> contactDtos = mapper.mapContactListToDto(contactService.findContacts());
        model.put("contacts", contactDtos);
        return "contacts";
    }

    //Navigating to the new contact form
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("contactDto", new ContactDto());
        return "registerContact";
    }

    //Pushing the new contact to the database
    @PostMapping("/submit")
    public String registerSubmit(@Valid @ModelAttribute ContactDto contactDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registerContact";
        } else {
            contactService.saveContact(mapper.mapAddressDtoToPojo(contactDto));
            return "redirect:/";
        }

    }

    //Navigating to the update contact form
    @GetMapping("/update/{id}")
    public String updateForm(Model model, @PathVariable Long id) {
        ContactDto contactDto = mapper.mapContactToDto(contactService.findContact(id));
        model.addAttribute("contactDto", contactDto);
        return "updateContact";
    }

    @GetMapping("/contact/{id}")
    public String detailForm(Model model, @PathVariable Long id) {
        ContactDto contact = mapper.mapContactToDto(contactService.findContact(id));
        model.addAttribute("contact", contact);
        return "contactDetail";
    }

    @PostMapping("/update")
    public String updateSubmit(@Valid @ModelAttribute ContactDto contactDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateContact";
        } else {
            contactService.updateContact(mapper.mapAddressDtoToPojo(contactDto));
            return "redirect:/";
        }

    }

    //Removing the contact
    @GetMapping("/remove/{id}")
    public String removeContact(@PathVariable Long id) {
        ContactDto contact = mapper.mapContactToDto(contactService.findContact(id));
        if (contact != null) {
            contactService.deleteContact(id);
        }
        return "redirect:/";
    }


}
