package com.test.servlet.util;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class ParseUtils {

    private Logger log = Logger.getLogger(UniqueUtils.class.getName());

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Date parse(String date)
    {
        Date birthday = new Date();
        try {
            birthday = dateFormat.parse(date);
            return birthday;

        }catch (ParseException e) {
            log.error("Problem with date");

        }
        return birthday;
    }


}
