package com.employee.admin.interceptor;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 项目名称：springboot-multiple-datasource
 * 类名称：CustomMetaObjectHandler
 * 类描述：保存或更新数据时自动添加修改时间、人，创建时间、人
 * 创建人：yingx
 * 创建时间： 2019/10/21
 * 修改人：yingx
 * 修改时间： 2019/10/21
 * 修改备注：
 */
@Component
public class CustomMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {

        System.out.println("的发生范德萨打法师的地方");
        // 添加时自动填充公共对象的信息
        setInsertFieldValByName("lastUpdateBy", "admin", metaObject);
        setInsertFieldValByName("createBy", "admin", metaObject);
        setInsertFieldValByName("createTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        // 修改时自动填充公共对象的信息
        setFieldValByName("updateTime", new Date(), metaObject);
        setUpdateFieldValByName("lastUpdateBy", "admin", metaObject);
    }
}