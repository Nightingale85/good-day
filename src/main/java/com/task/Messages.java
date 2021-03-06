package com.task;

import org.apache.log4j.Logger;
import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

/**
 * @author Sergiy_Solovyov
 */
public class Messages {
    private ResourceBundle bundle;
    private static final Logger log = Logger.getLogger(Messages.class);

    public Messages(String resourceBundle){
        this.bundle = ResourceBundle.getBundle(resourceBundle);
    }

    public String getMessage(String key){
        String value = bundle.getString(key);
        try {
            return new String(value.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error(e);
        }
        return value;
    }
}
