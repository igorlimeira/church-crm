package br.com.joy.entities.dtos;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record ChartDataResultDTO(String name, Long userQty) implements Serializable {
}
