package com.tencent.wxcloudrun.vo;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.wxcloudrun.form.TextForm;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TextVo {
    @JsonProperty("ToUserName")
    private final String ToUserName;
    @JsonProperty("FromUserName")
    private final String FromUserName;
    @JsonProperty("CreateTime")
    private long CreateTime = DateUtil.current() / 1000;
    @JsonProperty("MsgType")
    private final String MsgType = "text";
    @JsonProperty("Content")
    private final String Content;


    public static TextVo create(TextForm form, String text) {
        return new TextVo(form.getToUserName(), form.getFromUserName(), text);
    }
}
