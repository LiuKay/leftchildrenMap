package org.leftchildren.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.leftchildren.entity.PointApply;
import org.leftchildren.enums.ApplyStatEnum;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kay on 2017/5/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class PointApplyDaoTest {

    @Resource
    private PointApplyDao pointApplyDao;

    @Test
    public void insertPointApply() throws Exception {
       int insertCount= pointApplyDao.insertPointApply("123456","429006199110288515", ApplyStatEnum.APPLYING.getState(),
                "申请说明","imgUrl");
        System.out.println(insertCount);
    }

    @Test
    public void updateSateByOwnerId() throws Exception {
       int updateCount= pointApplyDao.updateSateById("123456","429006199110288515",ApplyStatEnum.SUCCESS.getState());
        System.out.println(updateCount);
    }

    @Test
    public void getByOwnerId() throws Exception{
        PointApply pointApply=pointApplyDao.getById("123456","429006199110288515");
        System.out.println(pointApply);
    }

    @Test

    public void getAll() {
       List<PointApply> list=pointApplyDao.getAll(10);
        System.out.println(list);
    }
}