package com.briup.apps.zhaopin.bean.extend;

import com.briup.apps.zhaopin.bean.Employment;
import com.briup.apps.zhaopin.bean.EmploymentJobhunter;
import com.briup.apps.zhaopin.bean.Jobhunter;

/**
 * @program: EmploymentJobhunter
 * @description: 求职信息
 * @author: CC
 * @create: 2019/9/27 9:13
 */
public class EmploymentJobhunterExtend extends EmploymentJobhunter {

    private Employment employment;
    public Employment getEmployment() {
        return employment;
    }
    public void setEmployment(Employment employment) {
        this.employment = employment;
    }

    private Jobhunter jobhunter;
    public Jobhunter getJobhunter() {
        return jobhunter;
    }
    public void setJobhunter(Jobhunter jobhunter) {
        this.jobhunter = jobhunter;
    }
}
