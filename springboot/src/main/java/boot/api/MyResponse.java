package boot.api;

import boot.enums.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;

/**
 * Usage: 业务响应 <br/>
 * Date: 2023/6/6 17:16 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
public class MyResponse<T> {
    /**
     * 业务码
     */
    private int code;

    /**
     * 提示消息
     */
    private String message;

    /**
     * 数据
     */
    private T data;


    /**
     * 使用 data 创建一个正确的 R 对象，返回后端的数据
     *
     * @param data 数据
     * @return this
     */
    public static <T> MyResponse<T> ok(T data) {
        return of(ErrorCode.OK.getCode(), ErrorCode.OK.getMessage(), data);
    }

    /**
     * 使用 errorCode 创建一个错误的 R 对象，用来返回服务中定义的内部错误
     *
     * @param errorCode errorCode
     * @return this
     */
    public static <T> MyResponse<T> fail(ErrorCode errorCode) {
        return of(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 使用 message 创建一个错误的 R 对象，用来服务中未定义的内部错误
     *
     * @param message 错误消息
     * @return this
     */
    public static <T> MyResponse<T> fail(String message) {
        return of(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, null);
    }

    /**
     * 创建 MyResponse 类
     *
     * @param code    业务码
     * @param message 提示消息
     * @param data    数据
     * @param <T>     T
     * @return MyResponse
     */
    private static <T> MyResponse<T> of(int code, String message, T data) {
        MyResponse<T> response = new MyResponse<>();
        response.code = code;
        response.message = message;
        if (!ObjectUtils.isEmpty(data)) {
            response.data = data;
        }

        return response;
    }
}
