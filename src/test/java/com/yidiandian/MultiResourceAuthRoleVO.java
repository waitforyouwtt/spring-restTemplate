package com.yidiandian;


import lombok.Data;

import java.util.List;

/**
 * @author 凤凰小哥哥
 * @date 2020-11-17
 */
@Data
public class MultiResourceAuthRoleVO extends BaseEntity {


   private String productCode;


   private String tenantCode;


   private List<String> resourceCodes;


   private String  roleCode;


   private String type;
}
