package org.leftchildren.service.impl;

import org.leftchildren.dao.PointDao;
import org.leftchildren.entity.Point;
import org.leftchildren.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by kay on 2017/5/2.
 */
public class PointServiceImpl implements PointService{

    @Autowired
    private PointDao pointDao;

    public List<Point> getPointList(String city) {


        //TODO offset  limit  city:重庆市/武汉市
        return pointDao.queryAll(0,50,"重庆");
    }

    public Point getById(String pointUid) {
        return pointDao.queryById(pointUid);
    }

    public int updatePoint(Point point) {
        return pointDao.updatePoint(point);
    }

    public int deleteById(String pointUid) {
        return pointDao.deleteById(pointUid);
    }

    public int addPoint(Point point) {
        return pointDao.addPoint(point);
    }
}
