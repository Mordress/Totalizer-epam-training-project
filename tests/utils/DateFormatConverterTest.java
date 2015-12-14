package utils;

import com.gmail.mordress.lab4.utils.DateFormatConverter;

import java.util.Date;

public class DateFormatConverterTest {

    public static void main(String[] args) {
        String s = "2015-12-18T20:30";
        Date date = DateFormatConverter.stringToDate(s);
        System.out.println(date);
    }
}
