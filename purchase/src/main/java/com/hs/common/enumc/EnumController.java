package com.hs.common.enumc;

import com.hs.common.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 韩善成
 * @data 2023/6/6 12:02
 */
@RestController
@CrossOrigin
@Slf4j
public class EnumController {

    @RequestMapping(value = "/metadata/getPullDownList" ,method = RequestMethod.POST)
    public ResultVo getPullDownList(@RequestBody List<String> list){

        Map<String,List<XiaLaVo>> xiaLaMap = new HashMap<>();
        Map<String,List<XiaLaVo>> returnMap = new HashMap<>();

        //状态下拉
        List<XiaLaVo> statusXiaLaVos = new ArrayList<>();
        for (StatusEnum statusEnum: StatusEnum.values()) {
            XiaLaVo xiaLaVo = new XiaLaVo(statusEnum.getValue(),statusEnum.getStatusName());
            statusXiaLaVos.add(xiaLaVo);
        }
        xiaLaMap.put("statusList",statusXiaLaVos);

        //币种下拉
        List<XiaLaVo> currencyXiaLaVos = new ArrayList<>();
        for (CurrencyEnum currencyEnum: CurrencyEnum.values()) {
            XiaLaVo xiaLaVo = new XiaLaVo(currencyEnum.getValue(),currencyEnum.getName());
            currencyXiaLaVos.add(xiaLaVo);
        }
        xiaLaMap.put("money",currencyXiaLaVos);

        //价格分类下拉
        List<XiaLaVo> priceTypeXiaLaVos = new ArrayList<>();
        for (PriceTypeEnum priceTypeEnum: PriceTypeEnum.values()) {
            XiaLaVo xiaLaVo = new XiaLaVo(priceTypeEnum.getValue(),priceTypeEnum.getPriceType());
            priceTypeXiaLaVos.add(xiaLaVo);
        }
        xiaLaMap.put("jizhang",priceTypeXiaLaVos);

        for (String name: list) {
            for (String key:xiaLaMap.keySet()){
                if (name.equals(key)){
                    returnMap.put(name,xiaLaMap.get(name));
                }
            }
        }



        return ResultVo.success(returnMap);
    }
}
