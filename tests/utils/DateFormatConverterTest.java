package utils;

import com.gmail.mordress.lab4.utils.DateFormatConverter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatConverterTest {

    public static void main(String[] args) {
        /*String s = "2015-12-18T20:30";
        Date date = DateFormatConverter.stringToDate(s);
        System.out.println(date);
        String seconds = "54";
        Date date1 = DateFormatConverter.stringToDate(s, seconds);
        System.out.println(date1);*/

        Date now = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy - HH:mm:ss", Locale.forLanguageTag("ru"));
        System.out.println(simpleDateFormat.format(now));
        /*Locale[] arr = Locale.getAvailableLocales();
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }*/
    }
}
