package com.briup.apps.zhaopin.web.controller;

import com.briup.apps.zhaopin.bean.Employment;
import com.briup.apps.zhaopin.service.EmploymentService;
import com.briup.apps.zhaopin.utils.Message;
import com.briup.apps.zhaopin.utils.MessageUtil;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: EmploymentController
 * @description: 招聘信息
 * @author: CC
 * @create: 2019/9/19 21:25
 */

@Api( description = "招聘信息相关接口")
@RestController
@RequestMapping("/Employment")
public class EmploymentController {
    @Resource
    private EmploymentService employmentService;
    @ApiOperation(value = "根据id查询招聘信息", notes = "精确查询,最常规的方式,支持GET方式")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "id", required = false,
//                    dataType = "string", paramType = "path", defaultValue = "1")
//    })
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
        return MessageUtil.success(employmentService.findById(id));
    }
    @ApiOperation(value = "查询所有招聘信息", notes = "")
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
        return MessageUtil.success(employmentService.findAll());
    }
    @ApiOperation(value = "新增或修改招聘信息", notes = "不填ID为新增,添加ID为修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = false, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "publishTime", value = "发布日期", required = false, dataType = "date-time", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "businessId", value = "商家id", required = true, dataType = "long", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "city", value = "城市", required = false, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "province", value = "省份", required = false, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "jobId", value = "职位id", required = false, dataType = "long", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "startTime", value = "招聘开始日期", required = false, dataType = "", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "endTime", value = "招聘结束日期", required = false, dataType = "date-time", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "workingHours", value = "工作时间", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "contactName", value = "联系人姓名", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "contactPhone", value = "联系方式", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "description", value = "详细描述", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "job", value = "工作", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "num", value = "需要人数", required = true, dataType = "long", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "salary", value = "工资", required = true, dataType = "srting", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "status", value = "状态", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "auditStatus", value = "审核状态", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "title", value = "招聘标题", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "welfare", value = "福利", required = true, dataType = "string", paramType = "query", defaultValue = ""),
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 403, message = "资源不可用"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Employment employment){
        return MessageUtil.success(employmentService.saveOrUpdate(employment));
    }
    @ApiOperation(value = "根据id删除招聘信息", notes = "")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "id", required = false,
//                    dataType = "string", paramType = "path", defaultValue = "1")
//    })
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
        employmentService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "根据职位查找招聘信息", notes = "")
    @GetMapping("findByJob")
    public Message findByJob(String job){
        return MessageUtil.success(employmentService.findByJob(job));
    }

    @ApiOperation(value = "根据城市查找招聘信息", notes = "")
    @GetMapping("findByCity")
    public Message findByCity(String city){
        return MessageUtil.success(employmentService.findByCity(city));
    }

    @ApiOperation(value = "根据招聘标题查找招聘信息(模糊查询)", notes = "")
    @GetMapping("findByTitle")
    public Message findByTitle(String title){
        return MessageUtil.success(employmentService.findByTitle(title));
    }

    @ApiOperation(value = "根据福利查找招聘信息(模糊查询)", notes = "")
    @GetMapping("findByWelfare")
    public Message findByWelfare(String welfare){
        return MessageUtil.success(employmentService.findByWelfare(welfare));
    }
}
