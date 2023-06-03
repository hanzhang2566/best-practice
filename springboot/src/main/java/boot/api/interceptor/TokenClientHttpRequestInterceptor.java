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
 * Usage: 验证 Token 的 {@link ClientHttpRequestInterceptor} 实现 <br/>
 * Date: 2023/6/3 13:47 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
public class TokenClientHttpRequestInterceptor implements ClientHttpRequestInterceptor, Ordered {
    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders headers = request.getHeaders();
        List<String> tokens = headers.get("TOKEN");
        if (CollectionUtils.isEmpty(tokens) || ObjectUtils.isEmpty(tokens.get(0))) {
            throw new AppRuntimeException(ErrorCode.TOKEN_IS_MISSING);
        }
        String token = tokens.get(0);
        if (ObjectUtils.nullSafeEquals("admin", token)) {
            headers.add("ROLE", "admin");
        } else {
            headers.add("ROLE", "user");
        }
        ClientHttpResponse response = execution.execute(request, body);
        System.out.println("TokenClientHttpRequestInterceptor.intercept 后置处理");
        return response;
    }
}
