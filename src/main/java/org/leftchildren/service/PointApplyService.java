package org.leftchildren.service;

/**
 * Created by kay on 2017/5/2.
 */

import org.leftchildren.dto.ApplyExecution;
import org.leftchildren.entity.Point;
import org.leftchildren.entity.PointApply;

import java.util.List;

/**
 * 把添加点的逻辑放在PointApply里面
 */
public interface PointApplyService {

    /**
     * 用户行为
     * 申请添加新点(不存在的点)
     * 申请成功后，一个点对应一个用户
     *
     * @param point  新的point对象
     * @param ownerId
     */
    ApplyExecution applyForPoint(Point point, String ownerId,String detail,String detailImg);



    /**
     *执行审核
     * @param pointUid
     * @param ownerId
     * @param pass
     */
    void executeVerify(String pointUid, String ownerId,boolean pass);

    /**
     * 查询所有申请
     * @param state=10 ，1/0/-1
     * @return
     */
    List<PointApply> queryAllApplies(Integer state);
}
