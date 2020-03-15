package com.sjkcxx.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName Response
 * @Description: 统一响应体
 * @Author liuyi
 * @Date 2019/12/17
 **/
@Getter
@Setter
public class ResultVo implements Serializable {

    private static final long serialVersionUID = -4687566942622114085L;

    // 响应业务状态
    private  String code;

    // 响应消息
    private String msg;

    //分页用到总数
    private int count;


    // 响应中的数据
    private Object data;

    public static ResultVo build(String code, String msg, Object data) {
        return new ResultVo(code, msg, data);
    }

    public static ResultVo success(Object data) {
        return new ResultVo(data);
    }

    public static ResultVo success() {
        return new ResultVo(null);
    }

    public ResultVo() {

    }

    public static ResultVo build(String code, String msg) {
        return new ResultVo(code, msg, null);
    }

    public ResultVo(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResultVo build(String code, String msg,int count, Object data) {
        return new ResultVo(code,msg,count,data);
    }


    public ResultVo(String code, String msg, int count, Object data) {
        this.code = code;   //分页成功的code为0
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public ResultVo(Object data) {
        this.code = "200";
        this.msg = "success";
        this.data = data;
    }

}
