package com.iweb.DAO;

import com.iweb.pojo.Section;

import java.util.List;

/**
 * @author k
 * @date 2023/6/12 10:12
 */
public interface SectionDao {
    /**添加部门
     * @param section 要添加的部门，其中sId为空，因为它是自增长
     */
    void addSection(Section section);

    /**删除部门
     * @param section 要删除的部门
     */
    void deleteSection(Section section);

    /**更改部门
     * @param section 要更改的部门，包括被更改的部门id，更改后的部门名称
     */
    void updateSection(Section section);

    /**查询所有部门
     * @return 所有部门信息
     */
    List<Section> searchAllSection();

    /**根据部门名称查询部门(模糊查询)
     * @param sName 根据sName进行查询
     * @return 所有部门信息
     */
    List<Section> searchSectionBySectionName(String sName);
}
