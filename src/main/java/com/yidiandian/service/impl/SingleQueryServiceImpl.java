package com.yidiandian.service.impl;

import com.alibaba.fastjson.JSON;
import com.yidiandian.constant.ConstantUrl;
import com.yidiandian.service.SingleQueryService;
import com.yidiandian.utils.Result;
import com.yidiandian.utils.esay.RemoteCallUtils;
import com.yidiandian.view.BaseProductView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SingleQueryServiceImpl implements SingleQueryService {

    @Autowired
    RemoteCallUtils getUtils;

    @Override
    public List<BaseProductView> findAllProduct() {
        Result result = getUtils.get(ConstantUrl.query_products);
        return  JSON.parseArray(JSON.toJSONString(result.getData()), BaseProductView.class);
    }
}
