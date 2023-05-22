package resp.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import resp.resp.R;

/**
 * Usage: 演示 http 正确状态码 <br/>
 * Date: 2023/5/18 17:31 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
@RestController
@RequestMapping("200")
public class HttpStatusOkController {
    @GetMapping("city")
    public R name() {
        return R.ok("shanghai");
    }

    @GetMapping("user")
    public R user() {
        User user = new User();
        user.name = "hanzhang";
        return R.ok(user);
    }

    @Data
    private static class User {
        private String name;
    }
}
