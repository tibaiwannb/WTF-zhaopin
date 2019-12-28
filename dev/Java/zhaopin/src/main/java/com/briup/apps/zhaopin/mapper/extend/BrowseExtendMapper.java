package com.briup.apps.zhaopin.mapper.extend;

import com.briup.apps.zhaopin.bean.extend.BrowseExtend;

import java.util.List;

public interface BrowseExtendMapper {
    List<BrowseExtend> selectAllWithEmpAndJob();
}
