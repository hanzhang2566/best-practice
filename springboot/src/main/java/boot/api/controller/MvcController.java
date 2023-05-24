package boot.api.controller;

import org.springframework.web.bind.annotation.*;
import boot.api.rest.req.UserReq;

/**
 * Usage: mvc 控制器 <br/>
 * Date: 2023/5/24 13:47 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
@RestController
@RequestMapping("/mvc")
public class MvcController {
    @GetMapping("/get")
    public String queryParam(@RequestParam("name") String name) {
        return name;
    }

    @GetMapping("/path/{name}")
    public String pathParam(@PathVariable("name") String name) {
        return name;
    }


    @PostMapping("/wrong")
    public String wrong(@RequestBody String name) {
        return name;
    }

    @PostMapping("/body")
    public UserReq body(@RequestBody UserReq req) {
        return req;
    }
}
