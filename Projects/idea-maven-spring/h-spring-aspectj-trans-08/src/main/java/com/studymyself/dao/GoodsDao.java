package com.studymyself.dao;

import com.studymyself.entity.Goods;
import com.studymyself.entity.Sale;

public interface GoodsDao {

    //修改表中amount字段的值
    public int updateAmount(Sale sale);

    //根据商品id和名称查询数据
    public Goods selectByIdAndName(Sale sale);

}
