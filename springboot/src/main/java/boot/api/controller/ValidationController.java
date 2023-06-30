package boot.api.controller;

import boot.api.rest.group.EmailGroup;
import boot.api.rest.group.LoginGroup;
import boot.api.rest.req.AccountReq;
import boot.api.rest.req.UserReq;
import boot.api.rest.validation.UniqueAccount;
import boot.service.ValidationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;

/**
 * Usage: 参数验证控制器 <br/>
 * Date: 2023/5/24 13:07 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
@RestController
@RequestMapping("/validation")
@Validated
public class ValidationController {
    @Resource
    private ValidationService validationService;

    @GetMapping("/param_notnull")
    public String notnull(@RequestParam("username") @NotEmpty String username) {
        return username;
    }

    @PostMapping("/pojo")
    public UserReq notnull(@RequestBody @Validated UserReq req) {
        return req;
    }

    @PostMapping("/pojo_email")
    public UserReq email(@RequestBody @Validated(value = {EmailGroup.class}) UserReq req) {
        return req;
    }

    @PostMapping("/pojo_login")
    public UserReq login(@RequestBody @Validated(value = {LoginGroup.class}) UserReq req) {
        return req;
    }

    @PostMapping("/account")
    public String createAccount(@RequestBody @Validated @UniqueAccount AccountReq accountReq) {
        accountReq.setEmail("hanzhang2566");
        return validationService.createAccount(accountReq);
    }
}
