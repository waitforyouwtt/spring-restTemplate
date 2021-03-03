package com.yidiandian.vo;

import lombok.Data;

@Data
public class UserInfo {

    private String userCode;

    private String roleCode;

    private String resourceCode;

    private String resourceName;

    private String path;

    public UserInfo(String userCode, String roleCode, String resourceCode, String resourceName, String path) {
        this.userCode = userCode;
        this.roleCode = roleCode;
        this.resourceCode = resourceCode;
        this.resourceName = resourceName;
        this.path = path;
    }
    public UserInfo() {

    }
}
