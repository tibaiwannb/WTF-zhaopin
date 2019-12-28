package com.briup.apps.zhaopin.web.controller;

import com.briup.apps.zhaopin.bean.JobhunterService;
import com.briup.apps.zhaopin.service.JobhunterServiceService;
import com.briup.apps.zhaopin.utils.Message;
import com.briup.apps.zhaopin.utils.MessageUtil;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: JobhunterServiceController
 * @description: 客服服务
 * @author: CC
 * @create: 2019/9/21 10:30
 */
@Api(description = "客服服务相关接口")
@RestController
@RequestMapping("/JobhunterService")
public class JobhunterServiceController {
    @Resource
    private JobhunterServiceService jobhunterServiceService;
    @ApiOperation(value = "根据id查询客服服务", notes = "精确查询,最常规的方式,支持GET方式")
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
        return MessageUtil.success(jobhunterServiceService.findById(id));
    }
    @ApiOperation(value = "查询所有客服服务", notes = "")
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
        return MessageUtil.success(jobhunterServiceService.findAll());
    }
    @ApiOperation(value = "新增或修改客服服务信息", notes = "不填ID为新增,添加ID为修改")
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
            @ApiImplicitParam(name = "customerServiceId", value = "客服id", required = true, dataType = "long", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "employmentJobhunterId", value = "求职信息id", required = true, dataType = "long", paramType = "query", defaultValue = ""),
    })
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(JobhunterService jobhunterService){
        return MessageUtil.success(jobhunterServiceService.saveOrUpdate(jobhunterService));
    }
    @ApiOperation(value = "根据id删除客服服务", notes = "")
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
        jobhunterServiceService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
}