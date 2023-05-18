package resp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import resp.error.HttpStatusException;

/**
 * Usage: 演示 http 异常状态码 <br/>
 * Date: 2023/5/18 16:58 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
@RestController
@RequestMapping("http")
public class HttpStatusErrorController {

    @GetMapping("401")
    public ResponseEntity<String> unauthorized() {
        throw new HttpStatusException(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("403")
    public ResponseEntity<String> forbidden() {
        throw new HttpStatusException(HttpStatus.FORBIDDEN);
    }
}
