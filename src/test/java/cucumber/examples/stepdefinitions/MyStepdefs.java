package cucumber.examples.stepdefinitions;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class MyStepdefs {
    public static BigDecimal cash = new BigDecimal(120_000);

    @Дано("на счете пользователя имеется {int} рублей")
    public void наСчетеПользователяИмеетсяРублей(int arg0) {
        assertEquals(0,cash.compareTo(new BigDecimal(arg0)));
    }

    @Когда("пользователь снимает со счета {int} рублей")
    public void пользовательСнимаетСоСчетаРублей(int arg0) {
        cash = cash.subtract(new BigDecimal(arg0));
    }

    @Тогда("на счете пользовалеля имеется {int} рублей")
    public void наСчетеПользовалеляИмеетсяРублей(int arg0) {

    }
}
