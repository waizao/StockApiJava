package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class StockBaseInfo implements Serializable {

   //股票代码
    private String code ;

   //股票名称
    private String name ;

   //股票类型，1：深证股票，2：上证股票，3：北证股票，4：港股
    private int stype ;

   //沪深港通，1：沪股通（港>沪）、2：深股通（港>深）、3：港股通（沪>港）、4：港股通（深>港）、5：港股通（深>港或沪>港）
    private int hsgt ;

   //所属板块，个股包括主板、创业板、科创板
    private String bk ;

   //ROE
    private float roe ;

   //总股本（股）
    private float zgb ;

   //流通股本（股）
    private float ltgb ;

   //流通市值（元）
    private float ltsz ;

   //总市值（元）
    private float zsz ;

   //上市日期
    private String ssdate ;

   //该个股归属的行业或者指数，Json格式：{t：指数或板块对应资产类型，c：指数或板块代码，n：指数或板块名称}。
    private String relation ;

   //归属行业板块名称
    private String z50 ;

   //归属地域板块名称
    private String z52 ;

   //归属概念板块名称
    private String z53 ;

   //关联行业，该个股所在行业板块
    private String bkcode ;

   //分类标记
    private long flags ;

}

