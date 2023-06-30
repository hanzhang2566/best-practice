package boot.service.impl;

import boot.Application;
import boot.api.rest.req.AccountReq;
import boot.service.ValidationService;
import org.springframework.beans.BeansException;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;

/**
 * Usage: {@link ValidationService} 实现 <br/>
 * Date: 2023/6/29 17:09 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
@Service
@Validated
public class ValidationServiceImpl implements ValidationService, ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public String createAccount(AccountReq accountReq) {
        if (ObjectUtils.isEmpty(accountReq.getName())) {
            throw new RuntimeException("姓名不能为空");
        }
        return "create account ok";
    }

    @Override
    public String updateAccount(AccountReq accountReq) {
        return "update account ok";
    }

    @Override
    public String hello(@NotNull(message = "name cannot be null") String name) {
        return null;
    }

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        final ValidationService userService = applicationContext.getBean(ValidationService.class);

        try {
            userService.hello(null);
        } catch (ConstraintViolationException ex) {
            System.out.println("方法参数非对象校验成功");
            System.out.println("错误信息：" + ex.getLocalizedMessage());
            System.out.println("---------------");
        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
