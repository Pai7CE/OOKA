package org.hbrs.ooka.ws2020.uebung1.buchungssystem;

import org.hbrs.ooka.ws2020.uebung1.Hotel;
import org.hbrs.ooka.ws2020.uebung1.ext.hotelsuche.HotelSuche;

import java.util.ArrayList;
import java.util.List;

public class HotelRetrievalExtended implements HotelSuche {

    DBAccess acc = new DBAccess();


    @Override // TODO generisch programmieren
    public Hotel[] getHotelByName(String name) {

        acc.getObjects(DBAccess.HOTEL, name);
        List<String> search = acc.getObjects(DBAccess.HOTEL, name);

        ArrayList<Hotel> results = new ArrayList<>();

        for (int i = 0; i < search.size(); i = i + 3) {
            results.add(new Hotel(search.get(i+1), search.get(i+2)));
        }

        return results.toArray(Hotel[]::new);
    }

    @Override
    public void openSession() {
        acc.openConnection();
    }
    // TODO close connection at some point
    public void closeSession() {
        acc.closeConnection();
    }

}
