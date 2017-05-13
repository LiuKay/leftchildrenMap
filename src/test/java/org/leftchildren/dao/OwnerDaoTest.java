package org.leftchildren.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.leftchildren.entity.Owner;
import org.leftchildren.enums.GenderEnum;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by kay on 2017/5/2.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class OwnerDaoTest {

    @Resource
    private OwnerDao ownerDao;

    Owner owner=new Owner("429006199110288515","kay",18062795547L, GenderEnum.MAN.getState(),"武汉市蔡甸区");

    @Test
    public void insertOwner() throws Exception {
      int  insertCount=ownerDao.insertOwner(owner);
        System.out.println(insertCount);
    }

    @Test
    public void deleteById() throws Exception {
       int d1= ownerDao.deleteById("429006199110288515");
        System.out.println(d1);
    }

    @Test
    public void queryById() throws Exception {
        Owner o1=ownerDao.queryById("429006199110288515");
        System.out.println("Owner:"+o1);
    }

    @Test
    public void updateOwner() throws Exception {
        owner.setAddress("深圳市南山区");
        int updateCount=ownerDao.updateOwner(owner);
        System.out.println(updateCount);
    }

}