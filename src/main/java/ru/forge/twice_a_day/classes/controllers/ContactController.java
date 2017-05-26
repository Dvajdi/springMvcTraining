package ru.forge.twice_a_day.classes.controllers;

import com.sun.jndi.toolkit.url.UrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.forge.twice_a_day.classes.models.Message;
import ru.forge.twice_a_day.classes.models.contact.Contact;
import ru.forge.twice_a_day.classes.models.contact.ContactService;

import java.util.List;
import java.util.Locale;

@RequestMapping("/contacts")
@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model uiModel){
        List<Contact> contacts = contactService.findAllContacts();
        uiModel.addAttribute("contacts",contacts);
        return "contacts/list";
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model uiModel){
        Contact contact = contactService.findById(id);
        uiModel.addAttribute("contact",contact);
        return "contacts/show";
    }

    @RequestMapping(value="/id",params="form",method = RequestMethod.POST)
    public String update(Contact contact, BindingResult bindingResult,
                         Model uiModel, HttpServletRequest httpServletRequest,
                         RedirectAttributes redirectAttributes, Locale locale){
        if(bindingResult.hasErrors()){
            uiModel.addAttribute(
                    "message",
                    new Message(
                            "error",
                            messageSource.getMessage("contact_save_fail",new Object()[]{},locale)));
            uiModel.addAttribute("contact",contact);
            return "contacts/update";
        }
        uiModel.asMap().clear();
        redirectAttributes.addFlashAttribute(
                "message",
                new Message(
                        "success",
                        messageSource.getMessage(
                                "contact_save_success",
                                new Object()[]{},
                                locale
                                )
                )
        );
        contactService.save(contact);
        return "redirect:/contacts/"+ UrlUtil.encodeUrlPathSegment(contact.getId().toString(),httpServletRequest);
    }

    @RequestMapping(value = "/id",params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model uiModel){
        uiModel.addAttribute("contact", contactService.findById(id));
        return "contacts/update";
    }
}
