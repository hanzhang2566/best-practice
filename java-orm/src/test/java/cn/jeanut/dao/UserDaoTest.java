package cn.jeanut.dao;

import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * Usage: {@link UserDao} 测试 <br/>
 * Date: 2023/5/19 15:35 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
@SpringBootTest
public class UserDaoTest {
    @Resource
    private UserDao userDao;
}
