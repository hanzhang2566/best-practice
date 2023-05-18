package resp.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import resp.common.ErrorCode;

/**
 * Usage: http 异常状态码 <br/>
 * Date: 2023/5/18 15:03 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
public class HttpStatusException extends RuntimeException {
    @Getter
    private final HttpStatus httpStatus;

    public HttpStatusException(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
