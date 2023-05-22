package resp.error;

import lombok.Getter;
import resp.enums.ErrorCode;

/**
 * Usage: 运行时异常 <br/>
 * Date: 2023/5/18 15:03 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
public class AppRuntimeException extends RuntimeException {
    @Getter
    private final ErrorCode errorCode;

    public AppRuntimeException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
