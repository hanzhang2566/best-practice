package resp.enums;

import lombok.Getter;

/**
 * Usage: 错误码 TODO 需要服务统一状态码 <br/>
 * Date: 2023/5/18 14:18 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
public enum ErrorCode {
    //<editor-fold desc="通用状态码">
    /**
     * 后端处理成功
     */
    OK(0, "ok"),

    /**
     * 后端出现未定义的服务器内部错误
     */
    FAILED(-1, "failed"),
    //</editor-fold>


    //<editor-fold desc="用户服务错误码">
    USER_NOT_EXIST(100101, "user isn't exist"),
    //</editor-fold>

    //<editor-fold desc="数据库服务错误码">
    DB_CONNECTION_ERROR(100201, "db hasn't connected"),
    //</editor-fold>
    ;

    /**
     * 业务错误码
     */
    @Getter
    private final int code;

    /**
     * 错误消息
     */
    @Getter
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
