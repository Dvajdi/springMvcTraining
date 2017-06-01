package ru.forge.twice_a_day.classes.controllers;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.forge.twice_a_day.classes.models.Message;
import ru.forge.twice_a_day.classes.models.UrlUtil;
import ru.forge.twice_a_day.classes.models.contact.Contact;
import ru.forge.twice_a_day.classes.models.contact.ContactGrid;
import ru.forge.twice_a_day.classes.models.contact.ContactService;

import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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

    @RequestMapping(value="/{id}",params="form",method = RequestMethod.POST)
    public String update(@Valid Contact contact, BindingResult bindingResult,
                         Model uiModel, HttpServletRequest httpServletRequest,
                         RedirectAttributes redirectAttributes, Locale locale){

        if(bindingResult.hasErrors()){
            uiModel.addAttribute(
                    "message",
                    new Message(
                            "error",
                            messageSource.getMessage(
                                    "contact_save_fail",
                                    new Object[]{},
                                    locale)
                    )
            );

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
                                new Object[]{},
                                locale
                                )
                )
        );
        contactService.save(contact);
        return "redirect:/contacts/"+ UrlUtil.encodeUrlPathSegment(contact.getId().toString(),httpServletRequest);
    }

    @RequestMapping(value = "/{id}",params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model uiModel){
        uiModel.addAttribute("contact", contactService.findById(id));
        return "contacts/update";
    }

    @RequestMapping(params = "form", method = RequestMethod.POST)
    public String create(@Valid Contact contact,BindingResult bindingResult,
                         Model uiModel, HttpServletRequest httpServletRequest,
                         RedirectAttributes redirectAttributes, Locale locale){
        if(bindingResult.hasErrors()){
            uiModel.addAttribute("message", new Message(
                    "error",
                    messageSource.getMessage("contact_save_fail",new Object[]{},locale))
            );
            uiModel.addAttribute("contact",contact);
            return "contacts/create";
        }
        uiModel.asMap().clear();
        redirectAttributes.addFlashAttribute("message",new Message(
                "success",
                messageSource.getMessage("contact_save_success",new Object[]{},locale)
        ));

        contactService.save(contact);
        return "redirect:/contacts/"+
                UrlUtil.encodeUrlPathSegment(contact.getId().toString(),httpServletRequest);

    }

    @RequestMapping(params="form",method = RequestMethod.GET)
    public String createForm(Model uiModel){
        Contact contact = new Contact();
        uiModel.addAttribute("contact", contact);
        return "contacts/create";
    }

    @ResponseBody
    @RequestMapping(value = "/listgrid", method = RequestMethod.GET, produces="application/json")
    public ContactGrid listGrid(@RequestParam(value = "page", required = false) Integer page,
                                @RequestParam(value = "rows", required = false) Integer rows,
                                @RequestParam(value = "sidx", required = false) String sortBy,
                                @RequestParam(value = "sord", required = false) String order) {

        // Process order by
        Sort sort = null;
        String orderBy = sortBy;
        if (orderBy != null && orderBy.equals("birthDateString"))
            orderBy = "birthDate";

        if (orderBy != null && order != null) {
            if (order.equals("desc")) {
                sort = new Sort(Sort.Direction.DESC, orderBy);
            } else
                sort = new Sort(Sort.Direction.ASC, orderBy);
        }

        // Constructs page request for current page
        // Note: page number for Spring Data JPA starts with 0, while jqGrid starts with 1
        PageRequest pageRequest = null;

        if (sort != null) {
            pageRequest = new PageRequest(page - 1, rows, sort);
        } else {
            pageRequest = new PageRequest(page - 1, rows);
        }

        Page<Contact> contactPage = contactService.findAllByPage(pageRequest);

        // Construct the grid data that will return as JSON data
        ContactGrid contactGrid = new ContactGrid();

        contactGrid.setCurrentPage(contactPage.getNumber() + 1);
        contactGrid.setTotalPages(contactPage.getTotalPages());
        contactGrid.setTotalRecords(contactPage.getTotalElements());

        contactGrid.setContactData(Lists.newArrayList(contactPage.iterator()));

        return contactGrid;
    }
}
