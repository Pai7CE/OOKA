package org.hbrs.ooka.ws2020.uebung1.buchungssystem;

import org.hbrs.ooka.ws2020.uebung1.Hotel;
import org.hbrs.ooka.ws2020.uebung1.ext.Hotelsuche;

import java.util.List;

public class HotelRetrieval implements Hotelsuche {

    DBAccess acc;

//    public static void main(String[] args) {
//        HotelRetrieval hr = new HotelRetrieval();
//        hr.openSession();
//        System.out.println(hr.getHotelByName("Berg Hotel")[0].getName());
//        System.out.println(hr.getHotelByName("Berg Hotel")[0].getLocation());
//    }

    @Override // TODO generisch programmieren
    public Hotel[] getHotelByName(String name) {

        acc.getObjects(DBAccess.HOTEL, name);
        List<String> search = acc.getObjects(DBAccess.HOTEL, name);

        // Add to array
        Hotel[] results = new Hotel[1];
        results[0] = new Hotel(search.get(1), search.get(2));

        return results;
    }

    @Override
    public void openSession() {
        acc = new DBAccess();
        acc.openConnection();
    }
    // TODO close connection at some point
    public void closeSession() {
        acc.closeConnection();
    }

}
