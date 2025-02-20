package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataYanBaoYingLi implements Serializable {

   //股票代码
    private String code ;

   //股票名称
    private String name ;

   //机构研报数
    private float orgnum ;

   //近四年每股收益（预测）-去年
    private float eps1 ;

   //近四年每股收益（预测）-今年
    private float eps2 ;

   //近四年每股收益（预测）-明年
    private float eps3 ;

   //近四年每股收益（预测）-后年
    private float eps4 ;

   //机构投资评级（近六个月）-增持
    private float ratingaddnum ;

   //机构投资评级（近六个月）-买入
    private float ratingbuynum ;

   //机构投资评级（近六个月）-中性
    private float ratingneutralnum ;

   //机构投资评级（近六个月）-减持
    private float ratingreducenum ;

   //机构投资评级（近六个月）-卖出
    private float ratingsalenum ;

}

