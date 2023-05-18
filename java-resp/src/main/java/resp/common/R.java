package resp.common;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

import static resp.common.ErrorCode.OK;


/**
 * Usage: http 响应 <br/>
 * Date: 2023/5/18 13:41 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
public class R extends HashMap<String, Object> {

    public R(ErrorCode errorCode) {
        put("code", errorCode.getCode());
        put("message", errorCode.getMessage());
    }

    public R(String message) {
        put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
        put("message", message);
    }

    public static R ok(Object data) {
        R r = new R(OK);
        r.put("data", data);
        return r;
    }

    public static R error(ErrorCode errorCode) {
        return new R(errorCode);
    }

    public static R error(String message) {
        return new R(message);
    }
}
