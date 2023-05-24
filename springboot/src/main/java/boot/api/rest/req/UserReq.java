package boot.api.rest.req;

import lombok.Data;

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
    @NotNull
    private String username;
}
