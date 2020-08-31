package assertj;


import model.pojo.PojoBean;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;


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

         List a = new ArrayList();
        assertThat(Objects.isNull(null)).isTrue();
        assertThat("AssertJ".isEmpty()).isFalse();
    }
}
