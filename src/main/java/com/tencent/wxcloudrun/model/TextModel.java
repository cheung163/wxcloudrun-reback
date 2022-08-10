package com.tencent.wxcloudrun.model;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class TextModel {

    @JsonProperty("ToUserName")
    private String ToUserName;
    @JsonProperty("FromUserName")
    private String FromUserName;
    @JsonProperty("CreateTime")
    private int CreateTime;
    @JsonProperty("MsgType")
    private String MsgType;
    @JsonProperty("Content")
    private String Content;
    @JsonProperty("MsgId")
    private long MsgId;

   public static Map<String,Object> toResponse(TextModel form, String text) {
       Map<String,Object> map = new HashMap<>();
       map.put("ToUserName",form.getFromUserName());
       map.put("FromUserName",form.getToUserName());
       map.put("CreateTime", DateUtil.current() / 1000);
       map.put("MsgType","text");
       map.put("Content",text);
       return map;
   }
}
