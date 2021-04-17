package com.atguigu.gmall.wms.dao;

import com.atguigu.gmall.wms.entity.WareInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 仓库信息
 * 
 * @author lixianfeng
 * @email lxf@atguigu.com
 * @date 2021-04-15 20:50:55
 */
@Mapper
public interface WareInfoDao extends BaseMapper<WareInfoEntity> {
	
}
