package br.com.joy.entities.dtos;

import lombok.Builder;

import java.util.List;

@Builder
public record ChartDataDTO(List<ChartDataResultDTO> countryResult) {
}
