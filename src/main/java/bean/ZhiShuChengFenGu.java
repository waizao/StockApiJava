package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class ZhiShuChengFenGu implements Serializable {

   //指数类别
    private int mtype ;

   //股票代码
    private String code ;

   //指数名称
    private String indexname ;

   //股票名称
    private String name ;

   //每股净资产(元)
    private float bps ;

   //涨跌幅
    private float changerate ;

   //最新价(元)
    private float closeprice ;

   //每股收益(元)
    private float eps ;

   //流通市值(亿元)
    private float freecap ;

   //流通股本(亿股)
    private float freeshares ;

   //主营行业
    private String industry ;

   //地区
    private String region ;

   //净资产收益率(%)
    private float roe ;

   //股票安全代码
    private String secucode ;

   //总股本(亿股)
    private float totalshares ;

   //成分股权重
    private float weight ;

}

