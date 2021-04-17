package com.atguigu.gmall.psm.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.Query;
import com.atguigu.core.bean.QueryCondition;

import com.atguigu.gmall.psm.dao.CategoryDao;
import com.atguigu.gmall.psm.entity.CategoryEntity;
import com.atguigu.gmall.psm.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageVo(page);
    }

    @Override
    public PageVo queryGroupByPage(QueryCondition queryCondition, Long catId) {

        QueryWrapper<CategoryEntity>  queryWrapper=  new QueryWrapper<CategoryEntity>();
        if(catId !=null){
            queryWrapper.eq("catelog_id",catId);
        }
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(queryCondition),
                queryWrapper
        );
        return new PageVo(page);
    }

}