package br.com.joy.configuration;

import br.com.joy.entities.Faithful;
import br.com.joy.enums.ESocialMedia;
import br.com.joy.repositories.FaithfulRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    private FaithfulRepository faithfulRepository;
    private Random random = new Random();

    private final String[] COUNTRIES = {
            "Brazil", "Canada", "France", "Germany", "India", "Japan", "Mexico", "Russia", "South Africa", "United States", "Paraguay"
    };

    private final String[][] CITIES = {
            {"São Paulo", "Rio de Janeiro", "Salvador"},              // Brazil
            {"Toronto", "Vancouver", "Montreal"},                     // Canada
            {"Paris", "Marseille", "Lyon"},                           // France
            {"Berlin", "Hamburg", "Munich"},                          // Germany
            {"Mumbai", "Delhi", "Bangalore"},                         // India
            {"Tokyo", "Osaka", "Nagoya"},                             // Japan
            {"Mexico City", "Guadalajara", "Monterrey"},              // Mexico
            {"Moscow", "Saint Petersburg", "Novosibirsk"},            // Russia
            {"Johannesburg", "Cape Town", "Durban"},                  // South Africa
            {"New York", "Los Angeles", "Chicago"},                   // United States
            {"Asunción", "Ciudad del Este", "San Lorenzo"
                    , "Luque", "Capiatá", "Lambaré", "Fernando de la Mora"
                    , "Limpio", "Encarnación", "Mariano Roque Alonso"
                    , "Itauguá", "Villa Elisa", "Pedro Juan Caballero"
                    , "Coronel Oviedo"}                                //Paraguay
    };


    @Override
    public void run(ApplicationArguments args) {
        if (faithfulRepository.count() == 0) {
            List<Faithful> faithfuls = new ArrayList<>();
            for (int i = 0; i < 15000; i++) {
                int countryIndex = random.nextInt(COUNTRIES.length);
                String randomCountry = COUNTRIES[countryIndex];
                String randomCity = CITIES[countryIndex][random.nextInt(CITIES[countryIndex].length)];

                Faithful faithful = Faithful.builder()
                        .fullName("User " + i)
                        .phoneNumber("123-456-78" + i)
                        .birthday(LocalDate.now().minusYears(20 + random.nextInt(40)))
                        .originCity(randomCity)
                        .country(randomCountry)
                        .originNetwork(ESocialMedia.values()[random.nextInt(ESocialMedia.values().length)])
                        .build();

                faithfuls.add(faithful);
            }
            faithfulRepository.saveAll(faithfuls);
        }
    }
}
