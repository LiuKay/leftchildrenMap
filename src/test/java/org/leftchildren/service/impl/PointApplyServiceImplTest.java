package org.leftchildren.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.leftchildren.dao.PointDao;
import org.leftchildren.dto.ApplyExecution;
import org.leftchildren.entity.Point;
import org.leftchildren.entity.PointApply;
import org.leftchildren.exception.ApplyException;
import org.leftchildren.service.PointApplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kay on 2017/5/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class PointApplyServiceImplTest {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PointApplyService applyService;

    @Resource
    private PointDao pointDao;

    @Test
    public void queryAllApplies() throws Exception {
       List<PointApply> list1=applyService.queryAllApplies(10);
       logger.info("查询所有申请：{}",list1);
        List<PointApply> list2=applyService.queryAllApplies(1);
        logger.info("查询所有成功申请：{}",list2);
        List<PointApply> list3=applyService.queryAllApplies(-1);
        logger.info("查询所有未通过申请：{}",list3);
    }

    @Test
    public void applyForPoint() throws Exception {
        Point point=pointDao.queryById("654321");
        try {
            ApplyExecution applyExecution= applyService.applyForPoint(point,"429006199110288517","申请已存在点","img");
            logger.info("applyExecution={}",applyExecution);
        }catch (ApplyException e){
            logger.error(e.getMessage());
        }
        Point newPoint=new Point("np123456","新点","武汉市蔡甸","30.2145","114.2546","武汉");


   }

    @Test
    public void executeVerify() throws Exception {
        applyService.executeVerify("654321","429006199110288517",true);
        List<PointApply> apply=applyService.queryAllApplies(10);
        logger.info("apply={}",apply);
    }

}