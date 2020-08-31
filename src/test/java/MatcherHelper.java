import model.pojo.PojoBean;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

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
                description.appendText("Actual age:" + ((PojoBean) item).getAge());
            }
        };
    }
}
