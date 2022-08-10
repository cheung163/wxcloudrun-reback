package com.tencent.wxcloudrun.model;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class VoiceModel {
    @JsonProperty("ToUserName")
    private String ToUserName;
    @JsonProperty("FromUserName")
    private String FromUserName;
    @JsonProperty("CreateTime")
    private String CreateTime;
    @JsonProperty("MsgType")
    private String MsgType;
    @JsonProperty("MediaId")
    private String MediaId;
    @JsonProperty("Format")
    private String Format;
    @JsonProperty("MsgId")
    private String MsgId;
    @JsonProperty("MsgDataId")
    private String MsgDataId;
    @JsonProperty("Idx")
    private String Idx;

    public static String loadUserVoice(String idx){

        String url = "https://api.weixin.qq.com/cgi-bin/media/get";
        return null;
    }


    public static Map<String, Object> toResponse(TextModel form, String voiceId) {
        Map<String, Object> map = new HashMap<>();
        map.put("ToUserName", form.getFromUserName());
        map.put("FromUserName", form.getToUserName());
        map.put("CreateTime", DateUtil.current() / 1000);
        map.put("MsgType", "voice");
        Map<String, Object> child = new HashMap<>();
        map.put("Voice", child);
        child.put("MediaId", voiceId);
        return map;
    }
}
