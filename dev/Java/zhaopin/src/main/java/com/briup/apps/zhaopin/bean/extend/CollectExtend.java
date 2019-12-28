package com.briup.apps.zhaopin.bean.extend;

import com.briup.apps.zhaopin.bean.Collect;
import com.briup.apps.zhaopin.bean.Employment;
import com.briup.apps.zhaopin.bean.Jobhunter;

/**
 * @program: CollectExtend
 * @description: 级联查询招聘信息和求职者信息
 * @author: Ricardo
 * @create: 2019/9/30 10:31
 */
public class CollectExtend extends Collect {
    private Employment employment;
    private Jobhunter  jobhunter;

    public Jobhunter getJobhunter() {
        return jobhunter;
    }

    public void setJobhunter(Jobhunter jobhunter) {
        this.jobhunter = jobhunter;
    }

    public Employment getEmployment() {
        return employment;
    }

    public void setEmployment(Employment employment) {
        this.employment = employment;
    }
}