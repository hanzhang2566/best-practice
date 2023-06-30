package boot.service;

import boot.api.controller.ValidationController;
import boot.api.rest.req.AccountReq;
import boot.api.rest.validation.UniqueAccount;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * Usage: {@link ValidationController} 服务接口 <br/>
 * Date: 2023/6/29 17:07 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
public interface ValidationService {

    String createAccount(AccountReq accountReq);

    String updateAccount(AccountReq accountReq);

    String hello(@NotNull(message = "name cannot be null") String name);

}
