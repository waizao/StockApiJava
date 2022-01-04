package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class GZMarket implements Serializable {

   //市场代码，多个市场用逗号分隔；若为all，则表示全部市场，可获取任意一天内的所有市场数据
    private String code ;

   //市场名称
    private String name ;

   //交易时间
    private String tdate ;

   //平均市盈率
    private float pe_ttm_avg ;

   //总股本(股)
    private float total_shares ;

   //流通股本(股)
    private float free_shares ;

   //总市值(元)
    private float total_market_cap ;

   //流通市值(元)
    private float free_market_cap ;

   //个股总数
    private float listing_org_num ;

   //指数
    private float close_price ;

   //涨跌幅(%)
    private float change_rate ;

}

