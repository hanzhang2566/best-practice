package boot.api.interceptor;

import boot.enums.ErrorCode;
import boot.exception.AppRuntimeException;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.util.List;

/**
 * Usage: 验证角色的 {@link ClientHttpRequestInterceptor} 实现 <br/>
 * Date: 2023/6/3 13:51 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
public class RoleClientHttpRequestInterceptor implements ClientHttpRequestInterceptor, Ordered {
    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders headers = request.getHeaders();
        List<String> roles = headers.get("ROLE");
        if (CollectionUtils.isEmpty(roles) || ObjectUtils.isEmpty(roles.get(0))) {
            throw new AppRuntimeException(ErrorCode.ROLE_IS_MISSING);
        }
        String role = roles.get(0);
        if (!ObjectUtils.nullSafeEquals("admin", role)) {
            throw new AppRuntimeException(ErrorCode.ROLE_IS_NOT_MATCH);
        }
        ClientHttpResponse response = execution.execute(request, body);
        System.out.println("RoleClientHttpRequestInterceptor.intercept 后置处理");
        return response;
    }
}
