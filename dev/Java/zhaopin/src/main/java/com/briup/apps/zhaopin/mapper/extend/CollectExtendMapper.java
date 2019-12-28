package com.briup.apps.zhaopin.mapper.extend;

import com.briup.apps.zhaopin.bean.extend.CollectExtend;

import java.util.List;

public interface CollectExtendMapper {

    List<CollectExtend> selectAllWithEmpAndJob();
}
