package com.tencent.wxcloudrun.vo;

import cn.hutool.core.date.DateUtil;
import com.tencent.wxcloudrun.model.TextModel;

import java.util.HashMap;
import java.util.Map;

public class VoiceVo {


    public static Map<String,Object> create(TextModel form, String voiceId) {
        Map<String,Object> map = new HashMap<>();
        map.put("ToUserName",form.getFromUserName());
        map.put("FromUserName",form.getToUserName());
        map.put("CreateTime", DateUtil.current() / 1000);
        map.put("MsgType","voice");
        Map<String,Object> child = new HashMap<>();
        map.put("Content",child);
        child.put("MediaId",voiceId);
        return map;
    }
}
