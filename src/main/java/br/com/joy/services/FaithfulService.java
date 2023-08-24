package br.com.joy.services;

import br.com.joy.entities.Faithful;
import br.com.joy.entities.dtos.FaithfulDTO;
import br.com.joy.entities.formsobjects.FaithfulRegistrationCount;
import br.com.joy.repositories.FaithfulRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FaithfulService {

    private final FaithfulRepository faithfulRepository;
    public FaithfulDTO saveFaithfull(FaithfulDTO faithfulDTO) {
        Faithful faithful = new Faithful();

        faithful.setFullName(faithfulDTO.fullName());
        faithful.setPhoneNumber(faithfulDTO.phoneNumber());
        faithful.setBirthday(faithfulDTO.birthDay());
        faithful.setOriginCity(faithfulDTO.originCity());
        faithful.setCountry(faithfulDTO.country());
        faithful.setOriginNetwork(faithfulDTO.originNetwork());
        faithful = faithfulRepository.save(faithful);

        return new FaithfulDTO(faithful.getId(),
                faithful.getFullName(),
                faithful.getPhoneNumber(),
                faithful.getBirthday(),
                faithful.getOriginCity(),
                faithful.getCountry(),
                faithful.getOriginNetwork(),
                faithful.getCreatedDate());
    }

    public List<FaithfulRegistrationCount> getLast30DaysRegistrations() {
        List<FaithfulRegistrationCount> result = faithfulRepository.findLast30DaysRegistrations();
        return result;
    }
}
