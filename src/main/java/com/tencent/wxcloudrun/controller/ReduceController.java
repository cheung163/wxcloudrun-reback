package com.tencent.wxcloudrun.controller;


import cn.hutool.core.date.DateUtil;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.form.TextForm;
import com.tencent.wxcloudrun.handler.CommonHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/reduce")
@RequiredArgsConstructor
public class ReduceController {

    private final CommonHandler commonHandler;

    @PostMapping("/enter")
    public Object enter(@RequestBody TextForm form) {
        return commonHandler.handler(form);
    }

}
