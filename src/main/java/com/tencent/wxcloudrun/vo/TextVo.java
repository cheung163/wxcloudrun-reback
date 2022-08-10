package com.tencent.wxcloudrun.vo;

import cn.hutool.core.date.DateUtil;
import com.tencent.wxcloudrun.form.TextForm;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TextVo {
    private final String ToUserName;
    private final String FromUserName;
    private long CreateTime = DateUtil.current() / 1000;
    private final String MsgType = "text";
    private final String Content;


    public static TextVo create(TextForm form, String text) {
        return new TextVo(form.getToUserName(), form.getFromUserName(), text);
    }
}
