package hamcrest;

import model.pojo.PojoBean;
import org.hamcrest.CustomTypeSafeMatcher;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class HamcrestTest {
        @Test
        void assertWithHamcrestMatcher() {
            assertThat(10 - 5, equalTo(5));
            assertThat("xUnit is't test framework", stringContainsInOrder(asList("x", "test", "framework")));
            assertThat("Kotlin Appium Android", containsString("Appium"));
            assertThat("Vadim", notNullValue());
        }

        @Test
        void shouldEveryItem(){
            IntStream ages = IntStream.of(19,21,28,31);
            assertThat(ages.boxed().collect(toList()),everyItem(greaterThanOrEqualTo(18)));
              ClassLoader.class.getResourceAsStream("/schema_for_phone.json");
        }
        @Test
        void shouldCollections (){
            List<String> collection = asList("Артем","Яна");
            assertThat("Коллекция не содержит этого значения",
                    collection,hasItems("Артем"));
            assertThat("Коллекция не содержит этого значения",
                    collection,not(hasItems("Артем1","Яна")));
            assertThat(collection,contains("Артем","Яна"));
        }
        @Test
       void pojoBeanCustomMatcherTest(){
            PojoBean pojoBean = new PojoBean("NN",20);
            assertThat(pojoBean,is(MatcherHelper.hasAge(21)));
        }
    @Test
    void pojoBeanCustomMatcherTest2(){
        PojoBean pojoBean = new PojoBean("NA",21);
        assertThat(pojoBean,is(MatcherHelper.hasNameAndAge("NN",21)));
    }
    @Test
    void pojoBeanCustomMatcherTest3(){
        PojoBean pojoBean = new PojoBean("NA",20);
        assertThat(pojoBean,is(MatcherHelper.containAge(21)));
    }

    @Test
    void pojoBeanCustomMatcherTest4(){
        PojoBean pojoBean = new PojoBean("NA",20);
        assertThat(pojoBean,is(MatcherHelper.hasNumberWithFeatureMatcher(20)));
    }

    @Test
    void PojoBeanSouldHaveCorrectAgeWithCustomMatcher(){
        PojoBean pojoBean = new PojoBean("NA",21);
        assertThat(pojoBean, new CustomTypeSafeMatcher<PojoBean>(pojoBean.toString()){

            @Override
            protected boolean matchesSafely(PojoBean item) {
                return item.getAge() == 20;
            }
        });
    }
}

