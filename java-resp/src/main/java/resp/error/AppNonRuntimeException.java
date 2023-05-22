package resp.error;

import lombok.Getter;
import resp.enums.ErrorCode;

/**
 * Usage: 非运行时异常 <br/>
 * Date: 2023/5/18 15:03 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
public class AppNonRuntimeException extends Exception {
    @Getter
    private final ErrorCode errorCode;

    public AppNonRuntimeException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
