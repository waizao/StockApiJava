package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class HSGTStockRank implements Serializable {

   //股票代码
    private String code ;

   //股票名称
    private String name ;

   //交易日期
    private String tdate ;

   //今日增持估计-市值（万）
    private float addmarketcap ;

   //今日增持估计-市值增幅（%）
    private float addsharesamp ;

   //今日增持估计-股数（万）
    private float addsharesrepair ;

   //今日增持估计-占流通股比（‰）
    private float freecapratiochg ;

   //今日增持估计-占总股本比（‰）
    private float totalratiochg ;

   //今日持股-占流通股比（%）
    private float freesharesratio ;

   //今日持股-市值（万）
    private float holdmarketcap ;

   //今日持股-股数（万）
    private float holdshares ;

   //今日持股-占总股本比（%）
    private float totalsharesratio ;

   //地域板块代码
    private String areacode ;

   //今日涨跌幅
    private float changerate ;

   //今日收盘价
    private float closeprice ;

   //所属板块
    private String industrycode ;

}

