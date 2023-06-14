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
public class Announcement {
    private Integer aId;
    private String aHeadline;
    private String aContent;

    public Announcement(String aHeadline, String aContent) {
        this.aHeadline = aHeadline;
        this.aContent = aContent;
    }

    public void printAnnouncement(){
        System.out.println("公告id："+this.getAId());
        System.out.println("公告标题："+this.getAHeadline());
        System.out.println("公告内容："+this.getAContent());
    }
}
