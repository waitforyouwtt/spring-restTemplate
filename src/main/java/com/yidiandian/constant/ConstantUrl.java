package com.yidiandian.constant;

public class ConstantUrl {

    public static final String KONG_URL_PRE = "http://kong-api-service.kfitwork.yonghui.cn/v1/consumer/hmac-auth/";
    public static final String KONG_URL_END_SAVE = "/assignCredential?kongAddr=10.251.64.88:8001";
    public static final String KONG_URL_END_DELETE = "/UnAssignCredential?kongAddr=10.251.64.88:8001";

    //public String baseUrl = "http://o2o-support-sit.o2o-support-idaas-gateway.sitgw.yonghui.cn";
    public static String baseUrl = "http://o2o-support-dev.o2o-support-idaas-gateway.devgw.yonghui.cn";


    public static String query_products = "/o2o-support-idaas-application/v1/purchase/findProducts";

}
