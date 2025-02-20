package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataGZMarket implements Serializable {

   //市场代码
    private String code ;

   //交易日期
    private String tdate ;

   //平均市盈率
    private float pe_ttm_avg ;

   //总股本（股）
    private float total_shares ;

   //流通股本（股）
    private float free_shares ;

   //总市值（元）
    private float total_market_cap ;

   //流通市值（元）
    private float free_market_cap ;

   //个股总数
    private float listing_org_num ;

   //指数
    private float close_price ;

   //涨跌幅（%）
    private float change_rate ;

}

