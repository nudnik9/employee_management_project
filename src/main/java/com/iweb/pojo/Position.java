package com.iweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author k
 * @date 2023/6/12 9:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    private Integer pId;
    private String pName;

    public Position(String pName) {
        this.pName = pName;
    }
    public String printPosition(){
        return "职位id："+this.pId+"  职位名称："+this.pName;
    }
}
