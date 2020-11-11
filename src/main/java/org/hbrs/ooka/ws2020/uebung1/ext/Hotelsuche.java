package org.hbrs.ooka.ws2020.uebung1.ext;

import org.hbrs.ooka.ws2020.uebung1.Hotel;

public interface Hotelsuche {

    Hotel[] getHotelByName(String name);

    void openSession();
}
