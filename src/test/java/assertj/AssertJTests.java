package assertj;


import model.pojo.PojoBean;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;


public class AssertJTests {

    @Test
    public void assertThatFluent() {
        List cars = Arrays.asList("Lada", "Volga", "Niva");
        assertThat(cars.get(0)).isEqualTo("Lada");
        assertThat(cars.get(1)).isNotEqualTo("NN");
        assertThat(cars)
                .hasSize(3)
                .contains("Niva")
                .doesNotContain("Lad")
                .hasSizeGreaterThanOrEqualTo(3);

//        assertThat(cars).startsWith("Volga");
        assertThat('x')
                .isNotEqualTo('X')
                .inUnicode()
                .isGreaterThanOrEqualTo('b')
                .isLowerCase();

        assertThat(Serializable.class).isInterface();
        assertThat(Predicate.class).hasAnnotation(FunctionalInterface.class);
        assertThat(PojoBean.class).hasDeclaredMethods();
    }

    @Test
    public void assertJObjectAssertsIsEqualToTest() {
        PojoBean jack = new PojoBean("Jack", 15);
        PojoBean anotherJack = new PojoBean("Jack", 15);
        assertThat(jack).isEqualTo(anotherJack);
    }

    @Test
    public void assertJObjectAssertsIsEqualToComparingFieldByFieldTest() {
        PojoBean jack = new PojoBean("Jack", 15);
        PojoBean anotherJack = new PojoBean("Jack", 15);
        assertThat(jack).isEqualToComparingFieldByField(anotherJack);
    }

    @Test
    public void assertJBoolean(){

        assertThat(true).isTrue();
        assertThat("AssertJ".isEmpty()).isFalse();
    }
    @Test
    public void assertJDifferentAssertions(){
       //Check files
        assertThat(new File("src/test/resources/user.data"))
                .exists()
                .isFile()
                .canRead()
                .canWrite();

        //Check decimals
        assertThat(5.0).isEqualTo(2.5, withPrecision(3d));

        //Check InputStream
        //  assertThat(given).hasContent(expected);

        //Check maps
        Map<String,String> ladaCars = new HashMap<>();
        ladaCars.put("ВАЗ-1119", "Девятка");
        ladaCars.put("ВАЗ-2170", "Приора");
        assertThat(ladaCars)
                .isNotEmpty()
                .containsKey("ВАЗ-1119")
                .doesNotContainKeys("ГАЗ-21","ffff")
                .contains(entry("ВАЗ-2170", "Приора"));

        PojoBean person = new PojoBean("Daniel", 20);
        assertThat(person.getAge())
                .as("%s's age", person.getName())
                .isEqualTo(100);

    }


}
