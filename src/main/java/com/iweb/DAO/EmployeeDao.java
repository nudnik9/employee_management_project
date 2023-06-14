package com.iweb.DAO;

import com.iweb.pojo.Employee;

import java.util.List;

/**
 * @author k
 * @date 2023/6/12 10:13
 */
public interface EmployeeDao {
    /**添加用户
     * @param employee 要添加的用户信息
     */
    Boolean addEmployee(Employee employee);

    /**根据用户账号删除用户
     * @param employee 要删除的用户
     */
    void deleteEmployee(Employee employee);

    /**修改用户基础信息(姓名、性别、手机号、身份证)
     * @param employee 修改后的用户信息
     */
    void updateEmployeeBasicInformation(Employee employee);

    /**修改用户密码
     * @param employee 修改后的用户信息
     */
    void updateEmployeePassword(Employee employee);

    /**修改用户职位和部门
     * @param employee 修改后的用户信息
     */
    void updateEmployeePositionAndSection(Employee employee);

    /**修改用户是否是管理员
     * @param employee 修改后的用户信息
     */
    void updateEmployeeIsManager(Employee employee);

    /**查询所有用户
     * @return 用户数据
     */
    List<Employee> searchAllEmployee();

    /**根据用户名查询用户(模糊查询)
     * @param eName 输入的姓名
     * @return 用户数据
     */
    List<Employee> searchEmployeeByName(String eName);

    /**根据id查询用户
     * @param eId 输入的id
     * @return 用户数据
     */
    Employee searchEmployeeById(Integer eId);

    /**根据用户是否是管理员查询用户
     * @param isManager 是否是管理员
     * @return 用户数据
     */
    List<Employee> searchEmployeeByIsManager(Boolean isManager);

    /**根据用户身份证号查询用户
     * @param eIdNumber 输入的身份证号
     * @return 用户数据
     */
    List<Employee> searchEmployeeByIdNumber(String eIdNumber);

    /**根据用户性别查询用户
     * @param sex 输入的性别
     * @return 用户数据
     */
    List<Employee> searchEmployeeBySex(String sex);

    /**根据用户手机号查询用户
     * @param phone 输入的手机号
     * @return 用户数据
     */
    List<Employee> searchEmployeeByPhone(String phone);

    /**根据用户职位查询用户
     * @param pId 输入的职位名称
     * @return 用户数据
     */
    List<Employee> searchEmployeeByPosition(int pId);

    /**根据用户部门查询用户
     * @param sId 输入的部门名称
     * @return 用户数据
     */
    List<Employee> searchEmployeeBySection(int sId);

}
