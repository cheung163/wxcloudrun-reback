package com.tencent.wxcloudrun.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TextForm {

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
}
