package com.hs.common.part;

import com.hs.common.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 韩善成
 * @data 2023/6/7 23:54
 */
@Service
public class PartServiceImpl implements PartService{
    @Autowired
    private PartMapper partMapper;

    @Override
    public ResultVo query(QueryPart queryPart) {

        List<QueryPart> data  = partMapper.query(queryPart);

        return ResultVo.success(data);
    }
}
