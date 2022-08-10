package com.tencent.wxcloudrun.controller;


import cn.hutool.core.date.DateUtil;
import com.tencent.wxcloudrun.config.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/reduce")
public class ReduceController {


    @PostMapping("/enter")
    public Object enter(@RequestBody Map<String,Object> req){

        System.out.println(req);
        Map<String,Object> map = new HashMap<>();
        map.put("ToUserName", req.get("ToUserName"));
        map.put("FromUserName", req.get("FromUserName"));
        map.put("CreateTime", DateUtil.current()/1000);
        map.put("MsgType", "text");
        map.put("Content", "你好");
        return map;
    }

}
