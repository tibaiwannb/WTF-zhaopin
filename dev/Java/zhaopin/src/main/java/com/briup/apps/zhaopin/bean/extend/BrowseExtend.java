package com.briup.apps.zhaopin.bean.extend;

import com.briup.apps.zhaopin.bean.Browse;
import com.briup.apps.zhaopin.bean.Employment;
import com.briup.apps.zhaopin.bean.Jobhunter;

/**
 * @Author Ricardo
 * @Description 级联查询招聘信息和求职者信息
 * @Date 2019/9/30 9:49
 **/
/*111111111111111111*/
public class BrowseExtend extends Browse {
    private Employment employment;
    private Jobhunter  jobhunter;

    public Employment getEmployment() {
        return employment;
    }
    public void setEmployment(Employment employment) {
        this.employment = employment;
    }

    public Jobhunter getJobhunter() {
        return jobhunter;
    }
    public void setJobhunter(Jobhunter jobhunter) {
        this.jobhunter = jobhunter;
    }
}
