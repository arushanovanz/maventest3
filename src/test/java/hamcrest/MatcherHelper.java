package hamcrest;

import model.pojo.PojoBean;
import org.hamcrest.*;

import static org.hamcrest.Matchers.equalTo;

public class MatcherHelper {
    public static Matcher<PojoBean> hasAge(final int age) {
        return new BaseMatcher<PojoBean>() {
            @Override
            public boolean matches(final Object item) {
                final PojoBean pojoBean = (PojoBean) item;
                return age == pojoBean.getAge();
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Age is not correct. Should return").appendValue(age);

            }

            @Override
            public void describeMismatch(Object item, Description description) {
                description.appendText(" Actual age: " + ((PojoBean) item).getAge());
            }
        };
    }

    public static Matcher<PojoBean> hasNameAndAge(final String name, final int age) {
        return new TypeSafeMatcher<PojoBean>() {


            @Override
            public void describeTo(Description description) {
                description.appendText("should return name = ").appendValue(name).appendValue(" and age:").appendValue(age);

            }

            @Override
            public void describeMismatchSafely(final PojoBean item, Description mismatchDescription) {
                mismatchDescription.appendText(
                        " was name= " + item.getName()
                                + " and was age= " + item.getAge());
            }

            @Override
            public boolean matchesSafely(final PojoBean item) {
                return name.equals(item.getName()) && age == item.getAge();
            }
        };
    }

    public static Matcher<PojoBean> containAge(final int age) {
        return new TypeSafeDiagnosingMatcher<PojoBean>() {
            @Override
            protected boolean matchesSafely(PojoBean item, Description mismatchDescription) {
                mismatchDescription.appendText(" was ").appendValue(item.getAge());
                return age == item.getAge();
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Age should be ").appendValue(age);

            }
        };
    }

    public static Matcher <PojoBean> hasNumberWithFeatureMatcher(final int age) {
        return new FeatureMatcher<PojoBean, Integer>(equalTo(age), "age", "age is not correct.") {

            @Override
            protected Integer featureValueOf(final PojoBean pojoBean) {
                return pojoBean.getAge();
            }
        };
    }
}