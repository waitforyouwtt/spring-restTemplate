package com.yidiandian.view;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chensong
 * Date on  2021/3/11
 */
@Data
public class ReqUserDataAuthVO implements Serializable {

    private String userCode;
    private String ruleCode;
    private String productCode;
    private String tenantCode;
}
