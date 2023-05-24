package boot.enums;

import lombok.Getter;

/**
 * Usage: 错误码 <br/>
 * Date: 2023/5/18 14:18 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
public enum ErrorCode {

    //<editor-fold desc="http 状态码">
    OK(0, "ok"),
    METHOD_NOT_ALLOWED(405, "request method not supported"),
    //</editor-fold>

    //<editor-fold desc="通用错误">
    REQUEST_BODY_IS_MISSING(100001, "request body is missing"),
    //</editor-fold>


    //<editor-fold desc="用户服务错误码">
    USER_NOT_EXIST(100101, "user isn't exist"),
    USER_HAS_EXISTED(100102, "user has existed"),
    SAVE_USER_FAILED(100103, "save user failed"),
    //</editor-fold>

    //<editor-fold desc="数据库服务错误码">
    DB_CONNECTION_ERROR(100201, "db hasn't connected"),
    //</editor-fold>

    //<editor-fold desc="业务错误码">
    CREATE_MEMO_FAILED(100301, "create memo failed"),
    MEMO_FINISH_FAILED(100302, "memo finish failed"),
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
