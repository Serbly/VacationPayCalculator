package org.example.vacationcalculator.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

public class HolidayServiceTest {
    private final HolidayService holidayService = new HolidayService();

    @Test
    @DisplayName("Должен подтверждать, что 1 января — праздник")
    void shouldReturnTrueForNewYear() {
        assertTrue(holidayService.isHoliday(MonthDay.of(1, 1)));
    }

    @Test
    @DisplayName("Должен подтверждать, что 20 июня — не праздник")
    void shouldReturnFalseForRegularDay() {
        assertFalse(holidayService.isHoliday(MonthDay.of(6, 20)));
    }

    @Test
    @DisplayName("Должен правильно считать дни, если в периоде есть праздники")
    void shouldExcludeHolidaysFromCalculation() {
        LocalDate startDate = LocalDate.of(2026, 4, 30);
        int result = holidayService.calculatePaidDays(startDate, 3);

        assertEquals(2, result);
    }
}
