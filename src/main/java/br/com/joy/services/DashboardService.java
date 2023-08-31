package br.com.joy.services;

import br.com.joy.entities.Faithful;
import br.com.joy.entities.dtos.ChartDataDTO;
import br.com.joy.entities.dtos.ChartDataResultDTO;
import br.com.joy.entities.dtos.CountryDTO;
import br.com.joy.entities.dtos.FaithfulDTO;
import br.com.joy.enums.Paraguay;
import br.com.joy.repositories.FaithfulRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class DashboardService {

    @Autowired
    private final FaithfulRepository faithfulRepository;

//    @Cacheable(cacheNames  = "chart", key = "#country")
    public ChartDataDTO getNumberPeopleSameCountry(String country) {
        List<Faithful> faithfuls = this.faithfulRepository.findAllByCountry(country);
        Map<String, Long> countryCountMap = faithfuls.stream()
                .collect(Collectors.groupingBy(Faithful::getOriginCity, Collectors.counting()));
        return new ChartDataDTO(this.processChartInfo(countryCountMap));
    }

    private List<ChartDataResultDTO> processChartInfo(Map<String, Long> countryCountMap) {
        List<ChartDataResultDTO> data = countryCountMap.entrySet().stream()
                .map(entry -> new ChartDataResultDTO(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparing(ChartDataResultDTO::userQty).reversed())
                .collect(Collectors.toList());
        return data;
    }

    public List<FaithfulDTO> getPeopleSameCountry(String country) {
        return faithfulRepository.findAllByCountry(country).stream().map(FaithfulDTO::new).toList();
    }

    public ChartDataDTO getAllCountry() {
        List<Faithful> faithfuls = this.faithfulRepository.findAll();
        Map<String, Long> countryCountMap = faithfuls.stream()
                .collect(Collectors.groupingBy(Faithful::getCountry, Collectors.counting()));
        return new ChartDataDTO(this.processChartInfo(countryCountMap));
    }

    public Set<String> getAllCities() {
        return faithfulRepository.findAll().stream()
                .filter(faithful -> Paraguay.getAllValues().contains(faithful.getCountry()))
                .map(Faithful::getOriginCity).collect(Collectors.toSet());
    }

    public List<FaithfulDTO> getPeopleSameCity(String city) {
        return faithfulRepository.findAllByCountryAndOriginCity(Paraguay.PARAGUAY.getValue(), city).stream()
                .map(FaithfulDTO::new).toList();
    }

    public List<FaithfulDTO> getAllCreatedThisMonth() {
        return faithfulRepository.findAllByCreatedDate(LocalDateTime.now().minusMonths(1));
    }



    public List<CountryDTO> countByCountry() {
        return faithfulRepository.countByCountry();
    }
}
