package boot;

import boot.service.ValidationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.validation.ConstraintViolationException;

/**
 * Usage: 启动类 <br/>
 * Date: 2023/5/18 12:07 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
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

}
