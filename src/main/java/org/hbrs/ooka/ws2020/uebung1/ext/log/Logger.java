package org.hbrs.ooka.ws2020.uebung1.ext.log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger implements Logging {

    @Override
    public void logAction(String query) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy HH:mm");

        String output = "Zugriff auf Buchungssystem über Methode getHotelByName. Suchwort: " + query;
        String timestamp = sdf.format(new Date());

        System.out.println(timestamp + " " + output);
    }
}
