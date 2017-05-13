package org.leftchildren.service;

import org.leftchildren.entity.Point;

import java.util.List;

/**
 * Created by kay on 2017/5/2.
 */

/**
 * 查询所有点，单个点，更新点，删除点,添加点
 */
public interface PointService {
    /**
     * 查询所有点 city=null 查询所有
     * @return
     */
    List<Point> getPointList(String city);

    /**
     * 查询单个点
     * @param pointUid
     * @return
     */
    Point getById(String pointUid);

    /**
     * 更新点
     * @param point
     * @return
     */
    int updatePoint(Point point);

    /**
     * 根据id删除点，返回受影响行数
     * @param pointUid
     * @return
     */
    int deleteById(String pointUid);

    /**
     * 添加点
     * @param point
     * @return
     */
    int addPoint(Point point);
}
