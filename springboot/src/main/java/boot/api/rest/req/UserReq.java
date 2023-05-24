package boot.api.rest.req;

import boot.api.rest.group.EmailGroup;
import boot.api.rest.group.LoginGroup;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Usage: 用户 req <br/>
 * Date: 2023/5/24 13:08 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
@Data
public class UserReq {
    /**
     * 用户名<br>
     * username != null
     */
    @NotNull(groups = {LoginGroup.class})
    @NotEmpty(groups = {LoginGroup.class})
    private String username;

    /**
     * 密码
     */
    @NotNull(groups = {LoginGroup.class})
    @NotEmpty(groups = {LoginGroup.class})
    private String password;

    /**
     * 邮箱
     */
    @Email(groups = {EmailGroup.class})
    @NotEmpty(groups = {EmailGroup.class})
    private String email;
}
