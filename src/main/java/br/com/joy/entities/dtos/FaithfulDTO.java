package br.com.joy.entities.dtos;

import br.com.joy.enums.ESocialMedia;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public record FaithfulDTO(
        Long id,
        String fullName,
        String phoneNumber,
        LocalDate birthDay,
        String originCity,
        String country,
        ESocialMedia originNetwork,
        LocalDateTime createdDate
) {
}
