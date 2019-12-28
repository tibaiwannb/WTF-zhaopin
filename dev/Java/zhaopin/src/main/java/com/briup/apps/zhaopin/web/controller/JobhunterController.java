package com.briup.apps.zhaopin.web.controller;

import com.briup.apps.zhaopin.bean.Jobhunter;
import com.briup.apps.zhaopin.service.JobhunterService;
import com.briup.apps.zhaopin.utils.Message;
import com.briup.apps.zhaopin.utils.MessageUtil;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: JobhunterController
 * @description: 求职者
 * @author: CC
 * @create: 2019/9/19 21:26
 */

@RestController
@RequestMapping("/Jobhunter")
@Api(description = "求职者相关接口")
public class JobhunterController {
    @Resource
    private JobhunterService jobhunterService;

    @ApiOperation(value = "根据id查询求职者", notes = "精确查询,最常规的方式,支持GET方式")
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
        return MessageUtil.success(jobhunterService.findById(id));
    }
    @ApiOperation(value = "查询所有求职者接口", notes = "")
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
        return MessageUtil.success(jobhunterService.findAll());
    }
    @ApiOperation(value = "新增或修改求职者信息", notes = "不填ID为新增,添加ID为修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = false, dataType = "long", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "birth", value = "出生日期", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "currentStatus", value = "求职状态", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "education", value = "学历", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "gender", value = "性别", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "realname", value = "真实姓名", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "resume", value = "简历", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "telephone", value = "联系方式", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "workTime", value = "工作时间", required = true, dataType = "string", paramType = "query", defaultValue = ""),
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
    public Message saveOrUpdate(Jobhunter jobhunter){
        return MessageUtil.success(jobhunterService.saveOrUpdate(jobhunter));
    }
    @ApiOperation(value = "根据id删除求职者", notes = "")
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
        jobhunterService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "快速注册&报名", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = false, dataType = "long", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "employmentId", value = "employmentId", required = true, dataType = "long", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "birth", value = "出生日期", required = false, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "currentStatus", value = "求职状态", required = false, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "education", value = "学历", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "gender", value = "性别", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "password", value = "密码", required = false, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "realname", value = "真实姓名", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "resume", value = "简历", required = false, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "telephone", value = "联系方式", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "username", value = "用户名", required = false, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "workTime", value = "工作时间", required = false, dataType = "string", paramType = "query", defaultValue = ""),
    })
    @PostMapping("quickRegistration")
    public Message quickRegistration(Jobhunter jobhunter, Long employmentId){
        return MessageUtil.success(jobhunterService.quickRegistration(jobhunter,employmentId));
    }
    @ApiOperation(value = "根据性别查找求职者", notes = "")
    @GetMapping("findByGender")
    public Message findByGender(String gender){
        return MessageUtil.success(jobhunterService.findByGender(gender));
    }
    @ApiOperation(value = "根据学历查找求职者", notes = "")

    @GetMapping("findByEducation")
    public Message findByEducation(String education){
        return MessageUtil.success(jobhunterService.findByEducation(education));
    }
    @ApiOperation(value = "根据用户名查找求职者", notes = "")
    @GetMapping("findByUsername")
    public Message findByUsername(String username){
        return MessageUtil.success(jobhunterService.findByUsername(username));
    }
    @ApiOperation(value = "根据手机号查找求职者", notes = "")
    @GetMapping("findByTelephone")
    public Message findByTelephone(String telephone){
        return MessageUtil.success(jobhunterService.findByTelephone(telephone));
    }
}
