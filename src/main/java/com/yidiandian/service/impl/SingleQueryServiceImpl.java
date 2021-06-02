package com.yidiandian.service.impl;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.yidiandian.constant.ConstantUrl;
import com.yidiandian.service.SingleQueryService;
import com.yidiandian.utils.Result;
import com.yidiandian.utils.esay.GetUtils;
import com.yidiandian.view.BaseProductView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SingleQueryServiceImpl implements SingleQueryService {

    @Autowired
    GetUtils getUtils;

    @Override
    public List<BaseProductView> findAllProduct() {
        Result result = getUtils.get(ConstantUrl.query_products);
        //List<BaseProductView> userBaseModels = JSONUtil.parseArray(result.getData(), BaseProductView.class);
        return null;
    }
}
