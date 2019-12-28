package com.briup.apps.zhaopin.mapper.extend;

import com.briup.apps.zhaopin.bean.extend.JobsExtend;

import java.util.List;

public interface JobsExtendMapper {
    List<JobsExtend> selectByStatus(String states);
}
