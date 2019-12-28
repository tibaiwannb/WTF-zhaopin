package com.briup.apps.zhaopin.web.controller;

import com.briup.apps.zhaopin.bean.EmploymentJobhunter;
import com.briup.apps.zhaopin.service.EmploymentJobhunterService;
import com.briup.apps.zhaopin.utils.Message;
import com.briup.apps.zhaopin.utils.MessageUtil;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: EmploymentJobhunterController
 * @description: 求职信息
 * @author: CC
 * @create: 2019/9/19 21:27
 */
@Api(description = "求职信息相关接口")
@RestController
@RequestMapping("/EmploymentJobhunter")
public class EmploymentJobhunterController {
    @Resource
    private EmploymentJobhunterService employmentJobhunterService;
    @ApiOperation(value = "根据id查询求职信息", notes = "精确查询,最常规的方式,支持GET方式")
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
        return MessageUtil.success(employmentJobhunterService.findById(id));
    }
    @ApiOperation(value = "新增或修改求职信息", notes = "不填ID为新增,添加ID为修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = false, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "jobhunterId", value = "求职者id", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "employmentId", value = "招聘信息id", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "askTime", value = "求职时间", required = false, dataType = "date-time", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "remark", value = "标记", required = true, dataType = "string", paramType = "query", defaultValue = ""),
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
    public Message saveOrUpdate(EmploymentJobhunter employmentJobhunter){
        return MessageUtil.success(employmentJobhunterService.saveOrUpdate(employmentJobhunter));
    }
    @ApiOperation(value = "查询所有求职信息", notes = "")
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
        return MessageUtil.success(employmentJobhunterService.findAll());
    }
    @ApiOperation(value = "根据id删除求职信息", notes = "")
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
        employmentJobhunterService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
    @ApiOperation(value = "查询所有求职信息(扩展)", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 403, message = "资源不可用"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    @GetMapping("findAllWithJobhAndEmpl")
    public Message findAllWithJobhAndEmpl() {
        return MessageUtil.success(employmentJobhunterService.findAllWithJobhAndEmpl());
    }
}
