package org.leftchildren.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.leftchildren.entity.Point;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sound.midi.Soundbank;
import java.util.List;

/**
 * Created by kay on 2017/5/2.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class PointDaoTest {

    @Resource
    private PointDao pointDao;

    @Test
    public void addPoint() throws Exception {
        Point point= new Point("123456","测试p1","湖北省武汉市蔡甸区","30.23515","114.63254","重庆市");
        int insertCount=pointDao.addPoint(point);
        System.out.println(insertCount);
    }

    @Test
    public void queryAll() throws Exception {
        List<Point> list =pointDao.queryAll(0,4,null);
        System.out.println("list:"+list);
    }

    @Test
    public void deleteById() throws Exception {
        int delCount=pointDao.deleteById("123456");
        System.out.println(delCount);
    }

    @Test
    public void queryById() throws Exception {
        Point point=pointDao.queryById("123456");
        System.out.println(point);
    }

    @Test
    public void updatePoint() throws Exception {
        Point point=pointDao.queryById("123456");
        point.setAddress("重庆市某某区");
        int updateCount=pointDao.updatePoint(point);
        System.out.println(updateCount);
    }

    @Test
    public void addTempPoint() throws Exception {
        Point point= new Point("654321","测试p1","湖北省武汉市蔡甸区","30.23515","114.63254","重庆市");
        int c=pointDao.addTempPoint(point);
        System.out.println(c);
    }

    @Test
    public void queryTempPoint() throws Exception {
        Point point=pointDao.queryTempPoint("654321");
        System.out.println(point);
    }

    @Test
    public void deleteTempPointById() throws Exception {
        int c=pointDao.deleteTempPointById("654321");
        System.out.println(c);
    }
}