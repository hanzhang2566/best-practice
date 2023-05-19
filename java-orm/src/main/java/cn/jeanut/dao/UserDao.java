package cn.jeanut.dao;

import cn.jeanut.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * Usage: {@link User} Dao 接口 <br/>
 * Date: 2023/5/19 11:02 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
public interface UserDao extends IService<User> {
    /**
     * 创建备忘录，返回创建结果
     *
     * @param user memo
     * @return memo or null
     */
    User create(User user);

    /**
     * 根据主键 id，删除备忘录
     *
     * @param id 主键
     * @return boolean
     */
    boolean remove(long id);
}
