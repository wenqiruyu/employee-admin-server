package com.employee.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.employee.admin.entity.EmailVerifyCode;
import com.employee.admin.entity.StaffDetail;
import com.employee.admin.entity.StaffRole;
import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.enums.ResultEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.mapper.IEmailVerifyCodeMapper;
import com.employee.admin.mapper.IStaffDetailMapper;
import com.employee.admin.service.IStaffBaseService;
import com.employee.admin.service.IUserService;
import com.employee.admin.service.IWorkAttendanceService;
import com.employee.admin.utils.IdWorkerUtils;
import com.employee.admin.vo.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * 项目名称：employee-admin-server
 * 类名称：UserController
 * 类描述：处理针对用户的逻辑操作
 * 创建人：yingx
 * 创建时间： 2019/12/24
 * 修改人：yingx
 * 修改时间： 2019/12/24
 * 修改备注：
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${idWorker.workerId}")
    private Integer workerId;

    @Value("${idWorker.datacenterId}")
    private Integer datacenterId;

    @Autowired
    private IUserService userService;

    @Autowired
    private IStaffDetailMapper staffDetailMapper;

    @Autowired
    private IStaffBaseService staffBaseService;

    @Autowired
    private IEmailVerifyCodeMapper emailVerifyCodeMapper;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private IWorkAttendanceService workAttendanceService;

    /**
     * 用户登录后台管理系统
     *
     * @param loginUserVO
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2019/12/24
     */
    @PostMapping("/login")
    @CrossOrigin
    public ResultVO userLogin(@RequestBody LoginUserVO loginUserVO) {

        logger.info("UserController login start ... Username:{}, Password:{}",
                loginUserVO.getUsername(), StringUtils.isBlank(loginUserVO.getPassword()) ? null : "******");
        if (StringUtils.isBlank(loginUserVO.getUsername()) || StringUtils.isBlank(loginUserVO.getPassword())) {
            throw new ExtenException("login", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        ResultVO resultVO = userService.userLogin(loginUserVO);
        logger.info("UserController login end ...");
        return resultVO;
    }

    /**
     * 用户登录后台管理系统
     *
     * @param updateUserFaceVO
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2019/12/24
     */
    @PostMapping("/updateUserFace")
    @CrossOrigin
    public ResultVO updateUserFace(@RequestBody UpdateUserFaceVO updateUserFaceVO) {

        logger.info("UserController updateUserFace start ... updateUserFace:{}", updateUserFaceVO);

        updateUserFaceVO.setDestFileName("/img/" + updateUserFaceVO.getFileName());

        ResultVO resultVO = userService.updateUserFace(updateUserFaceVO);

        logger.info("UserController updateUserFace end ...");
        return resultVO;
    }

    /**
     * 用户登录后台管理系统
     *
     * @param file
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2019/12/24
     */
    @PostMapping("/uploadImg")
    @CrossOrigin
    public ResultVO uploadImg(HttpServletRequest req, @RequestParam("file") MultipartFile file) {

        logger.info("UserController uploadImg start ... file:{}", file);

        HashMap<String, String> map = new HashMap<>();
        try {
            //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            //3.通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
            String destFileName = "C:\\Users\\22341\\Desktop\\胖子\\employee-admin-element\\src\\assets\\img"+ File.separator + fileName;

            logger.info("图片上传的路径：{}, 图片名称为：{}", destFileName, fileName);
            //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            //5.把浏览器上传的文件复制到希望的位置
            file.transferTo(destFile);

            // 修改用户的头像路径
            map.put("fileName", fileName);
            map.put("destFileName", destFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        logger.info("UserController login end ...");
        return new ResultVO(map);
    }

    /**
     * 用户注册账号
     *
     * @param registerUserVO
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2019/12/24
     */
    @PostMapping("/register")
    @CrossOrigin
    public ResultVO userRegister(@RequestBody RegisterUserVO registerUserVO) {

        logger.info("UserController register start ... Username:{}, Password:{}",
                registerUserVO.getUsername(), StringUtils.isBlank(registerUserVO.getPassword()) ? null : "******");
        if (StringUtils.isBlank(registerUserVO.getUsername()) || StringUtils.isBlank(registerUserVO.getPassword())) {
            throw new ExtenException("register", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        // 用户注册需将用户密码进行加密
        registerUserVO.setPassword(new BCryptPasswordEncoder().encode(registerUserVO.getPassword()));
        QueryUserVO queryUserVO = new QueryUserVO();
        queryUserVO.setUsername(registerUserVO.getUsername());
        // 排除昵称同名的情况
        StaffDetailVO user = userService.getUser(queryUserVO);
        if (user == null) {
            // 生成userId
            long userId = new IdWorkerUtils(workerId, datacenterId).nextId();
            registerUserVO.setUserId(userId);
            userService.userRegister(registerUserVO);
            // 注册成功添加用户权限 注册用户都默认为普通用户
            StaffRole staffRole = new StaffRole();
            staffRole.setUserId(userId);
            staffRole.setRoleId("ROLE003");
            userService.addStaffRole(staffRole);
            logger.info("UserController register end ... userId:{}", userId);
            return new ResultVO();
        } else {
            logger.info("UserController register end ... result:{}", "注册失败,用户名已存在");
            List<ErrorDataVO> errorList = new ArrayList<>();
            errorList.add(new ErrorDataVO("name", "用户名已存在"));
            throw new ExtenException("register", ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMsg(), errorList);
        }
    }


    /**
     * 用户进行修改密码操作
     *
     * @param updateUserPwdVO 修改密码接口vo
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/3/22
     */
    @PostMapping("/updatePwd")
    @CrossOrigin
    public ResultVO updateUserPwd(@RequestBody UpdateUserPwdVO updateUserPwdVO) {

        logger.info("UserController updateUserPwd start ... UserId:{}, Username:{}, password:{}, newPassword:{}",
                updateUserPwdVO.getUserId(), updateUserPwdVO.getUsername(),
                StringUtils.isBlank(updateUserPwdVO.getPassword()) ? null : "******",
                StringUtils.isBlank(updateUserPwdVO.getNewPassword()) ? null : "******");
        if (StringUtils.isBlank(updateUserPwdVO.getUserId()) && StringUtils.isBlank(updateUserPwdVO.getUsername())
                && StringUtils.isBlank(updateUserPwdVO.getPassword()) && StringUtils.isBlank(updateUserPwdVO.getNewPassword())) {
            throw new ExtenException("updateUserPwd", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        // 判断用户输入密码是否正确
        LoginUserVO loginUserVO = new LoginUserVO();
        loginUserVO.setUsername(updateUserPwdVO.getUsername());
        loginUserVO.setPassword(updateUserPwdVO.getPassword());
        userService.userLogin(loginUserVO);
        // 处理不传userId的情况
        if (updateUserPwdVO.getUserId() == null) {
            StaffDetail staffDetail = new StaffDetail();
            staffDetail.setUsername(updateUserPwdVO.getUsername());
            // 根据用户名查找用户信息
            StaffDetailVO staffDetailResult = staffDetailMapper.getStaffDetail(staffDetail);
            updateUserPwdVO.setUserId(staffDetailResult.getUserId());
        }
        // 进行密码修改操作
        StaffDetailVO staffDetailVO = new StaffDetailVO();
        staffDetailVO.setUserId(updateUserPwdVO.getUserId());
        staffDetailVO.setPassword(new BCryptPasswordEncoder().encode(updateUserPwdVO.getNewPassword()));
        userService.updateUser(staffDetailVO);
        logger.info("UserController updateUserPwd end ...");
        return new ResultVO();
    }

    /**
     * 用户进行重置密码操作
     *
     * @param updateUserPwdVO 修改密码接口vo
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/3/22
     */
    @PostMapping("/restPassword")
    @CrossOrigin
    public ResultVO restPassword(@RequestBody UpdateUserPwdVO updateUserPwdVO) {

        logger.info("UserController restPassword start ... email:{}, newPassword:{}",
                updateUserPwdVO.getEmail(), StringUtils.isBlank(updateUserPwdVO.getNewPassword()) ? null : "******");
        if (StringUtils.isBlank(updateUserPwdVO.getEmail()) || StringUtils.isBlank(updateUserPwdVO.getNewPassword())) {
            throw new ExtenException("restPwd", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }

        updateUserPwdVO.setPassword(new BCryptPasswordEncoder().encode(updateUserPwdVO.getNewPassword()));

        ResultVO resultVO = userService.updateUserByEmail(updateUserPwdVO);
        logger.info("UserController restPassword end ...");
        return resultVO;
    }

    /**
     * 通过用户名、用户id进行用户信息查询
     *
     * @param queryUserVO
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2019/12/25
     */
    @PostMapping("/getUser")
    @CrossOrigin
    public ResultVO getUserInfo(@RequestBody QueryUserVO queryUserVO) {

        logger.info("UserController getUserInfo start ... UserId:{}, Username:{}",
                queryUserVO.getUserId(), queryUserVO.getUsername());
        if (StringUtils.isBlank(queryUserVO.getUserId() + "") && StringUtils.isBlank(queryUserVO.getUsername())) {
            throw new ExtenException("getUserInfo", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        StaffDetailVO user = userService.getUser(queryUserVO);
        if (user != null) {
            logger.info("UserController getUserInfo end ... StaffDetailVO:{}", user);
            return new ResultVO(user);
        } else {
            logger.info("UserController getUserInfo end ... result:{}", "查找用户信息失败，该用户信息不存在");
            return new ResultVO(ResultEnum.UNKNOWN_USER_INFO.getCode(), ResultEnum.UNKNOWN_USER_INFO.getMsg());
        }
    }

    /**
     * 通过用户名、用户id进行员工信息查询
     *
     * @param queryUserVO
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2019/12/25
     */
    @PostMapping("/getEmp")
    @CrossOrigin
    public ResultVO getEmpInfo(@RequestBody QueryUserVO queryUserVO) {

        logger.info("UserController getEmpInfo start ... UserId:{}, Username:{}",
                queryUserVO.getUserId(), queryUserVO.getUsername());
        if (StringUtils.isBlank(queryUserVO.getUserId() + "") && StringUtils.isBlank(queryUserVO.getUsername())) {
            throw new ExtenException("getEmpInfo", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        // 处理不传userId的情况
        if (queryUserVO.getUserId() == null) {
            StaffDetail staffDetail = new StaffDetail();
            staffDetail.setUsername(queryUserVO.getUsername());
            // 根据用户名查找用户信息
            StaffDetailVO staffDetailResult = staffDetailMapper.getStaffDetail(staffDetail);
            queryUserVO.setUserId(Long.parseLong(staffDetailResult.getUserId()));
        }
        StaffBaseVO staffBaseByUser = staffBaseService.getStaffBaseByUser(queryUserVO);
        if (staffBaseByUser != null) {
            logger.info("UserController getEmpInfo end ... StaffDetailVO:{}", staffBaseByUser);
            return new ResultVO(staffBaseByUser);
        } else {
            logger.info("UserController getEmpInfo end ... result:{}", "查找用户信息失败，该用户信息不存在");
            return new ResultVO(ResultEnum.UNKNOWN_USER_INFO.getCode(), ResultEnum.UNKNOWN_USER_INFO.getMsg());
        }
    }

    /**
     * 通过员工号进行用户信息查询
     *
     * @param empParamVO
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2019/12/25
     */
    @PostMapping("/getUser/employee")
    @CrossOrigin
    public ResultVO getUserInfoByEmpId(@RequestBody EmpParamVO empParamVO) {

        logger.info("UserController getUserInfoByEmpId start ... EmpId:{}", empParamVO.getEmpId());
        if (StringUtils.isBlank(empParamVO.getEmpId())) {
            throw new ExtenException("getUserInfoByEmpId", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        StaffDetailVO user = userService.getUserByEmpId(empParamVO.getEmpId());
        if (user != null) {
            logger.info("UserController getUserInfoByEmpId end ... StaffDetailVO:{}", user);
            return new ResultVO(user);
        } else {
            logger.info("UserController getUserInfoByEmpId end ... result:{}", "查找用户信息失败，该用户信息不存在");
            return new ResultVO(ResultEnum.UNKNOWN_USER_INFO.getCode(), ResultEnum.UNKNOWN_USER_INFO.getMsg());
        }
    }

    /**
     * 分页查询全部用户信息
     *
     * @param pageVO
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2019/12/25
     */
    @PostMapping("/getAllUser")
    @CrossOrigin
    public ResultVO getAllUser(@RequestBody PageVO pageVO) {

        logger.info("UserController getAllUser start ...page:{},pageSize:{}", pageVO.getPage(), pageVO.getPageSize());
        List<AllStaffDetailVO> records = null;
        try {
            IPage<AllStaffDetailVO> allUser = userService.getAllUserPage(new AllStaffDetailVO(), pageVO.getPage(), pageVO.getPageSize());
            records = allUser.getRecords();
        } catch (Exception e) {
            logger.error("UserController getAllUser error ...", e);
            throw new ExtenException("getAllUser", ExceptionEnum.UNEXPECTED_ERROR.getCode(), ExceptionEnum.UNEXPECTED_ERROR.getMessage());
        }
        logger.info("VenusUserController getAllUser end ...result:{}", records);
        return new ResultVO(records);
    }

    /**
     * 分页查询全部用户信息
     *
     * @param map
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2019/12/25
     */
    @PostMapping("/getUserByEmail")
    @CrossOrigin
    public ResultVO getUserByEmail(@RequestBody HashMap<String, String> map) {

        logger.info("UserController getUserByEmail start ...email:{}", map.get("email"));

        ResultVO userByEmail = userService.getUserByEmail(map.get("email"));

        logger.info("VenusUserController getUserByEmail end ...result:{}", userByEmail.getData());
        return userByEmail;
    }

    /**
     * 分页查询全部用户信息
     *
     * @param pageVO
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2019/12/25
     */
    @PostMapping("/getUserByDept")
    @CrossOrigin
    public ResultVO getUserByDept(@RequestBody DeptUserPageVO pageVO) {

        logger.info("UserController getUserByDept start ...page:{},pageSize:{}", pageVO.getPage(), pageVO.getPageSize());
        List<AllStaffDetailVO> records;
        try {
            IPage<AllStaffDetailVO> allUser = userService.getUserByDept(pageVO.getDeptName(), pageVO.getPage(), pageVO.getPageSize());
            records = allUser.getRecords();
        } catch (Exception e) {
            logger.error("UserController getAllUser error ...", e);
            throw new ExtenException("getAllUser", ExceptionEnum.UNEXPECTED_ERROR.getCode(), ExceptionEnum.UNEXPECTED_ERROR.getMessage());
        }
        logger.info("VenusUserController getAllUser end ...result:{}", records);
        return new ResultVO(records);
    }


    /**
      * 员工离职
      *
      * @param
      * @return com.employee.admin.vo.ResultVO
      * @author yingx
      * @date 2020/5/19
     */
    @PostMapping("/deleteUser")
    @CrossOrigin
    public ResultVO deleteUser(@RequestBody StaffUserVO staffUserVO) {

        logger.info("UserController deleteUser start ... empParamVO:{}", staffUserVO);
        if (staffUserVO == null || StringUtils.isBlank(staffUserVO.getEmpId()) || staffUserVO.getUserId() == null) {
            throw new ExtenException("deleteUser", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        ResultVO resultVO = userService.deleteUser(staffUserVO);
        return resultVO;
    }

    @PostMapping("/updateUser")
    @CrossOrigin
    public ResultVO updateUser(@RequestBody StaffDetailVO staffDetailVO) {

        logger.info("UserController updateUser start ... StaffDetailVO:{}", staffDetailVO);
        if (staffDetailVO == null) {
            throw new ExtenException("updateUser", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        userService.updateUser(staffDetailVO);
        return new ResultVO();
    }

    public ResultVO logout() {

        return null;
    }

    /**
     * 发送邮箱验证码
     *
     * @param getEmailVO
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/4/13
     */
    @PostMapping("/getEmail")
    @CrossOrigin
    public ResultVO getEmail(@RequestBody GetEmailVO getEmailVO) {

        logger.info("UserController getEmail start ... getEmailVO:{}", getEmailVO.getEmail());
        if (getEmailVO.getEmail() == null) {
            throw new ExtenException("updateUser", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        ResultVO resultVO = userService.getEmail(getEmailVO.getEmail());
        return resultVO;
    }


    /**
      * 发送邮箱验证码
      *
      * @param sendVerifyEmailParam
      * @return com.employee.admin.vo.ResultVO
      * @author yingx
      * @date 2020/4/13
     */
    @PostMapping("/sendVerifyEmail")
    @CrossOrigin
    public ResultVO sendVerifyEmail(@RequestBody SendVerifyEmailParam sendVerifyEmailParam) {

        logger.info("UserController sendVerifyEmail start ... sendVerifyEmailParam:{}", sendVerifyEmailParam);
        if (sendVerifyEmailParam == null) {
            throw new ExtenException("updateUser", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        try {
            String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
            String emailMsg = "你的邮件验证码为 " + verifyCode + ",请您妥善保管，有效期为五分钟！请在有效期中使用。";
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = null;
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom("yxwenqiyu@163.com");
            mimeMessageHelper.setTo(sendVerifyEmailParam.getEmail());
            mimeMessageHelper.setCc(sendVerifyEmailParam.getEmail());
            mimeMessageHelper.setSubject("企业员工管理平台邮件验证码");
            mimeMessageHelper.setText(emailMsg, true);
            mailSender.send(mimeMessage);

            // 保存记录发送的验证码
            EmailVerifyCode emailVerifyCode = new EmailVerifyCode();
            emailVerifyCode.setEmail(sendVerifyEmailParam.getEmail());
            emailVerifyCode.setEmailMsg(emailMsg);
            emailVerifyCode.setStartTime(System.currentTimeMillis());
            emailVerifyCode.setVerifyCode(verifyCode);

            // 先删除原来的
            emailVerifyCodeMapper.updateEmailVerifyCodeStatus(emailVerifyCode);
            // 新增
            emailVerifyCodeMapper.insertEmailVerifyCode(emailVerifyCode);

            return new ResultVO();
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new ExtenException("updateUser", ResultEnum.SEND_VERIFY_ERROR.getCode(),
                    ResultEnum.SEND_VERIFY_ERROR.getMsg());
        }
    }

    /**
     * 验证邮箱的验证码
     *
     * @param emailVerifyCode
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/4/13
     */
    @PostMapping("/verifyEmail")
    @CrossOrigin
    public ResultVO verifyEmail(@RequestBody EmailVerifyCode emailVerifyCode) {

        logger.info("UserController verifyEmail start ... sendVerifyEmailParam:{}", emailVerifyCode);
        if (emailVerifyCode.getEmail() == null || emailVerifyCode.getVerifyCode() == null) {
            throw new ExtenException("updateUser", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        EmailVerifyCode emailVerify = emailVerifyCodeMapper.getEmailVerifyCode(emailVerifyCode.getEmail());
        logger.info("emailVerify:{}", emailVerify);
        // 判断是否超时
        long time = System.currentTimeMillis() - emailVerify.getStartTime();
        long endTime = time /1000 / 60;

        if(endTime < 5){
            if(emailVerifyCode.getVerifyCode().equals(emailVerify.getVerifyCode())){
                // 读取成功使验证码失效
                emailVerifyCodeMapper.updateEmailVerifyCodeStatus(emailVerifyCode);
                return new ResultVO();
            }
            return new ResultVO(ResultEnum.SEND_VERIFY_UNTRUE.getCode(), ResultEnum.SEND_VERIFY_UNTRUE.getMsg());
        }else {
            return new ResultVO(ResultEnum.SEND_VERIFY_EXPIRED.getCode(), ResultEnum.SEND_VERIFY_EXPIRED.getMsg());
        }
    }

    /**
     * 验证邮箱的验证码
     *
     * @param empParamVO
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/4/13
     */
    @PostMapping("/getUserByName")
    @CrossOrigin
    public ResultVO getUserByName(@RequestBody EmpParamVO empParamVO) {

        logger.info("UserController getUserByName start ... empName:{}", empParamVO.getEmpName());
        if (empParamVO.getEmpName() == null) {
            throw new ExtenException("updateUser", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }

        ResultVO userByName = userService.getUserByName(empParamVO.getEmpName());

        return userByName;
    }

    /**
     * 获取全部二级员工数据
     *
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/4/13
     */
    @PostMapping("/getAllSuperEmp")
    @CrossOrigin
    public ResultVO getAllSuperEmp() {

        logger.info("UserController getUserByName start ...");

        ResultVO userByName = userService.getAllSuperEmp();

        return userByName;
    }

    /**
     * 每天的06：00进行查询正常工作日的缺勤员工
     *
     * @param
     * @return void
     * @author yingx
     * @date 2020/1/3
     */
    @PostMapping("/toGetWorkAttendance")
    @CrossOrigin
    public void toGetWorkAttendance() throws Exception {

        // 正常考勤的员工进行设置正常考勤的标识
        logger.info("WorkAttendanceScheduled toGetWorkAttendance start ...");
        try {
            // 获取前一天的员工考勤信息
            String startTime = "09:00:00";
            String endTime = "18:00:00";
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            LocalTime localDateTimeStart = LocalTime.parse("09:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));
            LocalTime localDateTimeEnd = LocalTime.parse("09:00:00", DateTimeFormatter.ofPattern("HH:mm:ss"));

            String format = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now().plusDays(-1));

            logger.info("adsfasdf" + format);

            List<WorkAttendanceVO> allWorkAttendance = workAttendanceService.getAllWorkAttendanceByDate(format);
            for (WorkAttendanceVO workAttendanceVO : allWorkAttendance) {
                if (workAttendanceVO.getStartTime() != null) {
                    // 用户签到时间是否在九点之前
                    if (localDateTimeStart.isBefore(LocalTime.parse(workAttendanceVO.getStartTime(), dateTimeFormatter))) {
                        if (workAttendanceVO.getEndTime() != null) {
                            if (localDateTimeEnd.isBefore(LocalTime.parse(workAttendanceVO.getStartTime(), dateTimeFormatter))) {
                                // 迟到加早退定为旷工
                                workAttendanceVO.setAbsenceDutyFlag(3);
                            }else{
                                workAttendanceVO.setAbsenceDutyFlag(0);
                            }
                        }else{
                            workAttendanceVO.setAbsenceDutyFlag(2);
                        }
                    }else{
                        if (workAttendanceVO.getEndTime() != null) {
                            if (localDateTimeEnd.isBefore(LocalTime.parse(workAttendanceVO.getStartTime(), dateTimeFormatter))) {
                                // 迟到加早退定为旷工
                                workAttendanceVO.setAbsenceDutyFlag(1);
                            }else{
                                workAttendanceVO.setAbsenceDutyFlag(4);
                            }
                        }else{
                            workAttendanceVO.setAbsenceDutyFlag(1);
                        }
                    }
                } else {
                    workAttendanceVO.setAbsenceDutyFlag(1);
                }
            }

            workAttendanceService.updateAbsenceDuty(allWorkAttendance);

            logger.info("WorkAttendanceScheduled toAddWorkAttendance end ...");
        } catch (Exception e) {
            logger.error("WorkAttendanceScheduled toAddWorkAttendance error ... message:{}", e);
        }
    }
}
