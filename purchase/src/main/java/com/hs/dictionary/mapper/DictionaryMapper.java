package com.hs.dictionary.mapper;

import com.hs.dictionary.model.ZiDianVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Dictionary;
import java.util.List;

/**
 * @author 韩善成
 * @data 2023/6/7 5:20
 */
@Mapper
public interface DictionaryMapper {
    @Select("select * from dictionary")
    List<ZiDianVo> query();

    @Select("select count(id) from dictionary where code = #{code}}")
    Integer getCountByCode(String code);

    @Select("select count(id) from dictionary where name = #{name}}")
    Integer getCountByName(String name);

    @Insert("insert into dictionary(name,code,remark,status,createMan,createTime,modifyMan,modifyTime,isParent) " +
            "values (#{ziDianVo.name},#{ziDianVo.code},#{ziDianVo.remark},#{ziDianVo.status},#{ziDianVo.createMan},#{ziDianVo.createTime},#{ziDianVo.modifyMan},#{ziDianVo.modifyTime},1)")
    void addParent(ZiDianVo ziDianVo);

    @Insert("insert into dictionary(name,code,remark,status,createMan,createTime,modifyMan,modifyTime,parentCode) " +
            "values (#{ziDianVo.name},#{ziDianVo.code},#{ziDianVo.remark},#{ziDianVo.status},#{ziDianVo.createMan},#{ziDianVo.createTime},#{ziDianVo.modifyMan},#{ziDianVo.modifyTime},#{ziDianVo.parentCode})")
    void addSon(ZiDianVo ziDianVo);

    @Update("update dictionary set status = 1 where code = #{code} or parentCode = #{code} )")
    void enableStatus(String code);

    @Update("update dictionary set status = 0 where code = #{code} or parentCode = #{code} )")
    void unEnableStatus(String code);
}
