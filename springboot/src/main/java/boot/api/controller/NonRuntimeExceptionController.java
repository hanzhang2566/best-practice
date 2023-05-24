package boot.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import boot.enums.ErrorCode;
import boot.api.R;
import boot.exception.AppNonRuntimeException;

/**
 * Usage: 非运行时异常 <br/>
 * Date: 2023/5/18 17:43 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
@RestController
@RequestMapping("non_runtime")
public class NonRuntimeExceptionController {
    @GetMapping("user")
    public ResponseEntity<R> user() throws AppNonRuntimeException {
        throw new AppNonRuntimeException(ErrorCode.DB_CONNECTION_ERROR);
    }
}
