package com.zoe.springboot.utils;

import com.zoe.springboot.view.ResultMsg;
import org.springframework.http.HttpStatus;

/**
 * 接口请求返回值工具类
 * Created by zoe on 2017/12/3.
 */
public class ResultUtil {

    /**
     * 请求成功
     * @param object
     * @return
     */
    public static ResultMsg success(Object object){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setCode(HttpStatus.OK.value());
        resultMsg.setMsg(HttpStatus.OK.getReasonPhrase());
        resultMsg.setData(object);
        return resultMsg;
    }

    /**
     * 错误
     * @param code
     * @param msg
     * @param object
     * @return
     */
    public static ResultMsg error(Integer code,String msg,Object object){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setCode(code);
        resultMsg.setMsg(msg);
        resultMsg.setData(object);
        return resultMsg;
    }

    /**
     * 系统错误
     * @return
     */
    public static ResultMsg systemError(){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        resultMsg.setMsg(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        resultMsg.setData("系统错误");
        return resultMsg;
    }
}
