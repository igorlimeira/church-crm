package br.com.joy.entities.formsobjects;

import br.com.joy.enums.ESocialMedia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FaithfulForm {
    private Long id;
    private String fullName;
    private String phoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private String originCity;
    private String country;
    private ESocialMedia originNetwork;
    private LocalDateTime createdDate;
}
