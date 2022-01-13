package hello.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // class level 에 붙음
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {


}
