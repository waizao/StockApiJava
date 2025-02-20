package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataHsgtStockTop10 implements Serializable {

   //股票代码
    private String code ;

   //市场类型，1：沪股通；2：港股通（沪>港）；3：深股通；4：港股通（深>港）
    private int mtype ;

   //交易时间
    private String tdate ;

   //代码
    private String mkcode ;

   //排名
    private int rankId ;

   //股票简称
    private String securityname ;

   //收盘价
    private float closeprice ;

   //涨跌幅
    private float changerate ;

   //净买额（元）
    private float netbuyamt ;

   //买入金额（元）
    private float buyamt ;

   //卖出金额（元）
    private float sellamt ;

   //成交金额（元）
    private float dealamt ;

   //总交易金额（元）
    private float dealAmount ;

}

