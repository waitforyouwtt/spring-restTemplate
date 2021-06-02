package com.yidiandian;

import cn.hutool.json.JSONUtil;
import com.yidiandian.service.SingleQueryService;
import com.yidiandian.view.BaseProductView;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class zaxiangTest extends SpringResttemplateApplicationTests{

    @Autowired
    SingleQueryService singleQueryService;

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
    public void xxtest(){
        List<BaseProductView> allProduct = singleQueryService.findAllProduct();
        log.info("返回的结果:{}", JSONUtil.toJsonStr(allProduct));
    }
}
