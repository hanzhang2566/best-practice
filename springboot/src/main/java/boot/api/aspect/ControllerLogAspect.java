package boot.api.aspect;

import boot.api.advice.ExceptionAdvice;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.stream.Collectors;


/**
 * Usage: 控制器切面 <br/>
 * Date: 2023/5/18 13:41 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
@Slf4j
@Aspect
@Component
public class ControllerLogAspect {
    @Resource
    private HttpServletRequest request;

    /**
     * 切面范围
     */
    @Pointcut("execution(public * boot.api.controller..*.*controller.*.*(..))")
    public void controllerLog() {
    }


    /**
     * 记录请求日志
     *
     * @param joinPoint jointPoint
     */
    @Before("controllerLog()")
    public void requestLog(JoinPoint joinPoint) {
        log.info("Request Method: {}, URL: {}, RemoteAddr: {}, Endpoint: {}.{}", request.getMethod(), request.getRequestURL().toString(),
                request.getRemoteAddr(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        log.info("Request Args: {}", Arrays.stream(joinPoint.getArgs()).map(Object::toString).collect(Collectors.joining(", ")));
    }

    /**
     * TODO  记录处理时常的切面，还需要看看
     *
     * @param joinPoint jointPoint
     * @return Object
     * @throws Throwable Exception 会被 {@link ExceptionAdvice#onException(Exception)} 处理，其余会直接 throw
     */
    @Around("controllerLog()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Instant start = Instant.now();
        Object res = joinPoint.proceed();
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
        log.info("Execution time of the endpoint {} is {} ms.", method.getName(), timeElapsed);
        return res;
    }
}
