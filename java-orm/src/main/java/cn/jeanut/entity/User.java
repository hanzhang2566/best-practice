package cn.jeanut.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;


/**
 * Usage: 用户表 <br/>
 * Date: 2023/5/18 13:17 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
@Data
@TableName(value = "t_user")
public class User {
    /**
     * 主键
     */
    @TableId(type = IdType.NONE)
    private Long id;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private Gender gender;

    /**
     * 逻辑删除
     */
    @TableField(value = "is_deleted")
    @TableLogic
    private boolean deleted;

    /**
     * 性别
     */
    enum Gender {
        MALE(1),

        FEMALE(2),
        ;

        @Getter
        @EnumValue
        private final int identification;

        Gender(int identification) {
            this.identification = identification;
        }
    }
}
