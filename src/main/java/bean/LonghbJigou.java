package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class LonghbJigou implements Serializable {

   //股票代码
    private String code ;

   //交易时间
    private String tdate ;

   //股票名称
    private String name ;

   //市场总成交额(万)
    private float accumamount ;

   //机构买入总额(万)
    private float buyamt ;

   //买方机构数
    private float buytimes ;

   //涨跌幅
    private float changerate ;

   //收盘价
    private float closeprice ;

   //上榜后10日涨跌幅
    private float d10closeadjchrate ;

   //上榜后1日涨跌幅
    private float d1closeadjchrate ;

   //上榜后2日涨跌幅
    private float d2closeadjchrate ;

   //上榜后5日涨跌幅
    private float d5closeadjchrate ;

   //上榜原因
    private String explanation ;

   //流通市值(亿)
    private float freecap ;

   //市场
    private String market ;

   //机构买入净额(万)
    private float netbuyamt ;

   //机构净买额占总成交额比
    private float ratio ;

   //代码简写
    private String secucode ;

   //机构卖出总额(万)
    private float sellamt ;

   //卖方机构数
    private float selltimes ;

   //换手率
    private float turnoverrate ;

}

