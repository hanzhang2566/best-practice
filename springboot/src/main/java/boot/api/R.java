package boot.api;

import org.springframework.http.HttpStatus;
import boot.enums.ErrorCode;

import java.util.HashMap;

import static boot.enums.ErrorCode.OK;


/**
 * Usage: 业务响应 <br/>
 * Date: 2023/5/18 13:41 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
public class R extends HashMap<String, Object> {
    /**
     * 使用 errorCode 创建 R
     *
     * @param errorCode errorCode
     */
    private R(ErrorCode errorCode) {
        put("code", errorCode.getCode());
        put("message", errorCode.getMessage());
    }

    /**
     * 使用 data 创建一个正确的 R 对象，返回后端的数据
     *
     * @param data 数据
     * @return this
     */
    public static R ok(Object data) {
        R r = new R(OK);
        r.put("data", data);
        return r;
    }

    /**
     * 使用 message 创建一个错误的 R 对象，用来返回服务中定义的内部错误
     *
     * @param errorCode errorCode
     * @return this
     */
    public static R error(ErrorCode errorCode) {
        return new R(errorCode);
    }

    /**
     * 使用 message 创建 R
     *
     * @param message 错误消息
     */
    private R(String message) {
        put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
        put("message", message);
    }

    /**
     * 使用 message 创建一个错误的 R 对象，用来服务中未定义的内部错误
     *
     * @param message 错误消息
     * @return this
     */
    public static R error(String message) {
        return new R(message);
    }
}
