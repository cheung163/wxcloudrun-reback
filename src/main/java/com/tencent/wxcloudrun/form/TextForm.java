package com.tencent.wxcloudrun.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    @Override
    public String toString() {
        return "TextForm{" +
                "ToUserName='" + ToUserName + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", CreateTime=" + CreateTime +
                ", MsgType='" + MsgType + '\'' +
                ", Content='" + Content + '\'' +
                ", MsgId=" + MsgId +
                '}';
    }
}
