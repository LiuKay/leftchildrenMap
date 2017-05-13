package org.leftchildren.service.impl;

import org.leftchildren.dao.PointApplyDao;
import org.leftchildren.dao.PointDao;
import org.leftchildren.dto.ApplyExecution;
import org.leftchildren.entity.Point;
import org.leftchildren.entity.PointApply;
import org.leftchildren.enums.ApplyStatEnum;
import org.leftchildren.exception.ApplyException;
import org.leftchildren.exception.RepeatApplyException;
import org.leftchildren.service.PointApplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kay on 2017/5/2.
 */
@Service
public class PointApplyServiceImpl implements PointApplyService{

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PointApplyDao pointApplyDao;

    @Autowired
    private PointDao pointDao;

    /**
     * 查询所有 state=null
     * 已通过 1
     * 申请中 0
     * 未通过 -1
     * @param state
     * @return
     */
    public List<PointApply> queryAllApplies(Integer state) {
        return pointApplyDao.getAll(state);
    }

    /**
     *
     * 新点与用户绑定，申请表状态：审核申请中
     * 先插入申请表中，等待审核
     * @param point  新的point对象
     * @param ownerId
     */
    @Transactional
    public ApplyExecution applyForPoint(Point point, String ownerId,String detail,String detailImg) {
        try {
            //先判断重复申请
            PointApply oldApply = pointApplyDao.getById(point.getUid(), ownerId);
            if (oldApply != null) {
                int state = oldApply.getState();
                if (state == ApplyStatEnum.SUCCESS.getState() || state == ApplyStatEnum.APPLYING.getState()) {
                    throw new RepeatApplyException("不能重复申请或该申请已通过审核");
                }
            } else {
                //先将点添加到临时表，不管是否是新点，还是已经存在的点
                pointDao.addTempPoint(point);
                int applyCount = pointApplyDao.insertPointApply(point.getUid(), ownerId, ApplyStatEnum.APPLYING.getState(), detail, detailImg);
                if (applyCount <= 0) {
                    //todo 重复申请，抛出异常
                    throw new RepeatApplyException("ApplyException：重复申请");
                } else {
                    //提交申请成功,状态：审核中
                    PointApply newApply = pointApplyDao.getById(point.getUid(), ownerId);
                    return new ApplyExecution(point, ApplyStatEnum.APPLYING, newApply);
                }
            }
        }catch (RepeatApplyException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new ApplyException("inner exception...",e);
        }
    }


    /**
     * 执行审核
     * 1）审核通过则 添加新点，更新申请表状态为：审核通过
     * 2）审核不通过 新点不能添加，更新申请表状态为：审核不通过
     * @param ownerId
     */
    @Transactional
    public void executeVerify(String pointUid,String ownerId,boolean pass){


        if(pass==false){
            //审核不通过,直接返回，更新申请表状态为不通过
            pointApplyDao.updateSateById(pointUid,ownerId,ApplyStatEnum.FAIl.getState());
            return;
        }else {



            //审核通过
            //首先判断是否为已存在的点，不存在则添加点,然后删除临时表
            Point point = pointDao.queryById(pointUid);
            if (point == null) {
                int insertCount = pointDao.addPoint(point);
            }
            int deleteCount=pointDao.deleteTempPointById(pointUid);
            //更新申请表状态为通过
            pointApplyDao.updateSateById(pointUid,ownerId,ApplyStatEnum.SUCCESS.getState());
        }
    }
}
