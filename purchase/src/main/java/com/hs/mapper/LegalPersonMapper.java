package com.hs.mapper;

import com.hs.bean.legalperson.LegalPerson;
import com.hs.bean.legalperson.QueryLegalPersonVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 韩善成
 * @data 2023/5/12 4:39
 */
@Mapper
public interface LegalPersonMapper {
    List<LegalPerson> legalPersonList(@Param("userId") Integer userId);

    List<String> getNameList(@Param("spareCode") String spareCode);

    /*分页查询之获取法人列表*/
    List<LegalPerson> getLegalPersonList(@Param("queryLegalPersonVo") QueryLegalPersonVo queryLegalPersonVo);

    /*分页查询之获取法人数量*/
    Integer getCount(@Param("queryLegalPersonVo")QueryLegalPersonVo queryLegalPersonVo);
}
