package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class HSGTStockRank implements Serializable {

   //股票代码，多个股票用逗号分隔，每次最多30个股票；若为all，则表示全部股票，可获取任意一天内的所有股票数据
    private String code ;

   //股票名称
    private String name ;

   //排行类别
    private int rtype ;

   //交易时间
    private String tdate ;

   //今日收盘价
    private float open ;

   //今日涨跌幅
    private float zdf ;

   //今日持股-股数
    private float gs ;

   //今日持股-市值
    private float sz ;

   //今日持股-占流通股比
    private float zltgb ;

   //今日持股-占总股本比
    private float zzgbb ;

   //今日增持估计-股数
    private float zcgs ;

   //今日增持估计-市值
    private float zcsz ;

   //今日增持估计-市值增幅
    private float zczf ;

   //今日增持估计-占流通股比(‰)
    private float zcltg ;

   //今日增持估计-占总股本比(‰)
    private float zczgb ;

   //行业名称
    private String hyname ;

   //行业代码
    private String hycode ;

}

