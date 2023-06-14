package com.iweb.DAO;

import com.iweb.pojo.Announcement;
import com.iweb.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author k
 * @date 2023/6/12 10:14
 */
public class AnnouncementImpl implements AnnouncementDao {
    @Override
    public Announcement searchAnnouncementById(Integer id){
        Announcement announcement =  null;
        String sql ="select * from announcement where aId=?";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)
        ){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                announcement = new Announcement(rs.getInt("aId"),
                        rs.getString("aHeadline"),
                        rs.getString("aContent"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return announcement==null?null:announcement;
    }
    @Override
    public void addAnnouncement(Announcement announcement) {
        String sql = "insert into announcement(aHeadline,aContent) values(?,?)";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ){
            ps.setString(1,announcement.getAHeadline());
            ps.setString(2,announcement.getAContent());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                announcement.setAId(rs.getInt(1));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAnnouncement(Announcement announcement) {
        String sql = "delete from announcement where aId=?";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)
        ){
            ps.setInt(1,announcement.getAId());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateAnnouncement(Announcement announcement) {
        String sql = "update announcement set aHeadline=?,aContent=? where aId=?";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)
        ){
            ps.setString(1,announcement.getAHeadline());
            ps.setString(2,announcement.getAContent());
            ps.setInt(3,announcement.getAId());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Announcement> searchAllAnnouncement() {
        List<Announcement> announcementList =  new ArrayList<>();
        String sql ="select * from announcement";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)
        ){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Announcement announcement = new Announcement(
                        rs.getInt("aId"),rs.getString("aHeadline"),
                        rs.getString("aContent"));
                announcementList.add(announcement);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return announcementList.size()==0?null:announcementList;
    }

    @Override
    public List<Announcement> searchAnnouncementByHeadline(String string) {
        List<Announcement> announcementList =  new ArrayList<>();
        String sql ="select * from announcement where aHeadline like concat('%',?,'%')";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)
        ){
            ps.setString(1,string);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Announcement announcement = new Announcement(
                        rs.getInt("aId"),rs.getString("aHeadline"),
                        rs.getString("aContent"));
                announcementList.add(announcement);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return announcementList.size()==0?null:announcementList;
    }

    @Override
    public List<Announcement> searchAnnouncementByContent(String string) {
        List<Announcement> announcementList =  new ArrayList<>();
        String sql ="select * from announcement where aContent like concat('%',?,'%')";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)
        ){
            ps.setString(1,string);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Announcement announcement = new Announcement(
                        rs.getInt("aId"),rs.getString("aHeadline"),
                        rs.getString("aContent"));
                announcementList.add(announcement);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return announcementList.size()==0?null:announcementList;
    }
}
