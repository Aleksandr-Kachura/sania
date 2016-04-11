package com.test.servlet.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseUtils {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Date parse(String date)
    {
        Date birthday = new Date();
        try {
            birthday = dateFormat.parse(date);
            return birthday;

        }catch (ParseException e) {

        }
        return birthday;
    }

    public Integer parseStrToInteger(String id)
    {
        Integer integer;
        try{
            integer  = Integer.parseInt(id);
        }
        catch (NumberFormatException e){
            integer = null;
        }
        return  integer;
    }

}
