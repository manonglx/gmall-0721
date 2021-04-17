package com.atguigu.gmall.psm.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;
import com.atguigu.core.bean.Resp;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.atguigu.gmall.psm.entity.CategoryEntity;
import com.atguigu.gmall.psm.service.CategoryService;
import org.springframework.web.servlet.ModelAndView;


/**
 * 商品三级分类
 *
 * @author liuxi
 * @email 719597263@qq.com
 * @date 2021-04-13 18:12:03
 */
@Api(tags = "商品三级分类 管理")
@RestController
@RequestMapping("psm/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ApiOperation("查询")
    @GetMapping("{catId}")
    public Resp<PageVo> queryGroupByPage(QueryCondition queryCondition,@PathVariable("catId") Long catId){
        PageVo page = categoryService.queryGroupByPage(queryCondition,catId);
        return Resp.ok(page);
    }



    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('psm:category:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = categoryService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{catId}")
    @PreAuthorize("hasAuthority('psm:category:info')")
    public Resp<CategoryEntity> info(@PathVariable("catId") Long catId) {
        CategoryEntity category = categoryService.getById(catId);

        return Resp.ok(category);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('psm:category:save')")
    public Resp<Object> save(@RequestBody CategoryEntity category) {
        categoryService.save(category);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('psm:category:update')")
    public Resp<Object> update(@RequestBody CategoryEntity category) {
        categoryService.updateById(category);



        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('psm:category:delete')")
    public Resp<Object> delete(@RequestBody Long[] catIds) {
        categoryService.removeByIds(Arrays.asList(catIds));

        return Resp.ok(null);
    }

    @ApiOperation("查询分类")
    @GetMapping
    public Resp<List<CategoryEntity>> queryCategoriesByPidOrLevel(@RequestParam(value = "level", defaultValue = "0") Integer level, @RequestParam(value = "parentCid", required = false) Long pid) {

        QueryWrapper<CategoryEntity> queryWrapper = new QueryWrapper<CategoryEntity>();
        if (level != 0) {
            queryWrapper.eq("cat_level", level);
        }
        //判断父节点的id
        if (pid != null) {
            queryWrapper.eq("parent_cid", pid);
        }
        List<CategoryEntity>  list = categoryService.list(queryWrapper);
        return Resp.ok(list);
    }




}
