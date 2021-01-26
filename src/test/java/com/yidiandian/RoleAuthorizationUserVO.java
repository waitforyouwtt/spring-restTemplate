package com.yidiandian;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 凤凰小哥哥
 * @date 2020-12-06
 */
@Data
public class RoleAuthorizationUserVO implements Serializable {

    private String productCode;

    private String tenantCode;

    private String organizationCode;

    private String roleCode;

    private String userCode;

    private String optBy;

    private String optCode;
}
