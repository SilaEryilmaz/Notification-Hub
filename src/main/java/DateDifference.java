import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DateDifference
{
    LocalDate date1;
    LocalDate date2;

    public DateDifference(LocalDate date1, LocalDate date2) {
        this.date1 = date1;
        this.date2 = date2;
    }

    public long findDifferenceBetweenDates(){
        long noOfDaysBetween = ChronoUnit.DAYS.between(date2, date1);


        return noOfDaysBetween;
    }
}