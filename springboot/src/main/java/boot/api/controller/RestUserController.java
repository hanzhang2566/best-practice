package boot.api.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/**
 * Usage: 客户端拦截器测试控制器 <br/>
 * Date: 2023/6/3 13:43 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
@RestController
@RequestMapping("/rest")
public class RestUserController {
    @Resource
    private RestTemplate restTemplate;

    private final List<String> roles = Arrays.asList("admin", "normal");

    /**
     * 模拟客户端调用方
     *
     * @return boolean
     */
    @GetMapping("/caller")
    public boolean caller() {
        String url = "http://localhost:18080/rest/callee";
//        MultiValueMap<String, String> headers, HttpMethod method, URI url
        MultiValueMap<String, String> headers = new HttpHeaders();
        int index = (int) (System.currentTimeMillis() % 2);
        headers.add("TOKEN", roles.get(index));
        System.out.println(roles.get(index));
        RequestEntity<?> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, URI.create(url));
        ResponseEntity<String> resp = restTemplate.exchange(requestEntity, String.class);
        System.out.println("resp = " + resp);
        return true;
    }

    /**
     * 模拟服务端被调用
     *
     * @return String
     */
    @GetMapping("/callee")
    public String callee() {
        return "I'm callee.";
    }
}
