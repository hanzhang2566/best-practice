package boot.config;

import boot.api.interceptor.RoleClientHttpRequestInterceptor;
import boot.api.interceptor.TokenClientHttpRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Usage: {@link RestTemplate} 配置 <br/>
 * Date: 2023/6/3 13:45 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
@Configuration
@Import({TokenClientHttpRequestInterceptor.class, RoleClientHttpRequestInterceptor.class})
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate(List<ClientHttpRequestInterceptor> interceptors) {
        RestTemplate restTemplate = new RestTemplate();
        AnnotationAwareOrderComparator.sort(interceptors);
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
}
