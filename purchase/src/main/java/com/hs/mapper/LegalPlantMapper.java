package com.hs.mapper;

import com.hs.bean.legalplant.AddLegalPlant;
import com.hs.bean.legalplant.LegalPlant;
import com.hs.bean.legalplant.QueryLegalPlantVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 韩善成
 * @data 2023/5/12 6:15
 */
@Mapper
public interface LegalPlantMapper {
    /*分页条件查询获取列表集合*/
    List<LegalPlant> getLegalPlantList(@Param("queryLegalPlantVo") QueryLegalPlantVo queryLegalPlantVo);

    /*分页条件查询获取数据量*/
    Integer getCount(@Param("queryLegalPlantVo")QueryLegalPlantVo queryLegalPlantVo);

    /*新增之验证工厂编码是否已经存在*/
    Integer getCountByCode(@Param("legalPlant")AddLegalPlant legalPlant);

    /*新增法人工厂*/
    void addLegalPlant(@Param("legalPlant") AddLegalPlant legalPlant);

    /*启用禁用*/
    Integer updateEnabled(@Param("legalPlant")LegalPlant legalPlant);

    /*修改法人工厂信息*/
    void modifyLegalPlant(@Param("queryLegalPlantVo")LegalPlant queryLegalPlantVo);

    /*工厂下拉列表*/

    List<LegalPlant> queryPlantListByLegalPersonCode( String legalPersonCode);


}
