package cucumber.examples.stepdefinitions;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Допустим;
import model.User;

import java.time.LocalDate;
import java.util.List;

public class CustomTypeStepDefs {

    @Допустим("передадим в метод шага дату {localdate}")
    public void передадимВМетодШагаДату(LocalDate localDate) {
        System.out.println("Передадим в метод шага дату: " +localDate);
    }

    @Дано("у нас есть пользователи")
    public void уНасЕстьПользователи(List<User> users) {
        for (int i=0; i< users.size();i++){
            System.out.println("User #"+i+ " " + users.get(i));
        }
    }
}
