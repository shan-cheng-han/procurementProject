package com.hs.mapper;

import com.hs.bean.sparecostprice.AddSpareCostPriceVo;
import com.hs.bean.sparecostprice.QuerySpareCostPriceVo;
import com.hs.bean.sparecostprice.SpareCostPrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author 韩善成
 * @data 2023/6/6 15:46
 */
@Mapper
public interface SpareCostPriceMapper {

    List<SpareCostPrice> queryPage(@Param("cost") QuerySpareCostPriceVo querySpareCostPriceVo);

    Integer getCount(@Param("cost") QuerySpareCostPriceVo querySpareCostPriceVo);

    List<SpareCostPrice> getListByPersonCodeAndPlantCode(@Param("legalPersonCode")String legalPersonCode, @Param("legalPlantCode")String legalPlantCode);

    void add(@Param("cost")AddSpareCostPriceVo addSpareCostPriceVo);


    void uptadeOldStartTime(@Param("plusOrMinDay") Date plusOrMinDay, @Param("materialCode")String materialCode);

    void deleteOldSpareCostPrice(@Param("materialCode")String materialCode);

    List<SpareCostPrice> getListByMaterialCode(@Param("materialCode")String materialCode);

    void deleteByList(@Param("deleteList")Set<SpareCostPrice> deleteList);

    void addByList(@Param("addList")List<SpareCostPrice> addList);
}
