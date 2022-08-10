package com.tencent.wxcloudrun.handler;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tencent.wxcloudrun.entity.HomeProduce;
import com.tencent.wxcloudrun.form.TextForm;
import com.tencent.wxcloudrun.service.HomeProduceService;
import com.tencent.wxcloudrun.vo.TextVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class CommonHandler {

    private final HomeProduceService homeProduceService;

    public Object handler(TextForm form) {
        String msg;
        if (form.getContent().contains("-")) {
            String[] split = form.getContent().split("-");

            QueryWrapper<HomeProduce> qw = new QueryWrapper<>();
            qw.eq("produce", split[0]);
            HomeProduce one = homeProduceService.getOne(qw, false);
            if (one == null) {
                HomeProduce homeProduce = new HomeProduce();
                homeProduce.setProduce(split[0]);
                homeProduce.setReduceId(IdUtil.getSnowflakeNextIdStr());
                homeProduce.setAddress(split[1]);
                homeProduceService.saveOrUpdate(homeProduce);
            } else {
                one.setAddress(split[1]);
                one.setCreatetime(new Date());
                homeProduceService.updateById(one);
            }

            msg = "已经为您保存好了，我的小主";
        } else {
            QueryWrapper<HomeProduce> qw = new QueryWrapper<>();
            qw.eq("produce", form.getContent());
            HomeProduce one = homeProduceService.getOne(qw, false);
            if (one == null) {
                msg = "没记得您告诉过我呐，请小主再好好想想！";
            } else {
                msg = "小主，您的" + form.getContent() + "放在" + one.getAddress() + "里";
            }
        }
        return TextVo.create(form, msg);
    }
}
