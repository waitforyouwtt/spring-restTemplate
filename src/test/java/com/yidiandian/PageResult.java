package com.yidiandian;

import lombok.Data;

import java.util.List;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-27
 */
@Data
public class PageResult {

    private int pageNum;

    private int pageSize;

    private long total;

    private int pages;

    private List<?> list;
}
