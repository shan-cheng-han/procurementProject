package com.hs.common.part;

import com.hs.common.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 韩善成
 * @data 2023/6/7 23:30
 */
@RestController
@CrossOrigin
public class PartController {
    @Autowired
    private PartService partService;

    @RequestMapping(value = "/part/query",method = RequestMethod.POST)
    public ResultVo query(@RequestBody QueryPart queryPart){

        return partService.query(queryPart);
    }
}
