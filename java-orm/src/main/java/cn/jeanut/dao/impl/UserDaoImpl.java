package cn.jeanut.dao.impl;

import cn.jeanut.dao.UserDao;
import cn.jeanut.dao.mapper.UserMapper;
import cn.jeanut.entity.User;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * Usage: {@link UserDao} 实现 <br/>
 * Date: 2023/5/19 11:02 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
@Repository
public class UserDaoImpl extends ServiceImpl<UserMapper, User>
        implements UserDao {
    @Override
    public User create(User user) {
        boolean success = save(user);
        if (!success) {
            return null;
        }
        return user;
    }

    @Override
    public boolean remove(long id) {
        return removeById(id);
    }
}
