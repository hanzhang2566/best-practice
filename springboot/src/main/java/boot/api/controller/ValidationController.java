package boot.api.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import boot.api.rest.req.UserReq;

/**
 * Usage: 参数验证控制器 <br/>
 * Date: 2023/5/24 13:07 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
@RestController
@RequestMapping("/validation")
@Validated
public class ValidationController {
    /**
     * @return
     */
    @GetMapping("/obj_notnull")
    public boolean notnull(@RequestBody String username) {
        return true;
    }

    /**
     * @return
     */
    @GetMapping("/pojo_notnull")
    public boolean notnull(@RequestBody @Validated UserReq req) {
        return true;
    }


}
