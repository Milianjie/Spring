package com.studymyself.service.impl;

import com.studymyself.dao.GoodsDao;
import com.studymyself.dao.SaleDao;
import com.studymyself.entity.Goods;
import com.studymyself.entity.Sale;
import com.studymyself.exceptions.NotEnoughException;
import com.studymyself.service.BuyGoodsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BuyGoodsServiceImpl implements BuyGoodsService {

    GoodsDao goodsDao;
    SaleDao saleDao;

    //开发者将方法归类，前面添加相同前缀
    public void addGoods(){};
    public void addSale(){};

    public void modifyGoods(){};
    public void modifySale(){};

    public void queryGoods(){};
    public void querySale(){};



    //购买商品的方法
    @Override
    public void buy(Integer goodId, String goodName, Integer nums) {

        System.out.println("==执行buy方法，开始购买商品==");
        //添加商品销售记录（向t_sale表中插入数据）
        //创建Sale类，并且向其中属性赋值
        Sale sale1 = new Sale();
        sale1.setGid(goodId);
        sale1.setGname(goodName);
        sale1.setNums(nums);
        int count = saleDao.insertSale(sale1);

        //根据提供的信息数据查询商品信息
        Goods good = goodsDao.selectByIdAndName(sale1);

        //根据查询结果判断是否要更新商品库存
        if (good == null){
            count -= 1;
            System.out.println("购买失败，请重新购买");
            throw new NullPointerException("商品:"+sale1.getGname()+" 编号:"+sale1.getGid()+"不存在！！！");
        }else if (good.getAmount()<nums){
            count -= 1;
            System.out.println("购买失败，请重新购买");
            throw new NotEnoughException("商品:"+sale1.getGname()+" 编号:"+sale1.getGid()+" 库存不足！！！");

        }
        //更新商品表
        goodsDao.updateAmount(sale1);
        if (count>0){
            System.out.println("已购买商品："+goodName);
        }

    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }
}
