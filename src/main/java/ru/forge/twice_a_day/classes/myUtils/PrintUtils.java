package ru.forge.twice_a_day.classes.myUtils;

import java.util.List;

/**
 * Created by Twice on 12.06.2017.
 */
public class PrintUtils {
  public static void listEntities(List list){
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }
}
