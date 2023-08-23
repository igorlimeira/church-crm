package br.com.joy.entities.dtos;

import br.com.joy.entities.Faithful;
import br.com.joy.entities.formsobjects.FaithfulForm;
import br.com.joy.enums.ESocialMedia;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record FaithfulDTO(
        Long id,
        String fullName,
        String phoneNumber,
        LocalDate birthDay,
        String originCity,
        String country,
        ESocialMedia originNetwork,
        LocalDateTime createdDate) {
    public FaithfulDTO(Faithful faithful) {
        this(faithful.getId(),
            faithful.getFullName(),
            faithful.getPhoneNumber(),
            faithful.getBirthday(),
            faithful.getOriginCity(),
            faithful.getCountry(),
            faithful.getOriginNetwork(),
            faithful.getCreatedDate());
    }
    public FaithfulDTO(FaithfulForm faithfulForm) {
        this(faithfulForm.getId(),
                faithfulForm.getFullName(),
                faithfulForm.getPhoneNumber(),
                faithfulForm.getBirthday(),
                faithfulForm.getOriginCity(),
                faithfulForm.getCountry(),
                faithfulForm.getOriginNetwork(),
                faithfulForm.getCreatedDate());
    }
}
