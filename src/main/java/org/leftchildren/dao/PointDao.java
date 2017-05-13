package org.leftchildren.dao;

import org.apache.ibatis.annotations.Param;
import org.leftchildren.entity.Point;

import java.util.List;

/**
 * Created by kay on 2017/5/1.
 */
public interface PointDao {

    /**
     * 添加一个留守儿童点
     * @param point
     * @return
     */
    int addPoint(Point point);

    /**
     * 根据偏移量查询所有满足条件的记录
     * @param offset
     * @param limit
     * @param city  点所属地区关键字 city=null查询所有
     * @return
     */
    List<Point> queryAll(@Param("offset") int offset,@Param("limit") int limit,@Param("city") String city);

    /**
     * 删除点
     * @param uid
     * @return  返回影响行数
     */
    int deleteById(String uid);

    /**
     * 根据id查找点
     * @param id
     * @return 返回Point对象
     */
    Point queryById(String id);

    /**
     * 更新点
     * @param point
     * @return
     */
    int updatePoint(Point point);


    //添加点到临时表
    int addTempPoint(Point point);

    //删除临时表的点
    int deleteTempPointById(String uid);

    //查询临时表中的点
    Point queryTempPoint(String uid);
}
