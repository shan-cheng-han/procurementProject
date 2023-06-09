package com.hs.mapper;

import com.hs.bean.fazhi.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 韩善成
 * @data 2023/6/9 10:55
 */
@Mapper
public interface FazhiMapper {
    void addFazhi(@Param("fazhi") Fazhi fazhi);

    void updateFazhi(@Param("fazhi") Fazhi fazhi);

    Integer getCount(@Param("fa")QueryFazhiVo queryFazhiVo);

    List<QueryFazhiRe> getFazhiList(@Param("fa") QueryFazhiVo queryFazhiVo);
}
