package cn.jeanut.entity.handler;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.function.Supplier;

/**
 * Usage: Table Fill 自动填充功能处理器 <br/>
 * fieldName 是 entity 的属性，而不是 sql 的字段<br/>
 * Date: 2023/5/19 16:07 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 处理 {@link TableField#fill()} 插入
     *
     * @param metaObject metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Supplier<LocalDateTime> now = LocalDateTime::now;
        strictInsertFill(metaObject, "createTime", now, LocalDateTime.class);
        strictInsertFill(metaObject, "updateTime", now, LocalDateTime.class);
    }

    /**
     * 处理 {@link TableField#fill()} 更新
     *
     * @param metaObject metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        Supplier<LocalDateTime> now = LocalDateTime::now;
        strictUpdateFill(metaObject, "updateTime", now, LocalDateTime.class);
    }
}
