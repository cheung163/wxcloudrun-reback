package com.tencent.wxcloudrun.controller;


import com.tencent.wxcloudrun.model.TextModel;
import com.tencent.wxcloudrun.handler.CommonHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reduce")
@RequiredArgsConstructor
public class ReduceController {

    private final CommonHandler commonHandler;

    @PostMapping("/enter")
    public Object enter(@RequestBody TextModel form) {
        return commonHandler.handler(form);
    }

}
