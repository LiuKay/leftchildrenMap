package org.leftchildren.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.leftchildren.entity.Volunteer;
import org.leftchildren.enums.GenderEnum;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by kay on 2017/5/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class VolunteerDaoTest {

    @Resource
    private VolunteerDao volunteerDao;

    Volunteer v=new Volunteer("429006199110288516","cxf", GenderEnum.FEMALE.getState(),"武汉市",18062416628L);

    @Test
    public void insertVolunteer() throws Exception {
        int insertCount=volunteerDao.insertVolunteer(v);
        System.out.println(insertCount);
    }

    @Test
    public void deleteById() throws Exception {
       int d1= volunteerDao.deleteById("429006199110288516");
        System.out.println(d1);
    }

    @Test
    public void queryById() throws Exception {
      Volunteer v1=  volunteerDao.queryById("429006199110288516");
        System.out.println(v1);
    }

    @Test
    public void updateVolunteer() throws Exception {
        v.setAddress("深圳南山");
        int u1=volunteerDao.updateVolunteer(v);
        System.out.println(u1);
    }

}