package br.com.joy.entities.formsobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FaithfulRegistrationCount {
    private LocalDate date;
    private Long count;

    public FaithfulRegistrationCount(LocalDateTime date, Long count) {
        this.date = date.toLocalDate();
        this.count = count;
    }
}
