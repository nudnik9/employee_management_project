package com.iweb.DAO;

import com.iweb.pojo.Employee;
import com.iweb.pojo.Position;
import com.iweb.util.DBUtil;
import com.iweb.view.MainView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author k
 * @date 2023/6/12 10:15
 */
public class PositionImpl implements PositionDao {

    public Integer searchPositionIdByName(String pName){
        String sql = "select * from position where pName=?";
        Integer positionId = null;
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setString(1,pName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                positionId = rs.getInt("pId");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return positionId;
    }
    public Position searchPositionNameByPid(Integer pid){
        String sql = "select * from position where pId=?";
        Position position = null;
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setInt(1, pid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                position= new Position(rs.getInt("pId"),rs.getString("pName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return position;
    }
    @Override
    public void addPosition(Position position) {
        String sql = "insert into position(pName) values(?)";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ){
            ps.setString(1,position.getPName());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                position.setPId(rs.getInt(1));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deletePosition(Position position) {
        String sql = "delete from position where pId=?";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)
        ){
            List<Employee> employeeList = MainView.employeeDao.searchEmployeeByPosition(position.getPId());
            for (Employee employee:employeeList) {
                employee.setPId(6);
                MainView.employeeDao.updateEmployeePositionAndSection(employee);
            }
            ps.setInt(1,position.getPId());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updatePosition(Position position) {
        String sql = "update position set pName=? where pId=?";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)
        ){
            ps.setString(1,position.getPName());
            ps.setInt(2,position.getPId());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Position> searchAllPosition() {
        List<Position> positionList =  new ArrayList<>();
        String sql ="select * from position ";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)
        ){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Position position = new Position(
                        rs.getInt("pId"),rs.getString("pName"));
                positionList.add(position);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return positionList.size()==0?null:positionList;
    }

    @Override
    public List<Position> searchPositionByPositionName(String pName) {
        List<Position> positionList =  new ArrayList<>();
        String sql ="select * from position where pName like concat('%',?,'%')";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)
        ){
            ps.setString(1,pName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Position position = new Position(
                        rs.getInt("pId"),rs.getString("pName"));
                positionList.add(position);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return positionList.size()==0?null:positionList;
    }
}
