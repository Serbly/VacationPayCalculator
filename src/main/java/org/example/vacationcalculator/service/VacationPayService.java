package org.example.vacationcalculator.service;

import lombok.RequiredArgsConstructor;
import org.example.vacationcalculator.dto.VacationPayRequest;
import org.example.vacationcalculator.dto.VacationPayResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class VacationPayService {
    private static final BigDecimal AVERAGE_MONTH_DAYS = BigDecimal.valueOf(29.3);
    private static final int CALCULATION_SCALE = 2;

    private final HolidayService holidayService;

    public VacationPayResponse calculateVacationPay(VacationPayRequest request) {
        BigDecimal averageSalary = request.getAverageSalary();
        int vacationPayDays = request.getVacationDays();
        LocalDate startDate = request.getStartDate();

        BigDecimal averageDailyEarnings = averageSalary
                .divide(AVERAGE_MONTH_DAYS, CALCULATION_SCALE, RoundingMode.HALF_UP);
        int paidDays = holidayService.calculatePaidDays(startDate, vacationPayDays);

        BigDecimal vacationPay = averageDailyEarnings
                .multiply(BigDecimal.valueOf(paidDays));

        return new VacationPayResponse(vacationPay);
    }
}