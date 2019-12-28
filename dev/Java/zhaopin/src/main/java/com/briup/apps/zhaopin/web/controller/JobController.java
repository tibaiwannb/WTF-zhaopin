package com.briup.apps.zhaopin.web.controller;

import com.briup.apps.zhaopin.bean.Jobs;
import com.briup.apps.zhaopin.service.JobsService;
import com.briup.apps.zhaopin.utils.Message;
import com.briup.apps.zhaopin.utils.MessageUtil;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: JobController
 * @description: 职位
 * @author: CC
 * @create: 2019/9/21 10:31
 */
@Api(description = "职位相关接口")
@RestController
@RequestMapping("/Jobs")

public class JobController {
    @Resource
    private JobsService jobsService;

    @ApiOperation(value = "根据status查询职位", notes = "精确查询,最常规的方式,支持GET方式")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 403, message = "资源不可用"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    @GetMapping("findByStatus")
    public Message findByStatus(String staus){
        return MessageUtil.success(jobsService.findByStatus(staus));
    }
    @ApiOperation(value = "根据id查询职位", notes = "精确查询,最常规的方式,支持GET方式")
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
        return MessageUtil.success(jobsService.findById(id));
    }
    @ApiOperation(value = "查询所有职位", notes = "")
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
        return MessageUtil.success(jobsService.findAll());
    }
    @ApiOperation(value = "新增或修改职位信息", notes = "不填ID为新增,添加ID为修改")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 403, message = "资源不可用"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = false, paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "jobTypeId", value = "jobTypeId", required = false, paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "name", value = "职位名称", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "status", value = "职位分类", required = true, paramType = "query", dataType = "string"),
        }
    )
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Jobs jobs){
        return MessageUtil.success(jobsService.saveOrUpdate(jobs));
    }
    @ApiOperation(value = "根据id删除职位", notes = "")
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
        jobsService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

}
