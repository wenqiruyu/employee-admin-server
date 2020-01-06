package com.employee.admin.scheduled;

import com.alibaba.fastjson.JSON;
import com.employee.admin.entity.WorkAttendance;
import com.employee.admin.mapper.IStaffDetailMapper;
import com.employee.admin.service.IWorkAttendanceService;
import com.employee.admin.vo.StaffDetailAllUserVO;
import com.employee.admin.vo.WorkAttendanceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
//    @Scheduled(cron = "0 9 15 * * ?")
    public void toAddWorkAttendance() throws Exception {

        logger.info("WorkAttendanceScheduled toAddWorkAttendance start ...");
        try {
            List<StaffDetailAllUserVO> allUserId = staffDetailMapper.getAllUserId();
            String json = JSON.toJSONString(allUserId);
            List<WorkAttendance> workAttendances = JSON.parseArray(json, WorkAttendance.class);
            logger.info("WorkAttendanceScheduled addAllStaffWages start ...param:{}", workAttendances);
            workAttendanceService.addAllStaffWages(workAttendances);
            logger.info("WorkAttendanceScheduled toAddWorkAttendance end ...");
        } catch (Exception e) {
            logger.error("WorkAttendanceScheduled toAddWorkAttendance error ... message:{}", e);
        }
    }

    /**
     * 每天的06：00进行查询正常工作日的缺勤员工
     *
     * @param
     * @return void
     * @author yingx
     * @date 2020/1/3
     */
    public void toGetWorkAttendance() throws Exception {

        // 正常考勤的员工进行设置正常考勤的标识
        logger.info("WorkAttendanceScheduled toGetWorkAttendance start ...");
        try {
            // 获取前一天的员工考勤信息
            String startTime = "09:00:00";
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalDateTime localDateTime = LocalDateTime.parse(startTime, dateTimeFormatter);
            List<WorkAttendanceVO> allWorkAttendance = workAttendanceService.getAllWorkAttendance();
            for (WorkAttendanceVO workAttendanceVO : allWorkAttendance) {
                if (workAttendanceVO.getStartTime() != null) {
                    String format = workAttendanceVO.getStartTime().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                    /*if (localDateTime.isBefore()) {

                    }*/
                } else {
                    workAttendanceVO.setAbsenceDutyFlag(1);
                }
            }
            logger.info("WorkAttendanceScheduled toAddWorkAttendance end ...");
        } catch (Exception e) {
            logger.error("WorkAttendanceScheduled toAddWorkAttendance error ... message:{}", e);
        }
        // 异常考勤设置异常标识
    }
}
