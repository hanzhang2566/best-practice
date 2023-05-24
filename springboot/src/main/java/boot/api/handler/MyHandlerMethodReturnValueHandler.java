package boot.api.handler;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import boot.api.R;

/**
 * Usage: 自定义返回值处理器 <br/>
 * Date: 2023/5/22 10:12 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 * @see HandlerMethodReturnValueHandler
 * @see RequestResponseBodyMethodProcessor
 */
public class MyHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {
    private final HandlerMethodReturnValueHandler handler;

    public MyHandlerMethodReturnValueHandler(HandlerMethodReturnValueHandler handler) {
        this.handler = handler;
    }

    /**
     * 返回值不是 {@link R}，并且使用 Rest 方式返回 true
     *
     * @param returnType returnType
     * @return boolean ? 处理 : 不处理
     */
    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return handler.supportsReturnType(returnType) && !returnType.getParameterType().equals(R.class);
    }

    @Override
    public void handleReturnValue(Object returnValue,
                                  MethodParameter returnType,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest) throws Exception {
        R ok = R.ok(returnValue);
        handler.handleReturnValue(ok, returnType, mavContainer, webRequest);
    }
}
