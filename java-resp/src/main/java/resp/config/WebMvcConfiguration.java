package resp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import resp.handler.mvc.MyHandlerMethodReturnValueHandler;
import resp.resp.R;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Usage: 自定义 mvc 配置 <br/>
 * Date: 2023/5/22 10:31 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 * @see RequestResponseBodyMethodProcessor
 */
@Configuration
public class WebMvcConfiguration {
    /**
     * 调整请求处理适配器中 {@link RequestMappingHandlerAdapter#getReturnValueHandlers()} <br>
     * <ol>
     *     <li>{@link MyHandlerMethodReturnValueHandler} 普通 POJO 对象，返回前使用 {@link R} 进行包装</li>
     *     <li>兼容使用 {@link R} 包装过的返回值</li>
     * </ol>
     *
     * @param adapter 请求映射处理适配器
     */
    @Resource
    public void resetRequestMappingHandlerAdapter(RequestMappingHandlerAdapter adapter) {
        List<HandlerMethodReturnValueHandler> originHandlers = adapter.getReturnValueHandlers();
        if (CollectionUtils.isEmpty(originHandlers)) {
            return;
        }
        List<HandlerMethodReturnValueHandler> newHandlers = new ArrayList<>(originHandlers.size());
        for (HandlerMethodReturnValueHandler originHandler : originHandlers) {
            if (originHandler instanceof RequestResponseBodyMethodProcessor) {
                newHandlers.add(new MyHandlerMethodReturnValueHandler(originHandler));
                newHandlers.add(originHandler);
            } else {
                newHandlers.add(originHandler);
            }
        }
        adapter.setReturnValueHandlers(newHandlers);
    }
}
