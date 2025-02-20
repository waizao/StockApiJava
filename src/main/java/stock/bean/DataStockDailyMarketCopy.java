package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataStockDailyMarketCopy implements Serializable {

   //股票代码
    private String code ;

   //交易时间
    private String tdate ;

   //最新价（元）
    private float price ;

   //涨跌幅度（%）
    private float zdfd ;

   //涨跌额度（元）
    private float zded ;

   //成交量（手）
    private float cjl ;

   //成交额（元）
    private float cje ;

   //振幅（%）
    private float zhfu ;

   //换手率（%）
    private float hslv ;

   //市盈率（动态）
    private float dsyl ;

   //量比
    private float lbi ;

   //股票名称
    private String name ;

   //最高价（元）
    private float zgj ;

   //最低价（元）
    private float zdj ;

   //今日开盘价（元）
    private float jrkpj ;

   //昨日收盘价（元）
    private float zrspj ;

   //总市值（元）
    private float zsz ;

   //流通市值（元）
    private float ltsz ;

   //市净率（%）
    private float sjlv ;

   //60日涨幅（%）
    private float zf60 ;

   //今年以来涨幅（%）
    private float zfy ;

   //上市日期
    private String ssdate ;

   //委比（%）
    private float weibi ;

   //外盘（手）
    private float wpan ;

   //内盘（手）
    private float npan ;

   //ROE
    private float roe ;

   //总股本（股）
    private float zgb ;

   //流通股本（股）
    private float ltgb ;

   //总营收（元）
    private float zys ;

   //总营收同比（%）
    private float zystb ;

   //净利润
    private float jlr ;

   //每股未分配利润
    private float mgwfplr ;

   //毛利率
    private float mlil ;

   //负债率
    private float fzl ;

   //股东权益
    private float z24 ;

   //每股公积金（元）
    private float mggjj ;

   //今日主力净流入-净额（元）
    private float zljlr ;

   //今日超大单流入（元）
    private float cddlr ;

   //今日超大单流出（元）
    private float cddlc ;

   //今日超大单净流入-净额（元）
    private float cddjlr ;

   //今日超大单净流入-净占比（%）
    private float z30 ;

   //今日大单流入（元）
    private float ddlr ;

   //今日大单流出（元）
    private float ddlc ;

   //今日大单净流入-净额（元）
    private float ddjlr ;

   //今日大单净流入-净占比（%）
    private float z33 ;

   //今日中单流入（元）
    private float zdlr ;

   //今日中单流出（元）
    private float zdlc ;

   //今日中单净流入-净额（元）
    private float zdjlr ;

   //今日中单净流入-净占比（%）
    private float z36 ;

   //今日小单流入（元）
    private float xdlr ;

   //今日小单流出（元）
    private float xdlc ;

   //今日小单净流入-净额（元）
    private float xdjlr ;

   //今日小单净流入-净占比（%）
    private float z39 ;

   //归属行业板块名称
    private String z50 ;

   //归属地域板块名称
    private String z52 ;

   //归属概念板块名称
    private String z53 ;

   //5日涨跌幅（%）
    private float zf05 ;

   //20日涨幅（%）
    private float zf20 ;

   //每股收益（元）
    private float mgsy ;

   //每股净资产
    private float mgjzc ;

   //市盈率（静）
    private float jsyl ;

   //市盈率（TTM）
    private float ttmsyl ;

   //3日涨跌幅（%）
    private float z71 ;

   //净利率
    private float jlil ;

   //市销率TTM
    private float z73 ;

   //市现率TTM
    private float z74 ;

   //总营业收入TTM
    private float z75 ;

   //股息率
    private String z76 ;

   //净资产
    private float jzc ;

   //净资产收益率TTM
    private float z79 ;

   //净利润TTM
    private float z80 ;

   //10日涨幅（%）
    private float zf10 ;

   //5日主力净流入-净额（元）
    private float z98 ;

   //5日主力净流入-净占比（%）
    private float z99 ;

   //5日超大单净流入-净额（元）
    private float z100 ;

   //5日超大单净流入-净占比（%）
    private float z101 ;

   //5日大单净流入-净额（元）
    private float z102 ;

   //5日大单净流入-净占比（%）
    private float z103 ;

   //5日中单净流入-净额（元）
    private float z104 ;

   //5日中单净流入-净占比（%）
    private float z105 ;

   //5日小单净流入-净额（元）
    private float z106 ;

   //5日小单净流入-净占比（%）
    private float z107 ;

   //10日主力净流入-净额（元）
    private float z108 ;

   //10日主力净流入-净占比（%）
    private float z109 ;

   //10日超大单净流入-净额（元）
    private float z110 ;

   //10日超大单净流入-净占比（%）
    private float z111 ;

   //10日大单净流入-净额（元）
    private float z112 ;

   //10日大单净流入-净占比（%）
    private float z113 ;

   //10日中单净流入-净额（元）
    private float z114 ;

   //10日中单净流入-净占比（%）
    private float z115 ;

   //10日小单净流入-净额（元）
    private float z116 ;

   //10日小单净流入-净占比（%）
    private float z117 ;

   //今日主力净流入-净占比（%）
    private float z118 ;

   //溢价（A/H）%
    private float z122 ;

   //比价（A/H）
    private float z123 ;

   //今日主力净流入最大股名称
    private String z137 ;

   //今日主力净流入最大股代码
    private String z138 ;

   //行业代码
    private String z197 ;

   //3日主力净流入-净额（元）
    private float z199 ;

   //3日主力净流入-净占比（%）
    private float z200 ;

   //3日超大单净流入-净额（元）
    private float z201 ;

   //3日超大单净流入-净占比（%）
    private float z202 ;

   //3日大单净流入-净额（元）
    private float z203 ;

   //3日大单净流入-净占比（%）
    private float z204 ;

   //3日中单净流入-净额（元）
    private float z205 ;

   //3日中单净流入-净占比（%）
    private float z206 ;

   //3日小单净流入-净额（元）
    private float z207 ;

   //3日小单净流入-净占比（%）
    private float z208 ;

   //涨停价（元）
    private float ztj ;

   //跌停价（元）
    private float dtj ;

   //均价（元）
    private float jjia ;

}

