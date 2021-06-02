package com.yidiandian.view;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 凤凰小哥哥
 * @date 2020-11-29
 */
@Data
public class ResourceAuthUserView implements Serializable {

    private String userCode;
    private String productCode;
    private String tenantCode;
    private String roleCode;
    private String resourceCode;
    private String parentCode;
    private String resourceName;
    private String path;
    private String type;
    private String resourceType;
    private Integer orderNum;
    private Date createdTime;
}
