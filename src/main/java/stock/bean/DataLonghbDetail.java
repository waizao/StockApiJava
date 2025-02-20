package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataLonghbDetail implements Serializable {

   //股票代码
    private String code ;

   //交易时间
    private String tdate ;

   //名称
    private String name ;

   //解读
    private String explainstock ;

   //收盘价
    private float closeprice ;

   //涨跌幅
    private float changerate ;

   //龙虎榜净买额（元）
    private float billboardnetamt ;

   //龙虎榜买入额（元）
    private float billboardbuyamt ;

   //龙虎榜卖出额（元）
    private float billboardsellamt ;

   //龙虎榜成交额（元）
    private float billboarddealamt ;

   //市场总成交额（元）
    private float accumamount ;

   //净买额占总成交比
    private float dealnetratio ;

   //成交额占总成交比
    private float dealamountratio ;

   //换手率
    private float turnoverrate ;

   //流通市值（元）
    private float freemarketcap ;

   //上榜原因
    private String explanation ;

   //市场类型
    private String trademarket ;

   //股票标记
    private String secucode ;

}

