package kovteba.date;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class DateFormater {

    private LocalDateTime localDateTime;

    private List<LocalDateTime> localDateTimes = new ArrayList<>();

    public LocalDateTime format(String date, String format) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        this.localDateTime = LocalDateTime.parse(date, formatter);
        return this.localDateTime;
    }

    public void addDate(LocalDateTime localDateTime) {

        localDateTimes.add(localDateTime);
    }
}
