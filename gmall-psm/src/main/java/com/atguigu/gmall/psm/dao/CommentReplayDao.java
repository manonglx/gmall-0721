package com.atguigu.gmall.psm.dao;

import com.atguigu.gmall.psm.entity.CommentReplayEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 * 
 * @author liuxi
 * @email 719597263@qq.com
 * @date 2021-04-13 18:12:03
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplayEntity> {
	
}
