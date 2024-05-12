package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class PoolDT implements Serializable {

   //交易时间
    private String tdate ;

   //成交额（元）
    private float amount ;

   //股票代码
    private String code ;

   //连续跌停
    private int days ;

   //板上成交额（元），成交价格为该股票跌停价的所有成交额的总和
    private float fba ;

   //封单资金（元）
    private float fund ;

   //换手率（%）
    private float hs ;

   //所属行业
    private String hybk ;

   //最后封板时间，个股最后一次触及涨（跌）停的时间
    private String lbt ;

   //流通市值（元）
    private float ltsz ;

   //0：深交所，1：上交所
    private int m ;

   //股票名称
    private String n ;

   //开板次数，个股打开跌停板的次数
    private int oc ;

   //动态市盈率
    private float pe ;

   //总市值（元）
    private float tshare ;

   //涨跌幅（%）
    private float zdp ;

   //更新时间
    private String wtime ;

}

