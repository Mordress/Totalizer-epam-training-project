package com.gmail.mordress.lab4.utils;

import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
            logger.error("Can not parse datestring - " + input);
        }
        return null;
    }

    public static Date stringToDate(final String input, final String seconds) {
        try {
            if ((input != null && !input.isEmpty())
                && (seconds != null && !seconds.isEmpty())){
                    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                    Long secs = Long.parseLong(seconds);
                    Date date = formatter.parse(input);
                    date.setTime(date.getTime() + secs * 1000);
                    return date;
            }
        } catch (ParseException | NumberFormatException e) {
            logger.error("Can not parse datestring - " + input + "or seconds - " + seconds);
        }
        return null;
    }

    public static String dateToString(final Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return simpleDateFormat.format(date);
    }

}
