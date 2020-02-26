package com.employee.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.employee.admin.entity.WorkAttendance;
import com.employee.admin.service.IWorkAttendanceService;
import com.employee.admin.service.impl.WorkAttendanceServiceImpl;
import com.employee.admin.vo.MonthWorkAttendanceParam;
import com.employee.admin.vo.MonthWorkAttendanceVO;
import com.employee.admin.vo.WorkAttendanceVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：WorkAttendanceTest
 * 类描述：TDD
 * 创建人：yingx
 * 创建时间： 2020/2/20
 * 修改人：yingx
 * 修改时间： 2020/2/20
 * 修改备注：
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {EmployeeAdminServerApplication.class, WorkAttendanceServiceImpl.class})
public class WorkAttendanceTest {

    @Autowired
    private IWorkAttendanceService workAttendanceService;

    @Test
    public void getWorkAttendance(){

        WorkAttendanceVO workAttendanceVO = new WorkAttendanceVO();
        workAttendanceVO.setEmpId("JXNC0001");
        IPage<WorkAttendanceVO> workAttendance = workAttendanceService.getUserWorkAttendance(workAttendanceVO, 1, 10);
        List<WorkAttendanceVO> records = workAttendance.getRecords();
        System.out.println(records);
    }

    @Test
    public void getMonthWorkAttendance(){

        MonthWorkAttendanceParam monthWorkAttendanceParam = new MonthWorkAttendanceParam();
        monthWorkAttendanceParam.setUsername("刘应兴");
        monthWorkAttendanceParam.setMonth(1);
        MonthWorkAttendanceVO monthWorkAttendance = workAttendanceService.getMonthWorkAttendance(monthWorkAttendanceParam);
        System.out.println(monthWorkAttendance);
    }
}
