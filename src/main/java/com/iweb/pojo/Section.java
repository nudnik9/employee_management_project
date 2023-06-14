package com.iweb.pojo;

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
public class Section {
    private Integer sId;
    private String sName;

    public Section(String sName) {
        this.sName = sName;
    }
    public String printSection(){
        return "部门id："+this.sId+"  部门名称："+this.sName;
    }
}
