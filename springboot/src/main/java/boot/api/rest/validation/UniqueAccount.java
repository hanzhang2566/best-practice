package boot.api.rest.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * Usage: 表示一个用户是唯一的 <br/>
 * <p>
 * 唯一不仅仅是用户名，还要求手机、邮箱均不允许重复
 * Date: 2023/6/29 17:40 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
@Documented
@Retention(RUNTIME)
@Target({FIELD, METHOD, PARAMETER, TYPE})
@Constraint(validatedBy = AccountValidation.UniqueAccountValidator.class)
public @interface UniqueAccount {
    String message() default "用户名称、邮箱、手机号码均不允许与现存用户重复";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
