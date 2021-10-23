package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class StockBaseInfo implements Serializable {

   //股票代码
    private String code ;

   //股票名称
    private String name ;

   //上市地，0：深交所，1：上交所，116：港交所
    private int market ;

   //沪深港通，1：沪股通:2：深股通、3：港股通(沪)、4：港股通(深)、5：港股通(沪+深)
    private int hsgt ;

   //所属板块，个股包括主板、创业板、科创板
    private String bk ;

   //成分股，该板块的成分股
    private String cfg ;

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

}

