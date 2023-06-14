package com.iweb.DAO;

import com.iweb.pojo.Employee;
import com.iweb.pojo.Section;
import com.iweb.util.DBUtil;
import com.iweb.view.MainView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author k
 * @date 2023/6/12 10:15
 */
public class SectionImpl implements SectionDao{
    public Integer searchSectionIdByName(String sName){
        String sql = "select * from section where sName=?";
        Integer sectionId=null;
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setString(1, sName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                sectionId=rs.getInt("sId");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sectionId;
    }
    public Section searchSectionBySid(Integer sid){
        String sql = "select * from section where sId=?";
        Section section = null;
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setInt(1, sid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                section = new Section(rs.getInt("sId"),rs.getString("sName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return section;
    }
    @Override
    public void addSection(Section section) {
        String sql = "insert into section(sName) values(?)";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ){
            ps.setString(1,section.getSName());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                section.setSId(rs.getInt(1));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSection(Section section) {
        String sql = "delete from section where sId=?";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)
        ){
            List<Employee> employeeList = MainView.employeeDao.searchEmployeeByPosition(section.getSId());
            for (Employee employee:employeeList) {
                employee.setSId(6);
                MainView.employeeDao.updateEmployeePositionAndSection(employee);
            }
            ps.setInt(1,section.getSId());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateSection(Section section) {
        String sql = "update section set sName=? where sId=?";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)
        ){
            ps.setString(1,section.getSName());
            ps.setInt(2,section.getSId());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Section> searchAllSection() {
        List<Section> sectionList =  new ArrayList<>();
        String sql ="select * from section ";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)
        ){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Section section = new Section(
                        rs.getInt("sId"),rs.getString("sName"));
                sectionList.add(section);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sectionList.size()==0?null:sectionList;
    }

    @Override
    public List<Section> searchSectionBySectionName(String sName) {
        List<Section> sectionList =  new ArrayList<>();
        String sql ="select * from section where sName like concat('%',?,'%')";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)
        ){
            ps.setString(1,sName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Section section = new Section(
                        rs.getInt("sId"),rs.getString("sName"));
                sectionList.add(section);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sectionList.size()==0?null:sectionList;
    }
}
