package com.iweb.DAO;

import com.iweb.pojo.Position;

import java.util.List;

/**
 * @author k
 * @date 2023/6/12 10:13
 */
public interface PositionDao {
    /**添加职位
     * @param position 要添加的职位，其中pId为空，因为它是自增长
     */
    void addPosition(Position position);

    /**删除职位
     * @param position 要删除的职位
     */
    void deletePosition(Position position);

    /**更改职位
     * @param position 要更改的职位，包括被更改的职位id，更改后的职位名称
     */
    void updatePosition(Position position);

    /**查询所有职位
     * @return 所有职位信息
     */
    List<Position> searchAllPosition();

    /**根据职位名称查询职位(模糊查询)
     * @param pName 根据pName进行查询
     * @return 所有职位信息
     */
    List<Position> searchPositionByPositionName(String pName);

}
