package com.yidiandian.constant;

public class ConstantUrl {

    public static final String KONG_URL_PRE = "http://kong-api-service.kfitwork.yonghui.cn/v1/consumer/hmac-auth/";
    public static final String KONG_URL_END_SAVE = "/assignCredential?kongAddr=10.251.64.88:8001";
    public static final String KONG_URL_END_DELETE = "/UnAssignCredential?kongAddr=10.251.64.88:8001";

    public static String query_products = "/o2o-support-idaas-application/v1/purchase/findProducts";

    public static int success = 200;
    public static String success_msg = "success";

    public static int error   = 500;
    public static String error_msg = "error";

}
