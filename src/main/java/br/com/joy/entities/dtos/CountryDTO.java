package br.com.joy.entities.dtos;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CountryDTO {
    private String country;
    private Long count;
}
