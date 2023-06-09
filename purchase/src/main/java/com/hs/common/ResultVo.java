package com.hs.common;

import lombok.Data;

/**
 * @author 韩善成
 * @data 2023/4/21 17:54
 */
@Data
public class ResultVo<T> {

    //true:成功    false:失败
    private boolean success;

    //存储错误信息或成功信息
    private String message;

    //存储数据
    private T data;

    //表单验证  失败
    public static ResultVo error(String message){
        ResultVo resultVo = new ResultVo();
        resultVo.setSuccess(false);
        resultVo.setMessage(message);
        return resultVo;
    }

    //成功
    public static<T> ResultVo success(T data){
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setSuccess(true);
        resultVo.setData(data);
        return  resultVo;
    }

    public static ResultVo success(){
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setSuccess(true);
        return  resultVo;
    }



}
