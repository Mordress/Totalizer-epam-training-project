package utils;

import com.gmail.mordress.lab4.utils.DateFormatConverter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatConverterTest {

    public static void main(String[] args) {
        String s = "2015-12-18T20:30";
        Date date = DateFormatConverter.stringToDate(s);
        System.out.println(date);
        String seconds = "54";
        Date date1 = DateFormatConverter.stringToDate(s, seconds);
        System.out.println(date1);
    }
}
