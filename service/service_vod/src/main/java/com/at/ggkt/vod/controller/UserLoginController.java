package com.at.ggkt.vod.controller;

import com.at.ggkt.result.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserLoginController
 * @Description TODO
 * @Author liuqiang
 * @Date 2022-07-17-21:32
 */
@Api(tags = "用户登录模块")
@RestController
@CrossOrigin
@RequestMapping("/admin/vod/user")
public class UserLoginController {

    //login
    @PostMapping("login")
    public Result login(){
        Map<String,Object> map = new HashMap<>();
        map.put("token","admin-token");
        return Result.ok(map).code(20000);
    }

    @GetMapping("info")
    public Result info(){
        Map<String,Object> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("admin");
        map.put("roles",list);
        map.put("introduction","I am a super administrator");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name","Super Admin");
        return Result.ok(map).code(20000);
    }
}
