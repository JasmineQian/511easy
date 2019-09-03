package com.example.demo.bean;

import java.io.Serializable;

public class Hmotivate  implements Serializable {

    private long id;
    private int uid;
    private String code;
    private int motiid;
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

    public int getMotiid() {
        return motiid;
    }

    public void setMotiid(int motiid) {
        this.motiid = motiid;
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
        return "Hmotivate{" +
                "id=" + id +
                ", uid=" + uid +
                ", code='" + code + '\'' +
                ", motiid=" + motiid +
                ", remark='" + remark + '\'' +
                ", creationdt='" + creationdt + '\'' +
                ", updatedt='" + updatedt + '\'' +
                ", creationuid='" + creationuid + '\'' +
                ", updateuid='" + updateuid + '\'' +
                '}';
    }
}
