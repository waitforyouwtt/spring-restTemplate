package com.yidiandian.view;

import lombok.Data;

@Data
public class IdaasRoleUsersDTO {

    String organizationCode;

    String roleCode;

    int pageSize = 200;

    int pageNum;
}
