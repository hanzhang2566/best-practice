package boot.api.rest.validation;


import boot.api.rest.req.AccountReq;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.function.Predicate;

/**
 * Usage: 用户对象校验器 <br/>
 * <p>
 * 如，新增用户时，判断该用户对象是否允许唯一，在修改用户时，判断该用户是否存在
 * Date: 2023/6/29 17:40 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
public class AccountValidation<T extends Annotation> implements ConstraintValidator<T, AccountReq> {
    protected Predicate<AccountReq> predicate = c -> true;

    @Override
    public boolean isValid(AccountReq value, ConstraintValidatorContext context) {
        // 在JPA持久化时，默认采用Hibernate实现，插入、更新时都会调用BeanValidationEventListener进行验证
        // 而验证行为应该尽可能在外层进行，Resource中已经通过@Vaild注解触发过一次验证，这里会导致重复执行
        // 正常途径是使用分组验证避免，但@Vaild不支持分组，@Validated支持，却又是Spring的私有标签
        // 另一个途径是设置Hibernate配置文件中的javax.persistence.validation.mode参数为“none”，这个参数在Spring的yml中未提供桥接
        // 为了避免涉及到数据库操作的验证重复进行，在这里做增加此空值判断，利用Hibernate验证时验证器不是被Spring创建的特点绕开
        return predicate.test(value);
    }

    public static class UniqueAccountValidator extends AccountValidation<UniqueAccount> {
        public void initialize(UniqueAccount constraintAnnotation) {
            predicate = c -> false;
        }
    }
}
