package org.leftchildren.dto;

import org.leftchildren.entity.Point;
import org.leftchildren.entity.PointApply;
import org.leftchildren.enums.ApplyStatEnum;

/**
 * Created by kay on 2017/5/2.
 */
public class ApplyExecution {

    private Point point;

    private int state;

    private String stateInfo;

    private PointApply pointApply;

    public ApplyExecution(Point point, ApplyStatEnum statEnum) {
        this.point = point;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
    }

    public ApplyExecution(Point point,ApplyStatEnum statEnum , PointApply pointApply) {
        this.point = point;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
        this.pointApply = pointApply;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public PointApply getPointApply() {
        return pointApply;
    }

    public void setPointApply(PointApply pointApply) {
        this.pointApply = pointApply;
    }
}
