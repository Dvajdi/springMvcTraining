package ru.forge.twice_a_day.classes.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.forge.twice_a_day.classes.models.Message;

import java.util.Locale;

@RequestMapping("/security")
@Service
public class SecurityController {

  @Autowired
  private MessageSource messageSource;

  @RequestMapping("/loginfail")
  public String loginFail(Model uiModel,Locale locale){
    Message message= new Message(
      "error",
      messageSource.getMessage(
        "message_login_fail",
        new Object[]{},
        locale
      ));

        uiModel.addAttribute("message",message);
    return "/contacts/list";
  }
}
