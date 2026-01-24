package org.example.vacationcalculator.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class VacationPayRequest {
    @NotNull(message = "Средняя зарплата должна быть указана")
    @Positive(message = "Зарплата должна быть больше нуля")
    private BigDecimal averageSalary;

    @Min(value = 1, message = "Количество дней отпуска должно быть не менее 1")
    private Integer vacationDays;

    @NotNull(message = "Дата ухода в отпуск должна быть указана")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;
}