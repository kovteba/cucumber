package kovteba.date;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Data;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;

public class SingleDateFormaterTest {

    private DateFormater dateFormater;


    @Given("Create formater")
    public void createFormater() {
        dateFormater = new DateFormater();
    }

    @When("Convert {} using format {}")
    public void format(String date, String format) {

        dateFormater.format(date, format);
    }

    @Then("should be {}")
    public void checkResult(String localDateTime) {

        LocalDateTime formatedDate = dateFormater.getLocalDateTime();

        Assertions.assertEquals(formatedDate.toString(), localDateTime);
    }
}
