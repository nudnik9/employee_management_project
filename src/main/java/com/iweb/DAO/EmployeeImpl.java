package com.iweb.DAO;

import com.iweb.pojo.Employee;
import com.iweb.pojo.Section;
import com.iweb.util.DBUtil;
import com.iweb.util.EidIsExistUtil;
import com.iweb.view.MainView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author k
 * @date 2023/6/12 10:14
 */
public class EmployeeImpl implements EmployeeDao {

    @Override
    public Boolean addEmployee(Employee employee) {
        List<Employee> employeeList = searchAllEmployee();
        String sql = "insert into employee(eId,ePassword,eName,eSex,ePhoneNumber,eIdNumber,sId,pId,isManager)" +
                " values(?,?,?,?,?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            if (EidIsExistUtil.eidIsExist(employee)) {
                return false;
            }
            ps.setInt(1, employee.getEId());
            ps.setString(2, employee.getEPassword());
            ps.setString(3, employee.getEName());
            ps.setString(4, employee.getESex());
            ps.setString(5, employee.getEPhoneNumber());
            ps.setString(6, employee.getEIdNumber());
            ps.setInt(7, employee.getSId());
            ps.setInt(8, employee.getPId());
            ps.setBoolean(9, employee.getIsManager());

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void deleteEmployee(Employee employee) {
        String sql = "delete from employee where eId=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setInt(1, employee.getEId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployeeBasicInformation(Employee employee) {
        String sql = "update employee set eName=?,eSex=?,ePhoneNumber=?,eIdNumber=? where eId=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setString(1, employee.getEName());
            ps.setString(2, employee.getESex());
            ps.setString(3, employee.getEPhoneNumber());
            ps.setString(4, employee.getEIdNumber());
            ps.setInt(5, employee.getEId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployeePassword(Employee employee) {
        String sql = "update employee set ePassword=? where eId=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setString(1, employee.getEPassword());
            ps.setInt(2, employee.getEId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployeePositionAndSection(Employee employee) {
        String sql = "update employee set sId=?,pId=? where eId=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setInt(1, employee.getSId());
            ps.setInt(2, employee.getPId());
            ps.setInt(3, employee.getEId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployeeIsManager(Employee employee) {
        String sql = "update employee set isManager where eId=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setBoolean(1, employee.getIsManager());
            ps.setInt(2, employee.getEId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> searchAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "select * from employee";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("eId"),
                        rs.getString("ePassword"), rs.getString("eName"),
                        rs.getString("eSex"), rs.getString("ePhoneNumber"),
                        rs.getString("eIdNumber"), rs.getInt("sId"),
                        rs.getInt("pId"), rs.getBoolean("isManager"));
                employeeList.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList.size() == 0 ? null : employeeList;
    }

    @Override
    public List<Employee> searchEmployeeByName(String eName) {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "select * from employee where eName like concat('%',?,'%')";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setString(1, eName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("eId"),
                        rs.getString("ePassword"), rs.getString("eName"),
                        rs.getString("eSex"), rs.getString("ePhoneNumber"),
                        rs.getString("eIdNumber"), rs.getInt("sId"),
                        rs.getInt("pId"), rs.getBoolean("isManager"));
                employeeList.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList.size() == 0 ? null : employeeList;
    }

    @Override
    public Employee searchEmployeeById(Integer eId) {
        String sql = "select * from employee where eId=?";
        Employee employee =null;
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setInt(1, eId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                employee = new Employee(rs.getInt("eId"),
                        rs.getString("ePassword"), rs.getString("eName"),
                        rs.getString("eSex"), rs.getString("ePhoneNumber"),
                        rs.getString("eIdNumber"), rs.getInt("sId"),
                        rs.getInt("pId"), rs.getBoolean("isManager"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> searchEmployeeByIsManager(Boolean isManager) {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "select * from employee where isManager=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setBoolean(1, isManager);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("eId"),
                        rs.getString("ePassword"), rs.getString("eName"),
                        rs.getString("eSex"), rs.getString("ePhoneNumber"),
                        rs.getString("eIdNumber"), rs.getInt("sId"),
                        rs.getInt("pId"), rs.getBoolean("isManager"));
                employeeList.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList.size() == 0 ? null : employeeList;
    }

    @Override
    public List<Employee> searchEmployeeByIdNumber(String eIdNumber) {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "select * from employee where eIdNumber=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setString(1, eIdNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("eId"),
                        rs.getString("ePassword"), rs.getString("eName"),
                        rs.getString("eSex"), rs.getString("ePhoneNumber"),
                        rs.getString("eIdNumber"), rs.getInt("sId"),
                        rs.getInt("pId"), rs.getBoolean("isManager"));
                employeeList.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList.size() == 0 ? null : employeeList;
    }

    @Override
    public List<Employee> searchEmployeeBySex(String sex) {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "select * from employee where eSex=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setString(1, sex);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("eId"),
                        rs.getString("ePassword"), rs.getString("eName"),
                        rs.getString("eSex"), rs.getString("ePhoneNumber"),
                        rs.getString("eIdNumber"), rs.getInt("sId"),
                        rs.getInt("pId"), rs.getBoolean("isManager"));
                employeeList.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList.size() == 0 ? null : employeeList;
    }

    @Override
    public List<Employee> searchEmployeeByPhone(String phone) {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "select * from employee where ePhoneNumber=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("eId"),
                        rs.getString("ePassword"), rs.getString("eName"),
                        rs.getString("eSex"), rs.getString("ePhoneNumber"),
                        rs.getString("eIdNumber"), rs.getInt("sId"),
                        rs.getInt("pId"), rs.getBoolean("isManager"));
                employeeList.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList.size() == 0 ? null : employeeList;
    }

    @Override
    public List<Employee> searchEmployeeByPosition(int pId) {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "select * from employee where pId=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setInt(1, pId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("eId"),
                        rs.getString("ePassword"), rs.getString("eName"),
                        rs.getString("eSex"), rs.getString("ePhoneNumber"),
                        rs.getString("eIdNumber"), rs.getInt("sId"),
                        rs.getInt("pId"), rs.getBoolean("isManager"));
                employeeList.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList.size() == 0 ? null : employeeList;
    }

    @Override
    public List<Employee> searchEmployeeBySection(int sId) {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "select * from employee where sId=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setInt(1, sId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("eId"),
                        rs.getString("ePassword"), rs.getString("eName"),
                        rs.getString("eSex"), rs.getString("ePhoneNumber"),
                        rs.getString("eIdNumber"), rs.getInt("sId"),
                        rs.getInt("pId"), rs.getBoolean("isManager"));
                employeeList.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList.size() == 0 ? null : employeeList;
    }
}
