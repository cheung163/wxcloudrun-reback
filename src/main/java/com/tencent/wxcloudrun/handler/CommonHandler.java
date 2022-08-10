package com.tencent.wxcloudrun.handler;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tencent.wxcloudrun.entity.HomeProduce;
import com.tencent.wxcloudrun.model.TextModel;
import com.tencent.wxcloudrun.service.HomeProduceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class CommonHandler {

    private final HomeProduceService homeProduceService;

    public Object handler(TextModel form) {
        String msg;
        if (form.getContent().contains("-")) {
            String[] split = form.getContent().split("-");
            QueryWrapper<HomeProduce> qw = new QueryWrapper<>();
            qw.eq("form_user", form.getFromUserName());
            qw.eq("produce", split[0]);
            HomeProduce one = homeProduceService.getOne(qw, false);
            if (one == null) {
                HomeProduce homeProduce = new HomeProduce();
                homeProduce.setFormUser(form.getFromUserName());
                homeProduce.setProduce(split[0]);
                homeProduce.setReduceId(IdUtil.getSnowflakeNextIdStr());
                homeProduce.setAddress(split[1]);
                homeProduce.setCreatetime(new Date());
                homeProduceService.save(homeProduce);
                msg = "已经替您记好了，我的小主";
            } else {
                msg = "小主，你将" + one.getProduce() + "从" + one.getAddress() + "放到了" + split[1] + "里，真棒";
                one.setAddress(split[1]);
                one.setCreatetime(new Date());
                homeProduceService.updateById(one);
            }
        } else {
            QueryWrapper<HomeProduce> qw = new QueryWrapper<>();
            qw.eq("produce", form.getContent());
            qw.eq("form_user", form.getFromUserName());
            HomeProduce one = homeProduceService.getOne(qw, false);
            if (one == null) {
                msg = "没记得您告诉过我呐，请小主再好好想想！";
            } else {
                msg = "小主，您的" + form.getContent() + "放在" + one.getAddress() + "里";
            }
        }
        return TextModel.toResponse(form, msg);
    }
}
