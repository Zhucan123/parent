package com.zc.eurekaclient.secondaryDomain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zhuCan on 2018/12/3.
 * Project parent.
 * Date 2018/12/3   Time 16:40.
 */
@Entity
@Table(name = "c_craft")
public class CraftEntity {

    @Id
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
