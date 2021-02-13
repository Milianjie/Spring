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

    /**
     *  rollbackFor:表示抛出指定异常进行回滚
     *  处理逻辑：
     *      1、Spring框架会首先检查方法抛出的异常是不是rollbackFor属性值列表的值，只要是
     *      不管是运行时还是编译时异常，都会执行回滚操作
     *      2、如果抛出的不是该属性值列表中的异常，就会判断该异常是运行时异常还是编译时异常
     *      前者的话就执行回滚，后者不执行回滚
     *      所以默认的该属性是抛出运行时异常就执行回滚操作
     *
     */

    //购买商品的方法
    @Transactional(
            //这里的属性自己依据业务需求设置值，一般来说都不设置，使用默认的
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            timeout = -1,
            readOnly = false,
            rollbackFor = {NotEnoughException.class,NullPointerException.class}
            //或
            //rollbackForClassName = {"NotEnoughException","NullPointException"}

    )
    //一般我们都是直接加个@Transactional就行了
    //@Transactional
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
