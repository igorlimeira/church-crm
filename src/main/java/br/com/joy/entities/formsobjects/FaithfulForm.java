package br.com.joy.entities.formsobjects;

import br.com.joy.enums.ESocialMedia;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FaithfulForm {
    private Long id;
    private String fullName;
    private String phoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDay;
    private String originCity;
    private String country;
    private ESocialMedia originNetwork;
    private LocalDateTime createdDate;
}
