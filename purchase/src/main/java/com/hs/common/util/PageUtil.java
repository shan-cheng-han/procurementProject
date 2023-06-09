package com.hs.common.util;

import lombok.Data;

import java.util.List;

/**
 * @author 韩善成
 * @data 2023/6/9 12:21
 */
@Data
public class PageUtil<T> {

    //总页数
    private Integer totalPage;

    //总条数
    private Integer totalSize;

    //当前页数
    private Integer currentPage;

    //页目数
    private Integer PageSize;

    //集合信息
    private List<T> dataList;


    public static <T> PageUtil pageUtil(Integer totalSize,Integer currentPage,Integer PageSize,List<T> dataList){

        Integer totalPage = totalSize % PageSize == 0 ? totalSize / PageSize : totalSize / PageSize+1;

        PageUtil<T> pageUtil = new PageUtil<>();
        pageUtil.setCurrentPage(currentPage);
        pageUtil.setTotalSize(totalSize);
        pageUtil.setTotalPage(totalPage);
        pageUtil.setDataList(dataList);

        return pageUtil;
    }
}
