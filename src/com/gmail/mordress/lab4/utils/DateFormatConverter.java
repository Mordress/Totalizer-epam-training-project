package com.gmail.mordress.lab4.utils;

import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatConverter {

    private static Logger logger = Logger.getLogger(DateFormatConverter.class);

    public static Date stringToDate(final String input) {
        try {
            if (input != null && !input.isEmpty()) {
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                Date date = formatter.parse(input);
                return date;
            }
        } catch (ParseException e) {
            logger.debug("Can not parse datestring - " + input);
        }
        return null;
    }

}
