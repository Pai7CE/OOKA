package org.hbrs.ooka.ws2020.uebung1.ext.hotelsuche;

import org.hbrs.ooka.ws2020.uebung1.Hotel;
import org.hbrs.ooka.ws2020.uebung1.buchungssystem.HotelRetrieval;
import org.hbrs.ooka.ws2020.uebung1.buchungssystem.HotelRetrievalExtended;
import org.hbrs.ooka.ws2020.uebung1.ext.cache.CachePort;
import org.hbrs.ooka.ws2020.uebung1.ext.cache.Caching;
import org.hbrs.ooka.ws2020.uebung1.ext.log.Logger;
import org.hbrs.ooka.ws2020.uebung1.ext.log.Logging;
import org.reflections.Reflections;

import java.util.*;
import java.util.regex.Pattern;

public class HotelSuchePort implements HotelSuche {

    HotelSuche hotelSuche = new HotelRetrieval();
    Logging logger = new Logger();
    Caching cachePort = new CachePort();

    public HotelSuchePort() {
        System.out.println("Choose implementation of search (by typing in the according number): ");
        Reflections reflections = new Reflections("org.hbrs.ooka.ws2020.uebung1.buchungssystem");
        Set<Class<? extends HotelSuche>> classes = reflections.getSubTypesOf(HotelSuche.class);
        ArrayList<String> listOfImplementations = new ArrayList<>();
        classes.forEach(aClass -> {
            listOfImplementations.add(aClass.getName().split("\\.")[aClass.getName().split("\\.").length - 1]);
        });

        int i = 0;
        for (String implementation : listOfImplementations
        ) {
            System.out.println(i + " - " + implementation);
            i++;
        }

        Scanner scanner = new Scanner(System.in);

        boolean validInput = false;

        System.out.println("Choose your preferred class: ");

        while (!validInput) {
            String userInput = scanner.nextLine();
            userInput = userInput.replaceAll("\\s", ""); // replacing all the whitespaces
            if (Pattern.matches("[0-9]+", userInput)) {
                if (Integer.parseInt(userInput) < listOfImplementations.size()) {
                    switch (listOfImplementations.get(Integer.parseInt(userInput))) {
                        case "HotelRetrieval":
                            System.out.println("Selection: HotelRetrieval");
                            hotelSuche = new HotelRetrieval();
                            validInput = true;
                            break;
                        case "HotelRetrievalExtended":
                            System.out.println("Selection:  HotelRetrievalExtended");
                            hotelSuche = new HotelRetrievalExtended();
                            validInput = true;
                            break;
                        default:
                            System.out.println("Invalid input!");
                            break;
                    }
                } else {
                    System.out.println("Make sure to only use numbers!");
                }
            }
        }
    }

    @Override
    public Hotel[] getHotelByName(String name) {
        // logging
        logger.logAction(name);

        if(cachePort.getEntry(name) != null){
            System.out.println("used cache");
            return cachePort.getEntry(name).toArray(Hotel[]::new);
        }
        // Caching results
        List<Hotel> results = Arrays.asList(hotelSuche.getHotelByName(name));
        cachePort.cacheResult(name, results);


        return hotelSuche.getHotelByName(name);
    }

    @Override
    public void openSession() {
        hotelSuche.openSession();
    }

    public void closeSession() {
        hotelSuche.closeSession();
    }
}
