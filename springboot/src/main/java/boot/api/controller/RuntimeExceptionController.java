package boot.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import boot.enums.ErrorCode;
import boot.api.R;
import boot.exception.AppRuntimeException;

/**
 * Usage: 运行时异常 <br/>
 * Date: 2023/5/18 17:29 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
@RestController
@RequestMapping("runtime")
public class RuntimeExceptionController {
    @GetMapping("user")
    public ResponseEntity<R> user() {
        throw new AppRuntimeException(ErrorCode.USER_NOT_EXIST);
    }

    @GetMapping("by_zero")
    public ResponseEntity<R> byZero() {
        int ret = 10 / 0;
        return new ResponseEntity<>(R.ok(ret), HttpStatus.OK);
    }
}
