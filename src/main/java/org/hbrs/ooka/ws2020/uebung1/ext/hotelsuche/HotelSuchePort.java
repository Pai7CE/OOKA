package org.hbrs.ooka.ws2020.uebung1.ext.hotelsuche;

import org.hbrs.ooka.ws2020.uebung1.Hotel;
import org.hbrs.ooka.ws2020.uebung1.buchungssystem.HotelRetrieval;
import org.hbrs.ooka.ws2020.uebung1.ext.cache.CachePort;
import org.hbrs.ooka.ws2020.uebung1.ext.cache.Caching;
import org.hbrs.ooka.ws2020.uebung1.ext.log.Logger;
import org.hbrs.ooka.ws2020.uebung1.ext.log.Logging;

import java.util.Arrays;
import java.util.List;

public class HotelSuchePort implements HotelSuche {

    HotelRetrieval hr = new HotelRetrieval();
    Logging logger = new Logger();
    Caching cachePort = new CachePort();

    @Override
    public Hotel[] getHotelByName(String name) {
        // logging
        logger.logAction(name);

        if(cachePort.getEntry(name) != null){
            System.out.println("used cache");
            return cachePort.getEntry(name).toArray(Hotel[]::new);
        }
        // Caching results
        List<Hotel> results = Arrays.asList(hr.getHotelByName(name));
        cachePort.cacheResult(name, results);


        return hr.getHotelByName(name);
    }

    @Override
    public void openSession() {
        hr.openSession();
    }

    public void closeSession() {
        hr.closeSession();
    }
}
