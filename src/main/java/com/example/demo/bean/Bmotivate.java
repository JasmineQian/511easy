package com.example.demo.bean;

import java.io.Serializable;

public class Bmotivate implements Serializable {

    private long id;
    private int uid;
    private String code;
    private String description;
    private String begindate;
    private String enddate;
    private int deleted_flag;
    private String remark;
    private String creationdt;
    private String updatedt;
    private String creationuid;
    private String updateuid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBegindate() {
        return begindate;
    }

    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public int getDeleted_flag() {
        return deleted_flag;
    }

    public void setDeleted_flag(int deleted_flag) {
        this.deleted_flag = deleted_flag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreationdt() {
        return creationdt;
    }

    public void setCreationdt(String creationdt) {
        this.creationdt = creationdt;
    }

    public String getUpdatedt() {
        return updatedt;
    }

    public void setUpdatedt(String updatedt) {
        this.updatedt = updatedt;
    }

    public String getCreationuid() {
        return creationuid;
    }

    public void setCreationuid(String creationuid) {
        this.creationuid = creationuid;
    }

    public String getUpdateuid() {
        return updateuid;
    }

    public void setUpdateuid(String updateuid) {
        this.updateuid = updateuid;
    }


    @Override
    public String toString() {
        return "Bmotivate{" +
                "id=" + id +
                ", uid=" + uid +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", begindate='" + begindate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", deleted_flag=" + deleted_flag +
                ", remark='" + remark + '\'' +
                ", creationdt='" + creationdt + '\'' +
                ", updatedt='" + updatedt + '\'' +
                ", creationuid='" + creationuid + '\'' +
                ", updateuid='" + updateuid + '\'' +
                '}';
    }
}
