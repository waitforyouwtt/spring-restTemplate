package com.yidiandian.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author cqyc
 * @Description:
 * @date 2021/2/3
 */
@Data
public class ProductAuthMultiUserVo implements Serializable {

    private List<String> userCodes;

    private String userCode;

    private String optCode;

    private String optBy;

    private String roleCode;

    private List<String> roleCodes;

    private  Integer pageNum;

    private Integer pageSize;

    private String organizationCode;

    private String productCode;
}
