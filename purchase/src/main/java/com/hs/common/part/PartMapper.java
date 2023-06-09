package com.hs.common.part;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 韩善成
 * @data 2023/6/7 23:54
 */
@Mapper
public interface PartMapper {

    @Select("select code,name from spare")
    List<QueryPart>query(QueryPart queryPart);
}
