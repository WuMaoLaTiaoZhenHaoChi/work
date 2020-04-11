package com.sjkcxx.base;

import lombok.Data;

import java.util.List;

/**
 * @Author: duant
 * @Date: 2020/3/29 16:51
 * @Description:
 */
@Data
public class PageDto<T> {

    private int page;           //当前页数

    private int current;          //从哪里查询

    private int limit;          //查询多少条

    private int count;          //共多少条

    private List<T> data;       //实体数据封装

    public void calculateCurrent(){
        this.current = (this.page - 1) * this.limit;
    }

    public void setPageDto(int count,List<T> data){
        this.count = count;
        this.data = data;
    }

}
