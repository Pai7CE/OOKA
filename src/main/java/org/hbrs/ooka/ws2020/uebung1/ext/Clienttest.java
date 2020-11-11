package org.hbrs.ooka.ws2020.uebung1.ext;

import org.hbrs.ooka.ws2020.uebung1.Hotel;
import org.hbrs.ooka.ws2020.uebung1.buchungssystem.HotelRetrieval;

public class Clienttest {

    public static void main(String[] args) {
        HotelRetrieval hr = new HotelRetrieval();
        hr.openSession();
        Hotel[] hotels = hr.getHotelByName("");
        // TODO remove testing
        for (int i = 0; i < hotels.length; i++) {
            System.out.println(hotels[i].getName() + "," + hotels[i].getLocation());
        }
        hr.closeSession();
    }
}
