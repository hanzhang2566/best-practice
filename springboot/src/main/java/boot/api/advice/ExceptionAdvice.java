package boot.api.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import boot.enums.ErrorCode;
import boot.exception.AppNonRuntimeException;
import boot.exception.AppRuntimeException;
import boot.api.R;

import java.util.stream.Collectors;

/**
 * Usage: 全局异常处理类 <br/>
 * Date: 2023/5/18 14:46 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
@RestControllerAdvice
public class ExceptionAdvice {
    /**
     * {@link AppNonRuntimeException} 错误处理
     *
     * @param e e
     * @return ResponseEntity
     */
    @ExceptionHandler(value = AppNonRuntimeException.class)
    public ResponseEntity<R> onAppNonRuntimeException(AppNonRuntimeException e) {
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
    public ResponseEntity<R> onAppRuntimeException(AppRuntimeException e) {
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
    public ResponseEntity<R> onException(Exception e) {
        R error = R.error(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.OK);
    }

    /**
     * {@link HttpRequestMethodNotSupportedException} 错误处理
     *
     * @return ResponseEntity
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<R> onHttpRequestMethodNotSupportedException() {
        return new ResponseEntity<>(R.error(ErrorCode.METHOD_NOT_ALLOWED), HttpStatus.OK);
    }

    /**
     * {@link MethodArgumentNotValidException} 错误处理
     *
     * @param e e
     * @return ResponseEntity
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<R> onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors().stream().map(objectError -> {
            if (objectError instanceof FieldError) {
                FieldError fieldError = (FieldError) objectError;
                String field = fieldError.getField();
                String defaultMessage = objectError.getDefaultMessage();
                return field + ":" + defaultMessage;
            } else {
                String objectName = objectError.getObjectName();
                String defaultMessage = objectError.getDefaultMessage();
                return objectName + ":" + defaultMessage;
            }
        }).collect(Collectors.joining(";"));
        return new ResponseEntity<>(R.error(message), HttpStatus.OK);
    }

    /**
     * {@link HttpMessageNotReadableException} 错误处理
     *
     * @return ResponseEntity
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<R> onHttpMessageNotReadableException() {
        return new ResponseEntity<>(R.error(ErrorCode.REQUEST_BODY_IS_MISSING), HttpStatus.OK);
    }
}
