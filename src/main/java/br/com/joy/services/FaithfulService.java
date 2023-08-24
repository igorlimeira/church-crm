package br.com.joy.services;

import br.com.joy.entities.Faithful;
import br.com.joy.entities.dtos.FaithfulDTO;
import br.com.joy.repositories.FaithfulRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FaithfulService {

    private final FaithfulRepository faithfulRepository;
    public FaithfulDTO saveFaithful(FaithfulDTO faithfulDTO) {
        return new FaithfulDTO(faithfulRepository.save(Faithful.builder()
                                                        .fullName(faithfulDTO.fullName())
                                                        .phoneNumber(faithfulDTO.phoneNumber())
                                                        .birthday(faithfulDTO.birthday())
                                                        .originCity(faithfulDTO.originCity())
                                                        .country(faithfulDTO.country())
                                                        .originNetwork(faithfulDTO.originNetwork())
                                                        .build()));
    }
}
