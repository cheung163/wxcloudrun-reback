package com.tencent.wxcloudrun.vo;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.wxcloudrun.form.TextForm;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
public class TextVo {
    private Map<String,Object> map = new HashMap<>();
    private final String ToUserName;
    private final String FromUserName;
    private long CreateTime = DateUtil.current() / 1000;
    private final String MsgType = "text";
    private final String Content;


    public static Map<String,Object> create(TextForm form, String text) {
        Map<String,Object> map = new HashMap<>();
        map.put("ToUserName",form.getFromUserName());
        map.put("FromUserName",form.getToUserName());
        map.put("CreateTime",DateUtil.current() / 1000);
        map.put("MsgType","text");
        map.put("Content",text);
        return map;
    }

    @Override
    public String toString() {
        return "TextVo{" +
                "ToUserName='" + ToUserName + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", CreateTime=" + CreateTime +
                ", MsgType='" + MsgType + '\'' +
                ", Content='" + Content + '\'' +
                '}';
    }
}
