package org.hbrs.ooka.ws2020.uebung1.ext.cache;

import org.hbrs.ooka.ws2020.uebung1.Hotel;

import java.util.List;

public class CachePort implements Caching {

    Cache cache = new Cache();

    @Override
    public void cacheResult(String key, List<Hotel> value) {
        if(cache != null){
            cache.cacheResult(key,value);
        }
    }

    @Override
    public List<Hotel> getEntry(String key) {
        if(cache != null){
            return cache.getEntry(key);
        }
        return null;
    }
}
