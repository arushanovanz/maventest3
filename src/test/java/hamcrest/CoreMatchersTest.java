package hamcrest;

import model.pojo.PojoBean;
import org.testng.annotations.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CoreMatchersTest {
    private String efsName = "ЕФС - единая фронтальная система";
    @Test
    void stringShouldContainsSpecCharacters() {
        assertThat(efsName, containsString("ЕФС"));
    }
    @Test
    void shouldWorkHamcrestMatcherAllof(){
        assertThat(efsName, anyOf (startsWith("ЕФС"),containsString("Троль")));
    }

    @Test
    void shouldWorkHamcrestMatcherBoth(){
        assertThat(efsName, both(startsWith("ЕФAС")).and(instanceOf(String.class)));
    }

    @Test
    void shouldWorkHamcrestMatcherNot(){
        assertThat(efsName, not(startsWith("ППРБ")));
    }

    @Test
    void shouldWorkHamcrestProperty(){
        PojoBean bean = new PojoBean ("Nadya",29);
    }


}
