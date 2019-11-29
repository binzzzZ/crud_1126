package com.sys.entity;

/**
 * @author lrbin
 * @version 1.0.0
 * @company
 * @create 2019/11/28 17:58
 * @Description
 */
public class Area {
    private Integer id;
    private Integer pId;
    private String name;
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
