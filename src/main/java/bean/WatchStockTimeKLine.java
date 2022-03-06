package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class WatchStockTimeKLine implements Serializable {

   //股票代码
    private String code ;

   //交易时间
    private String tdate ;

   //股票名称
    private String name ;

   //最新价（元）
    private float price ;

   //最高价（元）
    private float high ;

   //最低价（元）
    private float low ;

   //今日开盘价（元）
    private float open ;

   //昨日收盘价（元）
    private float zrspj ;

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

   //市净率（%）
    private float sjlv ;

   //均价（元）
    private float jjia ;

   //量比
    private float lbi ;

   //委比（%）
    private float weibi ;

   //外盘（手）
    private float wpan ;

   //内盘（手）
    private float npan ;

   //市盈率（动态）
    private float dsyl ;

   //市盈率(静)
    private float jsyl ;

   //市盈率(TTM)
    private float ttmsyl ;

   //涨停价（元）
    private float ztj ;

   //跌停价（元）
    private float dtj ;

   //上市日期
    private String ssdate ;

   //ROE
    private float roe ;

   //总股本（股）
    private float zgb ;

   //流通股本（股）
    private float ltgb ;

   //流通市值（元）
    private float ltsz ;

   //总市值（元）
    private float zsz ;

   //每股收益（元）
    private float mgsy ;

   //5日涨幅（%）
    private float zf05 ;

   //10日涨幅（%）
    private float zf10 ;

   //20日涨幅（%）
    private float zf20 ;

   //60日涨幅（%）
    private float zf60 ;

   //今年以来涨幅（%）
    private float zfy ;

   //总营收（元）
    private float zys ;

   //总营收同比（%）
    private float zystb ;

   //净资产
    private float jzc ;

   //净利润
    private float jlr ;

   //毛利率
    private float mlil ;

   //净利率
    private float jlil ;

   //负债率
    private float fzl ;

   //每股未分配利润
    private float mgwfplr ;

   //每股净资产
    private float mgjzc ;

   //每股公积金（元）
    private float mggjj ;

   //今日主力净流入（元）
    private float zljlr ;

   //今日超大单流入（元）
    private float cddlr ;

   //今日超大单流出（元）
    private float cddlc ;

   //今日超大单净流入（元）
    private float cddjlr ;

   //今日大单流入（元）
    private float ddlr ;

   //今日大单流出（元）
    private float ddlc ;

   //今日大单净流入（元）
    private float ddjlr ;

   //今日中单流入（元）
    private float zdlr ;

   //今日中单流出（元）
    private float zdlc ;

   //今日中单净流入（元）
    private float zdjlr ;

   //今日小单流入（元）
    private float xdlr ;

   //今日小单流出（元）
    private float xdlc ;

   //今日小单净流入（元）
    private float xdjlr ;

}

