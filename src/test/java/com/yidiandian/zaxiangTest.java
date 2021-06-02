package com.yidiandian;

import cn.hutool.json.JSONUtil;
import com.yidiandian.view.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Slf4j
@Component
public class zaxiangTest extends SpringResttemplateApplicationTests{



    @Test
    public void testone(){
        List<Long> ids= new ArrayList<Long>();
        ids.add(2l);
        ids.add(20l);
        ids.add(22l);
        ids.add(28l);
        ids.add(202l);

        //List转换成String两种方式
        String idsString = StringUtils.join(ids, ",");
        log.info("list<long> 转string:{}",idsString);
    }

    @Test
    public void testtwo(){
        List<Long> parentIds = Collections.singletonList(0L);
        for (Long id : parentIds){
            log.info("得到的数据:{}",id);
        }
    }

    @Test
    public void test3(){
        List<UserInfo> users = new ArrayList<>();
        users.add(new UserInfo("80728143","cwzt00000004","/notice_list","历史公告","/notice_list"));
        users.add(new UserInfo("80728143","cwzt00000004","caiwu","财务中心","/caiwu"));
        users.add(new UserInfo("80728143","cwzt00000004","/publish_notice1","发布公告","/publish_notice"));
        users.add(new UserInfo("80728143","cwzt00000004","/shezhi","系统设置","/设置"));
        users.add(new UserInfo("80728143","cwzt00000004","/shouye","首页","/home"));
        users.add(new UserInfo("80728143","cwzt00000004","/shuiwu","税务中心","/shuiwu"));
        users.add(new UserInfo("80728143","cwzt00000004","/zijin","资金中心","/zijin"));
        users.add(new UserInfo("80728143","cwzt00000005","/notice_list","历史公告","/notice_list"));
        users.add(new UserInfo("80728143","cwzt00000005","/caiwu","财务中心","/notice_list"));
        users.add(new UserInfo("80728143","cwzt00000005","/publish_notice1","发布公告","/publish_notice"));
        //log.info("原始数据：{}",JSONUtil.toJsonStr(users));
        log.info("原始数据的size:{}",users.size());
        //我是去重处理哦
        users = users.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(UserInfo:: getResourceCode))), ArrayList::new));
        log.info("处理后的数据：{}",JSONUtil.toJsonStr(users));
        log.info("处理收数据的size:{}",users.size());
    }
}
