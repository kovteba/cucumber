package kovteba.date;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ListDateFormaterTest {

    private final DateFormater dateFormater = new DateFormater();


    @Given("List of date with formats:")
    public void formatListOfDates(List<DateFormat> formats) {

        formats.forEach(dateFormat -> {
            LocalDateTime formated = dateFormater.format(dateFormat.getDate(), dateFormat.getFormat());
            dateFormater.addDate(formated);
        });
    }

    @Then("Check all dates:")
    public void checkAllDates(List<String> s) {

        s.forEach(date -> Assertions.assertTrue(dateFormater.getLocalDateTimes().stream()
                                                                                .map(LocalDateTime::toString)
                                                                                .collect(Collectors.toList())
                                                                                .contains(date)));
    }

    @When("Convert {} using pattern {}")
    public void when(String date, String format) {

        LocalDateTime formated = dateFormater.format(date, format);
        dateFormater.addDate(formated);
    }

    @Then("Result {}")
    public void then(String s) {

        dateFormater.getLocalDateTimes().forEach(localDateTime -> Assertions.assertEquals(localDateTime.toString(), s));
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static final class DateFormat {

        private String date;

        private String format;

    }
}
