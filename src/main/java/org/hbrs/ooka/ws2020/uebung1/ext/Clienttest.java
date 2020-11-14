package org.hbrs.ooka.ws2020.uebung1.ext;

import org.hbrs.ooka.ws2020.uebung1.Hotel;
import org.hbrs.ooka.ws2020.uebung1.ext.hotelsuche.HotelSuche;
import org.hbrs.ooka.ws2020.uebung1.ext.hotelsuche.HotelSuchePort;

public class Clienttest {

    public static void main(String[] args) {
        HotelSuche hsPort = new HotelSuchePort();
        hsPort.openSession();
        Hotel[] hotels = hsPort.getHotelByName("");
        // TODO remove testing
        for (int i = 0; i < hotels.length; i++) {
            System.out.println(hotels[i].getName() + "," + hotels[i].getLocation());
        }
        hotels = hsPort.getHotelByName("");
        hsPort.closeSession();
    }
}
