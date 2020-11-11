package org.hbrs.ooka.ws2020.uebung1.buchungssystem;

import org.hbrs.ooka.ws2020.uebung1.Hotel;
import org.hbrs.ooka.ws2020.uebung1.ext.Cache;
import org.hbrs.ooka.ws2020.uebung1.ext.Hotelsuche;
import org.hbrs.ooka.ws2020.uebung1.ext.Logging;

import java.util.ArrayList;
import java.util.List;

public class HotelRetrieval implements Hotelsuche, Cache {

    DBAccess acc;


    @Override // TODO generisch programmieren
    public Hotel[] getHotelByName(String name) {

        Logging.logAction(name);

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
        acc = new DBAccess();
        acc.openConnection();
    }
    // TODO close connection at some point
    public void closeSession() {
        acc.closeConnection();
    }

    @Override
    public void cacheResult(String key, List<Object> value) {

    }
}
