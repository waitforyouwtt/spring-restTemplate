package com.yidiandian.view;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BaseProductView implements Serializable {

    private String productCode;

    private String productName;

    private String clientId;

    private String clientSecret;

    private List<String> tenantCodes;

}
