package org.example.vacationcalculator.service;

import org.example.vacationcalculator.dto.VacationPayRequest;
import org.example.vacationcalculator.dto.VacationPayResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VacationPayServiceTest {
    @Mock
    private HolidayService holidayService;

    @InjectMocks
    private VacationPayService vacationPayService;

    @Test
    @DisplayName("Должен корректно рассчитывать сумму: (Зарплата / 29.3) * Оплачиваемые дни")
    void calculateVacationPay_ShouldReturnCorrectAmount() {
        BigDecimal salary = BigDecimal.valueOf(29300);
        LocalDate start = LocalDate.of(2026, 10, 1);
        VacationPayRequest request = new VacationPayRequest(salary, 10, start);

        when(holidayService.calculatePaidDays(start, 10)).thenReturn(10);

        VacationPayResponse response = vacationPayService.calculateVacationPay(request);

        assertEquals(new BigDecimal("10000.00"), response.getVacationPay());
    }
}
