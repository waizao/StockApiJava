package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class PoolZB implements Serializable {

   //交易日期
    private String tdate ;

   //成交额（元）
    private float amount ;

   //股票代码，多个股票用逗号分隔，每次最多30个股票；若为all，则表示全部股票，可获取任意一天内的所有股票数据
    private String code ;

   //首次封板时间，个股第一次触及涨（跌）停的时间
    private String fbt ;

   //换手率（%）
    private float hs ;

   //所属行业
    private String hybk ;

   //流通市值（元）
    private float ltsz ;

   //0:深交所，1：上交所
    private int m ;

   //股票名称
    private String n ;

   //最新价
    private float p ;

   //总市值（元）
    private float tshare ;

   //炸板次数，个股打开涨停板的次数
    private int zbc ;

   //涨跌幅（%）
    private float zdp ;

   //振幅（%）
    private float zf ;

   //涨速（三分钟涨跌幅）
    private float zs ;

   //涨停价
    private float ztp ;

   //涨停统计，n/m代表m天中有n次涨停板
    private String zttj ;

}

