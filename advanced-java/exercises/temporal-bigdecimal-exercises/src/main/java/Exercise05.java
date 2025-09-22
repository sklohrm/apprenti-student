import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Exercise05 {

    // THE GODMOTHER
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. Your Godmother gives you $10 every other Friday throughout the year.
    // Payments start on the first Friday of the year.
    // Given a date, calculate payments expected from that date until the end of the year.
    BigDecimal calculateGiftsTilEndOfYear(LocalDate date) {
        List<LocalDate> fridays = everyOtherFriday(date.getYear());
        BigDecimal payout = new BigDecimal("0");
        for (LocalDate friday : fridays) {
            if (friday.isAfter(date)) {
                payout = payout.add(BigDecimal.valueOf(10));
            }
        }
        return payout;
    }

    // 2. Your Godmother is getting quirky. She adjusted her payment schedule.
    // She still pays every other Friday throughout the year, starting on the first Friday of the year.
    // But now, she pays a number of dollars equal to the day of the month.
    // Examples
    // Jan 31 == $31
    // Mar 1 == $1
    // July 12 == $12
    // Given a date, calculate payments expected from that date until the end of the year.
    BigDecimal calculateQuirkyGiftsTilEndOfYear(LocalDate date) {
        List<LocalDate> fridays = everyOtherFriday(date.getYear());
        BigDecimal payout = new BigDecimal("0");
        for (LocalDate friday : fridays) {
            if (friday.isAfter(date)) {
                payout = payout.add(BigDecimal.valueOf(friday.getDayOfMonth()));
            }
        }
        return payout;
    }

    /**
     * Creates a list containing every other Friday in the year that matches the year provided.
     * <p>
     * Starts counting from the first Friday.
     *
     * @param year the year which will be used to generate the list
     * @return list of every other Friday in the year
     */
    public List<LocalDate> everyOtherFriday(int year) {
        LocalDate jan1 = LocalDate.of(year, 1, 1);

        int daysToFriday = (DayOfWeek.FRIDAY.getValue() - jan1.getDayOfWeek().getValue() + 7) % 7;
        LocalDate nextFriday = jan1.plusDays(daysToFriday);

        List<LocalDate> fridays = new ArrayList<>();
        while (nextFriday.getYear() == year) {
            fridays.add(nextFriday);
            nextFriday = nextFriday.plusWeeks(2);
        }

        return fridays;
    }

}
