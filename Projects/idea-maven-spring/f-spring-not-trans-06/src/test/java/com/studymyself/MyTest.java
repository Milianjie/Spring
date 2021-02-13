package com.studymyself;

import com.studymyself.service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    /**
     * 测试购买商品的方法
     */
    @Test
    public void testBuy(){

        //定义Spring配置文件路径
        String config = "applicationContext.xml";

        //获取Spring容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //获取service对象
        BuyGoodsService buyGoodsService = (BuyGoodsService) ac.getBean("buyGoodsService");
        System.out.println(buyGoodsService.getClass().getName());

        buyGoodsService.buy(1003,"手机",2000);

    }

}
