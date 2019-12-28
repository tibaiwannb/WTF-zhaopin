package com.briup.apps.zhaopin.web.controller;

import com.briup.apps.zhaopin.bean.CustomerService;
import com.briup.apps.zhaopin.service.CustomerServiceService;
import com.briup.apps.zhaopin.utils.Message;
import com.briup.apps.zhaopin.utils.MessageUtil;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: CustomerService
 * @description: 客户服务
 * @author: CC
 * @create: 2019/9/19 21:26
 */
@Api(description ="客服相关接口")
@RestController
@RequestMapping("/CustomerService")
public class CustomerServiceController {
    @Resource
    private CustomerServiceService customerServiceService;
    @ApiOperation(value = "根据id查询客服", notes = "精确查询,最常规的方式,支持GET方式")
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
        return MessageUtil.success(customerServiceService.findById(id));
    }
    @ApiOperation(value = "查询所有客服", notes = "")
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
        return MessageUtil.success(customerServiceService.findAll());
    }
    @ApiOperation(value = "新增或修改客服信息", notes = "不填ID为新增,添加ID为修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = false, dataType = "long", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "gender", value = "性别", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "realname", value = "真实姓名", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "status", value = "状态(在线/离线)", required = true, dataType = "string", paramType = "query", defaultValue = ""),
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
    public Message saveOrUpdate(CustomerService customerService){
        return MessageUtil.success(customerServiceService.saveOrUpdate(customerService));
    }
    @ApiOperation(value = "根据id删除客服", notes = "")
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
        customerServiceService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "根据性别查找客服", notes = "")
    @GetMapping("findByGender")
    public Message findByGender(String gender){
        return MessageUtil.success(customerServiceService.findByGender(gender));
    }
    @ApiOperation(value = "根据状态查找客服", notes = "")

    @GetMapping("findByEducation")
    public Message findByEducation(String status){
        return MessageUtil.success(customerServiceService.findByStatus(status));
    }
    @ApiOperation(value = "根据用户名查找客服", notes = "")
    @GetMapping("findByUsername")
    public Message findByUsername(String username){
        return MessageUtil.success(customerServiceService.findByUsername(username));
    }
}
