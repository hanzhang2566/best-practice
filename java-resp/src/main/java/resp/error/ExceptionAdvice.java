package resp.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import resp.common.R;

/**
 * Usage: 全局异常处理类 <br/>
 * Date: 2023/5/18 14:46 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
@RestControllerAdvice
public class ExceptionAdvice {
    /**
     * {@link HttpStatusException} 错误处理
     *
     * @param e e
     * @return ResponseEntity
     */
    @ExceptionHandler(value = HttpStatusException.class)
    public ResponseEntity<R> httpStatusException(HttpStatusException e) {
        e.printStackTrace();
        return new ResponseEntity<>(e.getHttpStatus());
    }

    /**
     * {@link AppNonRuntimeException} 错误处理
     *
     * @param e e
     * @return ResponseEntity
     */
    @ExceptionHandler(value = AppNonRuntimeException.class)
    public ResponseEntity<R> appException(AppNonRuntimeException e) {
        e.printStackTrace();
        R error = R.error(e.getErrorCode());
        return new ResponseEntity<>(error, HttpStatus.OK);
    }

    /**
     * {@link AppRuntimeException} 错误处理
     *
     * @param e e
     * @return ResponseEntity
     */
    @ExceptionHandler(value = AppRuntimeException.class)
    public ResponseEntity<R> appRuntimeException(AppRuntimeException e) {
        e.printStackTrace();
        R error = R.error(e.getErrorCode());
        return new ResponseEntity<>(error, HttpStatus.OK);
    }

    /**
     * {@link Exception} 错误处理
     *
     * @param e e
     * @return ResponseEntity
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<R> exception(Exception e) {
        e.printStackTrace();
        R error = R.error(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
