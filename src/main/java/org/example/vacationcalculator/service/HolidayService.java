package org.example.vacationcalculator.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.HashSet;
import java.util.Set;

@Service
public class HolidayService {

    private static final Set<MonthDay> HOLIDAYS = new HashSet<>();

    static {
        for (int day = 1; day <= 8; day++) {
            HOLIDAYS.add(MonthDay.of(1, day));
        }

        HOLIDAYS.add(MonthDay.of(2, 23));
        HOLIDAYS.add(MonthDay.of(3, 8));
        HOLIDAYS.add(MonthDay.of(5, 1));
        HOLIDAYS.add(MonthDay.of(5, 9));
        HOLIDAYS.add(MonthDay.of(6, 12));
        HOLIDAYS.add(MonthDay.of(11, 4));
    }

    public boolean isHoliday(MonthDay date) {
        return HOLIDAYS.contains(date);
    }

    public int calculatePaidDays(LocalDate startDate, int vacationPayDays) {
        int paidDays = 0;
        LocalDate currentDate = startDate;

        for (int i = 0; i < vacationPayDays; i++) {
            if (!isHoliday(MonthDay.from(currentDate))) {
                paidDays++;
            }
            currentDate = currentDate.plusDays(1);
        }

        return paidDays;
    }
}
