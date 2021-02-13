package com.studymyself.entity;

/**
 * 购买的商品表单类
 */
public class Sale {

    private Integer id;
    private Integer gid;
    private String gname;
    private Integer nums;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer amount) {
        this.nums = amount;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", gid=" + gid +
                ", gname='" + gname + '\'' +
                ", amount=" + nums +
                '}';
    }
}
