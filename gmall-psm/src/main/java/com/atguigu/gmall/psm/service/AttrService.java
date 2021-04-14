package com.atguigu.gmall.psm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.psm.entity.AttrEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 商品属性
 *
 * @author liuxi
 * @email 719597263@qq.com
 * @date 2021-04-13 18:12:03
 */
public interface AttrService extends IService<AttrEntity> {

    PageVo queryPage(QueryCondition params);
}

