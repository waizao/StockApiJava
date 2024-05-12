package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class MarketView implements Serializable {

   //交易时间
    private String tdate ;

   //两市-总成交额
    private float mz ;

   //两市-总股票数
    private int mn ;

   //上证-主板-上市股票数量
    private int shzn ;

   //上证-主板-市价总值（亿元）
    private float shzz ;

   //上证-主板-流通市值（亿元）
    private float shzl ;

   //上证-主板-成交金额（亿元）
    private float shzc ;

   //上证-主板-成交量（亿股/亿份）
    private float shzj ;

   //上证-主板-平均市盈率（倍）
    private float shzs ;

   //上证-科创板-上市股票数量
    private int shkn ;

   //上证-科创板-市价总值（亿元）
    private float shkz ;

   //上证-科创板-流通市值（亿元）
    private float shkl ;

   //上证-科创板-成交金额（亿元）
    private float shkc ;

   //上证-科创板-成交量（亿股/亿份）
    private float shkj ;

   //上证-科创板-平均市盈率（倍）
    private float shks ;

   //深证-主板-上市股票数量
    private int szzn ;

   //深证-主板-市价总值（亿元）
    private float szzz ;

   //深证-主板-流通市值（亿元）
    private float szzl ;

   //深证-主板-成交金额（亿元）
    private float szzc ;

   //深证-主板-成交量（亿股/亿份）
    private float szzj ;

   //深证-主板-平均市盈率（倍）
    private float szzs ;

   //深证-创业板-上市股票数量
    private int szcn ;

   //深证-创业板-市价总值（亿元）
    private float szcz ;

   //深证-创业板-流通市值（亿元）
    private float szcl ;

   //深证-创业板-成交金额（亿元）
    private float szcc ;

   //深证-创业板-成交量（亿股/亿份）
    private float szcj ;

   //深证-创业板-平均市盈率（倍）
    private float szcs ;

}

