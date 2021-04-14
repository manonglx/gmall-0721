package com.atguigu.gmall.psm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.psm.entity.SpuInfoDescEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * spu信息介绍
 *
 * @author liuxi
 * @email 719597263@qq.com
 * @date 2021-04-13 18:12:03
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageVo queryPage(QueryCondition params);
}

