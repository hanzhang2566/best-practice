package cn.jeanut;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Usage: 启动类 <br/>
 * Date: 2023/5/19 18:01 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.jeanut.dao.mapper")
public class OrmApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrmApplication.class, args);
    }
}
