/*
 * Copyright 2012-2020. the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. More information from:
 *
 *        https://github.com/fenixsoft
 */

package boot.api.rest.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * Usage: 账户实体 <br/>
 * Date: 2023/6/29 17:01 <br/>
 *
 * @author <a href="mailto:hanzhang2566@foxmail.com">hanzhang</a>
 */
@Data
public class AccountReq {

    @NotEmpty(message = "用户不允许为空")
    private String username;

    // 密码字段不参与序列化（但反序列化是参与的）、不参与更新（但插入是参与的）
    // 这意味着密码字段不会在获取对象（很多操作都会关联用户对象）的时候泄漏出去；
    // 也意味着此时“修改密码”一类的功能无法以用户对象资源的接口来处理（因为更新对象时密码不会被更新），需要单独提供接口去完成
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotEmpty(message = "用户姓名不允许为空")
    private String name;

    private String avatar;

    @Pattern(regexp = "1\\d{10}", message = "手机号格式不正确")
    private String telephone;

    @Email(message = "邮箱格式不正确")
    @NotEmpty(message = "邮箱不允许为空")
    private String email;

    private String location;
}
