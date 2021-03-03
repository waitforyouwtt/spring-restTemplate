package com.yidiandian;

import com.yidiandian.vo.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Slf4j
public class SelfTest extends SpringResttemplateApplicationTests{

    @Test
    public void test1 (){
        List<UserInfo> users = new ArrayList<>();
        users.add(new UserInfo("80728143","cwzt00000004","/money","历史公告","/notice_list"));
        users.add(new UserInfo("80728143","cwzt00000004","/money","历史公告","/caiwu"));
        users.add(new UserInfo("80728143","cwzt00000004","/money","历史公告","/publish_notice"));
        users.add(new UserInfo("80728143","cwzt00000004","/money","系统设置","/设置"));
        users.add(new UserInfo("80728143","cwzt00000004","/money","系统设置","/home"));
        users.add(new UserInfo("80728143","cwzt00000004","/money","系统设置","/shuiwu"));
        users.add(new UserInfo("80728143","cwzt00000004","/money","系统设置","/zijin"));
        users.add(new UserInfo("80728143","cwzt00000004","/money","历史公告","/notice_list"));
        users.add(new UserInfo("80728143","cwzt00000004","/money","财务中心","/notice_list"));
        users.add(new UserInfo("80728143","cwzt00000004","/money","财务中心","/publish_notice"));

        Map<String, List<UserInfo>> personMap = new HashMap<>();
        personMap = users.stream().collect(Collectors.toMap(UserInfo::getResourceName,
                (p) -> {
                    List namePersons = new ArrayList();
                    namePersons.add(p);
                    return namePersons;
                },
                // 重复时将现在的值全部加入到之前的值内
                (List<UserInfo> person1, List<UserInfo> person2) -> {
                    person1.addAll(person2);
                    return person1;
                }
        ));
        System.out.println(personMap);


        /*Map<String, List<UserInfo>> map = users.stream().collect(Collectors.groupingBy(UserInfo::getResourceName));
        log.info("得到的结果：{}", JSONUtil.toJsonStr(map));
        List<UserInfo> userList = new ArrayList<>();
        map.forEach((k, v) -> {
            System.out.println("key:value = " + k + ":" + v);
            v.stream().forEach(info->{

            });
        });*/


    }
}
