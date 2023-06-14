package com.iweb.pojo;

import com.iweb.DAO.PositionImpl;
import com.iweb.DAO.SectionImpl;
import com.iweb.view.MainView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author k
 * @date 2023/6/12 9:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer eId;
    private String ePassword="123";
    private String eName;
    private String eSex="男";
    private String ePhoneNumber;
    private String eIdNumber;
    private Integer sId=6;
    private Integer pId=6;
    private Boolean isManager=false;

    public String printEmployee(){
        SectionImpl s = (SectionImpl) MainView.sectionDao;
        PositionImpl p = (PositionImpl)MainView.positionDao;
        return "账号："+this.getEId()+"  密码:"+this.getEPassword()
                +"  姓名："+this.getEName()+"  性别:"+this.getESex()+
                "  手机号："+this.getEPhoneNumber()+"  身份证号："+this.getEIdNumber()+
                "  所属部门："+ s.searchSectionBySid(this.getSId()).getSName()+
                "  职位："+p.searchPositionNameByPid(this.getPId()).getPName()+
                "  是否是管理员："+this.getIsManager();

    }
}
