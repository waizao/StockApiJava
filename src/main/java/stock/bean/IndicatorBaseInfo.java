package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class IndicatorBaseInfo implements Serializable {

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

   //市盈率TTM
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

   //涨速
    private float z4 ;

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

   //涨停价（元）
    private float ztj ;

   //跌停价（元）
    private float dtj ;

   //均价（元）
    private float jjia ;

}

