package br.com.joy.services;

import br.com.joy.entities.Faithful;
import br.com.joy.entities.dtos.FaithfulDTO;
import br.com.joy.enums.Paraguay;
import br.com.joy.repositories.FaithfulRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class DashboardService {

    private final FaithfulRepository faithfulRepository;

    public Integer getNumberPeopleSameCountry(String country) {
        return faithfulRepository.findAllByCountry(country).size();
    }

    public List<FaithfulDTO> getPeopleSameCountry(String country) {
        return faithfulRepository.findAllByCountry(country).stream().map(FaithfulDTO::new).toList();
    }

    public Set<String> getAllCountry() {
        return faithfulRepository.findAll().stream().map(Faithful::getCountry).collect(Collectors.toSet());
    }

    public Set<String> getAllCities() {
        return faithfulRepository.findAll().stream()
                .filter(faithful -> Paraguay.getAllValues().contains(faithful.getCountry()))
                .map(Faithful::getOriginCity).collect(Collectors.toSet());
    }

    public List<FaithfulDTO> getPeopleSameCity(String city) {
        return faithfulRepository.findAllByCountryAndCity(Paraguay.PARAGUAY.getValue(), city).stream()
                .map(FaithfulDTO::new).toList();
    }

    public List<FaithfulDTO> getAllCreatedThisMonth() {
        return faithfulRepository.findAllByCreatedDate(LocalDateTime.now().minusMonths(1));
    }
}
