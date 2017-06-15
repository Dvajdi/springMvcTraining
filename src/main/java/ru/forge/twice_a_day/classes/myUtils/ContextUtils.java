package ru.forge.twice_a_day.classes.myUtils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Twice on 12.06.2017.
 */
public class ContextUtils {
  public static GenericXmlApplicationContext getContext(){
    GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    ctx.load("classpath:META-INF/spring/spring-data.xml");
    ctx.refresh();
    return ctx;
  }
  public static Object getService(String name){
    return getContext().getBean(name);
  }
}
