package org.hbrs.ooka.ws2020.uebung1.ext.cache;

import org.hbrs.ooka.ws2020.uebung1.Hotel;

import java.util.HashMap;
import java.util.List;

public class Cache implements Caching {

    HashMap<String, List<Hotel>> cache = new HashMap();

    @Override
    public void cacheResult(String key, List<Hotel> value) {
        cache.put(key,value);
    }

    public List<Hotel> getEntry(String key){
        return cache.get(key);
    }
}
