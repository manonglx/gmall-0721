package com.atguigu.gmall.psm.controller;

import java.util.Arrays;
import java.util.Map;


import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;
import com.atguigu.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.atguigu.gmall.psm.entity.SpuImagesEntity;
import com.atguigu.gmall.psm.service.SpuImagesService;




/**
 * spu图片
 *
 * @author liuxi
 * @email 719597263@qq.com
 * @date 2021-04-13 18:12:03
 */
@Api(tags = "spu图片 管理")
@RestController
@RequestMapping("psm/spuimages")
public class SpuImagesController {
    @Autowired
    private SpuImagesService spuImagesService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('psm:spuimages:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = spuImagesService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('psm:spuimages:info')")
    public Resp<SpuImagesEntity> info(@PathVariable("id") Long id){
		SpuImagesEntity spuImages = spuImagesService.getById(id);

        return Resp.ok(spuImages);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('psm:spuimages:save')")
    public Resp<Object> save(@RequestBody SpuImagesEntity spuImages){
		spuImagesService.save(spuImages);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('psm:spuimages:update')")
    public Resp<Object> update(@RequestBody SpuImagesEntity spuImages){
		spuImagesService.updateById(spuImages);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('psm:spuimages:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		spuImagesService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
