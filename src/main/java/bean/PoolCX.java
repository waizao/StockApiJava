package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class PoolCX implements Serializable {

   //成交额（元）
    private float amount ;

   //股票代码，多个股票用逗号分隔，每次最多30个股票；若为all，则表示全部股票，可获取任意一天内的所有股票数据
    private String code ;

   //换手率（%）
    private float hs ;

   //所属行业
    private String hybk ;

   //上市日期
    private String ipod ;

   //流通市值（元）
    private float ltsz ;

   //0:深交所，1：上交所
    private int m ;

   //股票名称
    private String n ;

   //是否新高，0：否，1：新高
    private int nh ;

   //开板日期
    private String od ;

   //开板几日
    private int ods ;

   //最新价
    private float p ;

   //总市值（元）
    private float tshare ;

   //涨跌幅（%）
    private float zdp ;

   //涨停价
    private float ztf ;

   //涨停统计，n/m代表m天中有n次涨停板
    private String zttj ;

}

