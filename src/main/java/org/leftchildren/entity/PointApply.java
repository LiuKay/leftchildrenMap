package org.leftchildren.entity;

import java.util.Date;

/**
 * Created by kay on 2017/5/1.
 */
public class PointApply {

    private String pointUid;

    private String ownerId;

    private Date createTime;

    private char state;

    private String detail;

    private String detailImg;

    @Override
    public String toString() {
        return "PointApply{" +
                "pointUid='" + pointUid + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", createTime=" + createTime +
                ", state=" + state +
                ", detail='" + detail + '\'' +
                ", detailImg='" + detailImg + '\'' +
                '}';
    }



    public String getDetailImg() {
        return detailImg;
    }

    public void setDetailImg(String detailImg) {
        this.detailImg = detailImg;
    }

    public String getPointUid() {
        return pointUid;
    }

    public void setPointUid(String pointUid) {
        this.pointUid = pointUid;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
