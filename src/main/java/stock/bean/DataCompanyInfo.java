package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataCompanyInfo implements Serializable {

   //股票代码
    private String code ;

   //股票名称
    private String name ;

   //涨跌幅
    private float changepercent ;

   //最新收盘
    private float close ;

   //上市时间
    private String listingdate ;

   //流通股本
    private float ltgb ;

   //总股本
    private float zgb ;

   //流通市值
    private float ltsz ;

   //总市值
    private float marketvalue ;

   //市净率
    private float pb ;

   //市盈率
    private float peration ;

   //板块描述
    private String bk ;

   //经营范围
    private String businscope ;

   //公司简介
    private String compprofile ;

   //核心题材
    private String hxtc ;

   //主营业务
    private String mainbusin ;

   //主营产品收入
    private String zycp ;

}

