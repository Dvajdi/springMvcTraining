package ru.forge.twice_a_day.classes.models;

import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import java.io.UnsupportedEncodingException;

/**
 * Created by twice on 26.05.17.
 */
public class UrlUtil {
    public static String encodeUrlPathSegment(String pathSegment,HttpServletRequest httpServletRequest){
        String enc = httpServletRequest.getCharacterEncoding();
        if(enc == null){
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try{
            pathSegment= UriUtils.encodePathSegment(pathSegment,enc);
        }catch(UnsupportedEncodingException uee){}
        return pathSegment;
    }
}
