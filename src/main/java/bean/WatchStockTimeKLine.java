package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class WatchStockTimeKLine implements Serializable {

   //股票代码，多个股票用逗号分隔，每次最多30个股票；若为all，则表示全部股票，可获取任意一天内的所有股票数据
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

   //开盘价（元）
    private float open ;

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

}

