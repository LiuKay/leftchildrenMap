package org.leftchildren.dao;

import org.apache.ibatis.annotations.Param;
import org.leftchildren.entity.PointApply;

import java.util.List;

/**
 * Created by kay on 2017/5/1.
 */
public interface PointApplyDao {
    /**
     * 添加申请记录
     * @param pointUid 点id
     * @param ownerId 认领人id
     * @param state  审核状态
     * @param detail 认领说明
     * @return
     */
    int insertPointApply(@Param("pointUid") String pointUid,
                         @Param("ownerId") String ownerId,
                         @Param("state") int state,
                         @Param("detail") String detail,
                         @Param("detailImg") String detailImg);

    /**
     * 更新审核状态
     * @param ownerId  认领人id
     * @param state    审核状态
     * @return
     */
    int updateSateById(@Param("pointUid") String pointUid,
                            @Param("ownerId") String ownerId,
                            @Param("state") int state);

    /**
     * 根据用户id查找申请
     * @return
     */
    PointApply getById(@Param("pointUid") String pointUid,
                            @Param("ownerId") String ownerId);

    /**
     * 查询所有申请 getAll(10)
     * 1 已通过
     * -1 未通过
     * @param state 动态sql的参数state
     * @return
     */
    List<PointApply> getAll(@Param("state") int state);
}
