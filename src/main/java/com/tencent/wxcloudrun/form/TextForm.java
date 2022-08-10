package com.tencent.wxcloudrun.form;

import lombok.Data;

@Data
public class TextForm {

    private String ToUserName;
    private String FromUserName;
    private int CreateTime;
    private String MsgType;
    private String Content;
    private long MsgId;


}
