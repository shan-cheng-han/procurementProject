package com.hs.common.too_old_too_out;

import com.hs.common.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 韩善成
 * @data 2023/5/8 10:35
 */
@RestController
@CrossOrigin
@Slf4j
public class StatusController {

    //@RequestMapping(value = "/metadata/getPullDownList" ,method = RequestMethod.POST)
    public ResultVo getPullDownList(){

        List<StatusVo> statusList = new ArrayList<>();

        statusList.add(new StatusVo("全部",null));
        statusList.add(new StatusVo("启用",1));
        statusList.add(new StatusVo("禁用",0));

        return ResultVo.success(statusList);
    }
}
