package com.employee.admin.vo;

/**
 * 项目名称：employee-admin-server
 * 类名称：UpdateUserFaceVO
 * 类描述：TDD
 * 创建人：yingx
 * 创建时间： 2020/5/17
 * 修改人：yingx
 * 修改时间： 2020/5/17
 * 修改备注：
 */
public class UpdateUserFaceVO {

    private String destFileName;

    private String fileName;

    private String username;

    public String getDestFileName() {
        return destFileName;
    }

    public void setDestFileName(String destFileName) {
        this.destFileName = destFileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UpdateUserFaceVO{" +
                "destFileName='" + destFileName + '\'' +
                ", fileName='" + fileName + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
