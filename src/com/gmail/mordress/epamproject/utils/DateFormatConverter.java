package com.gmail.mordress.epamproject.utils;

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

    public static Date DateFromUI(Date date, Integer hours, Integer mins, Integer seconds) {
        return new Date(date.getTime() + seconds * 1000 + mins * 60_000 + hours * 3_600_000);
    }

    public static String dateToString(final Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return simpleDateFormat.format(date);
    }

}
