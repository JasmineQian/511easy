package com.example.demo.bean;

import java.io.Serializable;

public class BactivityList implements Serializable {

    private long id;
    private int uid;
    private int urgentid;
    private String code;
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

    public int getUrgentid() {
        return urgentid;
    }

    public void setUrgentid(int urgentid) {
        this.urgentid = urgentid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        return "BactivityListMapper{" +
                "id=" + id +
                ", uid=" + uid +
                ", urgentid=" + urgentid +
                ", code='" + code + '\'' +
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
