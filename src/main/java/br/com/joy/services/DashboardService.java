package br.com.joy.services;

import br.com.joy.entities.Faithful;
import br.com.joy.entities.dtos.FaithfulDTO;
import br.com.joy.repositories.FaithfulRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
