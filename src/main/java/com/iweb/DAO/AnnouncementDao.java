package com.iweb.DAO;

import com.iweb.pojo.Announcement;

import java.util.List;

/**
 * @author k
 * @date 2023/6/12 10:14
 */
public interface AnnouncementDao {
    /**根据id查询公告
     * @param id 输入的id
     */
    Announcement searchAnnouncementById(Integer id);
    /**添加公告
     * @param announcement  要添加的公告，其中aId为空，因为它是自增长
     */
    void addAnnouncement(Announcement announcement);

    /**删除公告
     * @param announcement 要删除的公告
     */
    void deleteAnnouncement(Announcement announcement);

    /**更改公告
     * @param announcement 修改后的公告，包括被修改的公告aId，更改后的标题和内容
     */
    void updateAnnouncement(Announcement announcement);

    /**查询所有公告
     * @return 所有公告数据
     */
    List<Announcement> searchAllAnnouncement();

    /**根据公告名称查询公告(模糊查询)
     * @param string 根据string查询
     * @return 所有公告的数据
     */
    List<Announcement> searchAnnouncementByHeadline(String string);

    /**根据公告内容查询公告(模糊查询)
     * @param string 根据string查询
     * @return  所有公告的数据
     */
    List<Announcement> searchAnnouncementByContent(String string);
}
