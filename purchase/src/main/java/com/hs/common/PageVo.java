package com.hs.common;

import lombok.Data;

import java.util.List;

/**
 * @author 韩善成
 * @data 2023/4/19 9:18
 * 分页查询类
 */
@Data
public class PageVo<T> {
    //总页数
    private Integer totalPage;

    //总条数
    private Integer totalSize;

    //当前页数
    private Integer currentPage;

    //集合信息
    private List<T> dataList;


}
