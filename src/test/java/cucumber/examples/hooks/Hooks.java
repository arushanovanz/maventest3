package cucumber.examples.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

//использование хуков хорошо подходит для выполнения низкоуровневых задач, как - то
// - подготовка и генерация данных
// - приведение конфигурации в тестируюмое состояние (настройки системы и тп)
// - очистка от мусорных данных и возврат в изначальное состояние
// - чтение файлов
// - выполнение условий, приведение состояний и тп, - то, что непосредственно не касается  бизнес-логики проверяемой фичи\фич
public class Hooks {


    @Before
    public void prepareData() {
        System.out.println("Данные в БД сгенерированы");
    }

    @Before(order = 1000)
    public void connectToDB() {
        System.out.println("Подключние к БД установлено");
    }

    @After(order = 10)
    public void clearData() {
        System.out.println("Вовзрат системы в изначальное состояние");
    }

    @BeforeStep
    public void beforeStep() {
        System.out.println("Проверить, что параметры загрузились и не  null");
    }

    @AfterStep
    public void afterStep() {
        System.out.println("Очистка мусорных данных");
    }

    @After(order = 20)
    public void disconnectDB() {
        System.out.println("Подключение к БД прервано");
    }
}

