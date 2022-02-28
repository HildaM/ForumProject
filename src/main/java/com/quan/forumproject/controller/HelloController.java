package com.quan.forumproject.controller;

import com.quan.forumproject.common.api.CommonResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @Description: 测试接口
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/27 15:52
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    @PreAuthorize("hasAuthority('test')")
    public CommonResult hello() {
        return CommonResult.success("测试成功");
    }
}
