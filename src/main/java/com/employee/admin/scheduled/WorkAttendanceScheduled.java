package com.employee.admin.scheduled;

import com.alibaba.fastjson.JSON;
import com.employee.admin.entity.WorkAttendance;
import com.employee.admin.mapper.IStaffDetailMapper;
import com.employee.admin.service.IWorkAttendanceService;
import com.employee.admin.vo.StaffDetailAllUserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：WorkAttendanceScheduled
 * 类描述：用户薪资定时任务类
 * 创建人：yingx
 * 创建时间： 2020/1/3
 * 修改人：yingx
 * 修改时间： 2020/1/3
 * 修改备注： 定时每天的00：00时刻进行全用户的
 */
@Component
public class WorkAttendanceScheduled {

    private static final Logger logger = LoggerFactory.getLogger(WorkAttendanceScheduled.class);

    @Autowired
    private IWorkAttendanceService workAttendanceService;

    @Autowired
    private IStaffDetailMapper staffDetailMapper;

    /**
     * 每天的00：00进行添加员工考勤信息
     *
     * @param
     * @return void
     * @author yingx
     * @date 2020/1/3
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void toAddWorkAttendance() throws Exception {

        logger.info("WorkAttendanceScheduled toAddWorkAttendance start ...");
        try {
            List<StaffDetailAllUserVO> allUserId = staffDetailMapper.getAllUserId();
            String json = JSON.toJSONString(allUserId);
            List<WorkAttendance> workAttendances = JSON.parseArray(json, WorkAttendance.class);
                workAttendanceService.addAllStaffWages(workAttendances);
                logger.info("WorkAttendanceScheduled toAddWorkAttendance end ...");
        } catch (Exception e) {
            logger.error("WorkAttendanceScheduled toAddWorkAttendance error ... message:{}", e);
        }
    }

    /**
     * 每天的06：00进行查询
     *
     * @param
     * @return void
     * @author yingx
     * @date 2020/1/3
     */
    public void toGetWorkAttendance() throws Exception {

    }
}
