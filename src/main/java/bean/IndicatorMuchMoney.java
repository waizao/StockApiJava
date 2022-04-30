package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class IndicatorMuchMoney implements Serializable {

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

   //证券交易所
    private int jys ;

   //股票名称
    private String name ;

   //今日主力净流入-净占比（%）
    private float z118 ;

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

   //3日涨跌幅（%）
    private float z71 ;

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

   //5日涨跌幅（%）
    private float zf05 ;

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

   //10日涨幅（%）
    private float zf10 ;

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

}

