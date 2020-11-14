package org.hbrs.ooka.ws2020.uebung1.ext.hotelsuche;

import org.hbrs.ooka.ws2020.uebung1.Hotel;

public interface HotelSuche {

    Hotel[] getHotelByName(String name);

    void openSession();

    void closeSession();
}
