package com.briup.apps.zhaopin.web.controller;

import com.briup.apps.zhaopin.bean.Business;
import com.briup.apps.zhaopin.service.BusinessService;
import com.briup.apps.zhaopin.utils.Message;
import com.briup.apps.zhaopin.utils.MessageUtil;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: BusinessController
 * @description: 商家
 * @author: CC
 * @create: 2019/9/19 21:25
 */
@Api(description = "商家相关接口")
@RestController
@RequestMapping("/Business")
public class BusinessController {
    @Resource
    private BusinessService businessService;
  @ApiOperation(value = "根据id查询商家", notes = "精确查询,最常规的方式,支持GET方式")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "id", required = false,
//                    dataType = "bigint", paramType = "path", defaultValue = "1")
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
        return MessageUtil.success(businessService.findById(id));
    }
    @ApiOperation(value = "查询所有商家", notes = "")
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
        return MessageUtil.success(businessService.findAll());
    }
    @ApiOperation(value = "新增或修改商家信息", notes = "不填ID为新增,添加ID为修改")
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
            @ApiImplicitParam(name = "contactName", value = "联系人", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "contactPhone", value = "联系方式", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "industry", value = "行业类型", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "location", value = "地址", required = false, dataType = "string", paramType = "query", defaultValue = ""),
                @ApiImplicitParam(name = "province", value = "省份", required = false, dataType = "string", paramType = "query", defaultValue = ""),
                @ApiImplicitParam(name = "city", value = "城市", required = false, dataType = "string", paramType = "query", defaultValue = ""),
                @ApiImplicitParam(name = "name", value = "商家名称", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "scale", value = "公司规模", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "establishedTime", value = "成立时间", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "registeredCapital", value = "注册资本", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "description", value = "详细信息", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "businessLicense", value = "营业执照", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "status", value = "状态(审核通过/拒绝/待审核)", required = true, dataType = "string", paramType = "query", defaultValue = ""),
    })
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Business business){
        return MessageUtil.success(businessService.saveOrUpdate(business));
    }
    @ApiOperation(value = "根据id删除商家", notes = "")
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
        businessService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
    @ApiOperation(value = "根据位置查找商家", notes = "")
    @GetMapping("findByLocation")
    public Message findByLocation(String location){
        return MessageUtil.success(businessService.findByLocation(location));
    }

    @ApiOperation(value = "根据省份查找商家", notes = "")
    @GetMapping("findByProvince")
    public Message findByProvince(String province){
        return MessageUtil.success(businessService.findByProvince(province));
    }

    @ApiOperation(value = "根据城市查找商家", notes = "")
    @GetMapping("findByCity")
    public Message findByCity(String city){
        return MessageUtil.success(businessService.findByCity(city));
    }
    @ApiOperation(value = "根据行业类型查找商家", notes = "")

    @GetMapping("findByIndustry")
    public Message findByIndustry(String industry){
        return MessageUtil.success(businessService.findByIndustry(industry));
    }
    @ApiOperation(value = "根据规模查找商家", notes = "")

    @GetMapping("findByScale")
    public Message findByScale(String scale){
        return MessageUtil.success(businessService.findByScale(scale));
    }

}
