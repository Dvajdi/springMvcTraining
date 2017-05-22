package ru.forge.twice_a_day.classes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.forge.twice_a_day.classes.models.contact.Contact;
import ru.forge.twice_a_day.classes.models.contact.ContactService;

import java.util.List;

@RequestMapping("/contacts")
@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model uiModel){
        List<Contact> contacts = contactService.findAllContacts();
        uiModel.addAttribute("contacts",contacts);
        return "contacts/list";
    }
}
