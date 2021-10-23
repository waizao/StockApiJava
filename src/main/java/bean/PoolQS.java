package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class PoolQS implements Serializable {

   //交易日期
    private String tdate ;

   //成交额（元）
    private float amount ;

   //股票代码
    private String code ;

   //入选理由，1：60日新高，2：近期多次涨停，3：60日新高且近期多次涨停
    private int cc ;

   //换手率（%）
    private float hs ;

   //所属行业
    private String hybk ;

   //量比
    private float lb ;

   //流通市值（元）
    private float ltsz ;

   //0:深交所，1：上交所
    private int m ;

   //股票名称
    private String n ;

   //是否新高，0：否，1：新高
    private int nh ;

   //最新价
    private float p ;

   //总市值（元）
    private float tshare ;

   //涨跌幅（%）
    private float zdp ;

   //涨速，三分钟涨跌幅
    private float zs ;

   //涨停价
    private float ztp ;

   //涨停统计，n/m代表m天中有n次涨停板
    private String zttj ;

}

