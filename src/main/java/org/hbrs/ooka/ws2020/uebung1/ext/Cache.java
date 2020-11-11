package org.hbrs.ooka.ws2020.uebung1.ext;

import org.hbrs.ooka.ws2020.uebung1.Hotel;

import java.util.List;

public interface Cache {

    void cacheResult(String key, List<Object> value);
}
