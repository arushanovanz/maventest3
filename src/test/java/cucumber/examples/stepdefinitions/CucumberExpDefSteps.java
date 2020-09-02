package cucumber.examples.stepdefinitions;

import io.cucumber.java.en.Given;

public class CucumberExpDefSteps {
    @Given("передадим в метод шага целое число {int}")
    public void передадимВМетодШагаЦелоеЧисло(int arg0) {
        System.out.println("Выводим " + arg0);
    }

    @Given("передадим в метод шага дробное число {double}")
    public void передадимВМетодШагаДробноеЧисло(Double double1) {
        System.out.println("Выводим " + double1);
    }

    @Given("передадим в метод шага {string}")
    public void передадимВМетодШага(String string) {
        System.out.println("Выводим текст " + string);
    }

    @Given("Given передадим в метод шага {word}")
    public void givenПередадимВМетодШага(String arg0) {
        System.out.println("Выводим слово  " + arg0);
    }
}
