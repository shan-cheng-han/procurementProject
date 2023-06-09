package com.hs.mapper;

import com.hs.bean.spare.AddSpareVo;
import com.hs.bean.spare.QuerySpareVo;
import com.hs.bean.spare.Spare;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 韩善成
 * @data 2023/5/11 10:06
 */
@Mapper
public interface SpareMapper {
    List<Spare> getSpareList(@Param("querySpareVo") QuerySpareVo querySpareVo);

    Integer getCount(@Param("querySpareVo")QuerySpareVo querySpareVo);

    Integer updateStatus(@Param("spare")Spare spare);


    Integer getCountByCode(@Param("code")String code);

    Integer getCountByName(@Param("name")String name);

    void addSpare(@Param("addSpareVo")AddSpareVo addSpareVo);

    /*根据备件名称获取备件id*/
    Integer getIdByName(@Param("name")String name);

    /*为法人备件关系表添加关系*/
    void addLegalPersonIdAndSpareId(@Param("spareId")Integer spareId,@Param("personId")Integer personId);
    void deleteLegalPersonIdAndSpareId(@Param("spareId")Integer spareId);

    int getStatus(@Param("id")Integer id);

    void modifySubClass(@Param("spare")Spare spare);


    List<Spare> getSpareCodeAndNameByLegalPersonCode(@Param("legalPersonCode") String legalPersonCode);
}
