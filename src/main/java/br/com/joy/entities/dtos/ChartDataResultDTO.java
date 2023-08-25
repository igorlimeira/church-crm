package br.com.joy.entities.dtos;

import lombok.Builder;

@Builder
public record ChartDataResultDTO(String name, Long userQty) {
}
