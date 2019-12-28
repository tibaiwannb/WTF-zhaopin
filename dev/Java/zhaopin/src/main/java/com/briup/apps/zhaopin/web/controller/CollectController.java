package com.briup.apps.zhaopin.web.controller;


import com.briup.apps.zhaopin.bean.Collect;
import com.briup.apps.zhaopin.service.CollectService;
import com.briup.apps.zhaopin.utils.Message;
import com.briup.apps.zhaopin.utils.MessageUtil;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: CollectController
 * @description: 我的收藏
 * @author: Ricardo
 * @create: 2019/9/30 11:21
 */
@Api(description = "我的收藏相关接口")
@RestController
@RequestMapping("/Collect")
public class CollectController {
    @Resource
    private CollectService collectService;

    @ApiOperation(value = "根据id查询我的收藏", notes = "精确查询,最常规的方式,支持GET方式")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 403, message = "资源不可用"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    @GetMapping("findById")
    public Message findById(Long id){
        return MessageUtil.success(collectService.findById(id));
    }

    @ApiOperation(value = "级联查询我的收藏中的招聘信息和求职者信息", notes = "精确查询,最常规的方式,支持GET方式")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 403, message = "资源不可用"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    @GetMapping("findAllWithEmpAndJob")
    public Message findAllWithEmpAndJob(){
        return MessageUtil.success(collectService.findAllWithEmpAndJob());
    }

    @ApiOperation(value = "查询所有收藏信息", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 403, message = "资源不可用"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    @GetMapping("findAll")
    public Message findAll(){
        return MessageUtil.success(collectService.findAll());
    }

    @ApiOperation(value = "新增或修改收藏信息", notes = "不填ID为新增,添加ID为修改")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 403, message = "资源不可用"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = false, dataType = "long", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "jobhunterId", value = "求职者id", required = true, dataType = "long", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "employmentId", value = "招聘信息id", required = true, dataType = "long", paramType = "query", defaultValue = ""),
    })
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Collect collect){
        return MessageUtil.success(collectService.saveOrUpdate(collect));
    }

    @ApiOperation(value = "根据id删除收藏信息", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 403, message = "资源不可用"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    @PostMapping("deleteById")
    public Message deleteById(Long id){
        collectService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

}