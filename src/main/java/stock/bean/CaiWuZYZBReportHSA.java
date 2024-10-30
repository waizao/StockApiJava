package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class CaiWuZYZBReportHSA implements Serializable {

   //股票代码
    private String code ;

   //报告类型
    private int mtype ;

   //报告日期
    private String tdate ;

   //不良贷款拨备覆盖率（%）
    private float bldkbbl ;

   //每股净资产（元）
    private float bps ;

   //存货周转率（次）
    private float chzzl ;

   //存货周转天数（天）
    private float chzzts ;

   //产权比率
    private float cqbl ;

   //基本每股收益（元）
    private float epsjb ;

   //扣非每股收益（元）
    private float epskcjb ;

   //稀释每股收益（元）
    private float epsxs ;

   //贷款总额（元）
    private float grossloans ;

   //核心资本充足率（%）
    private float hxyjbczl ;

   //经营净现金流/营业总收入
    private float jyxjlyysr ;

   //扣非净利润（元）
    private float kcfjcxsyjlr ;

   //扣非净利润同比增长（%）
    private float kcfjcxsyjlrtz ;

   //扣非净利润滚动环比增长（%）
    private float kfjlrgdhbzc ;

   //流动比率
    private float ld ;

   //存贷款比例
    private float ltdrr ;

   //每股经营现金流（元）
    private float mgjyxjje ;

   //每股未分配利润（元）
    private float mgwfplr ;

   //每股公积金（元）
    private float mgzbgj ;

   //毛利润（元）
    private float mlr ;

   //归属净利润滚动环比增长（%）
    private float netprofitrphbzc ;

   //资本充足率（%）
    private float newcapitalader ;

   //不良贷款率（%）
    private float nonperloan ;

   //通知日期
    private String noticedate ;

   //资本净额（元）
    private float nzbje ;

   //行业
    private String orgtype ;

   //归属净利润（元）
    private float parentnetprofit ;

   //归属净利润同比增长（%）
    private float parentnetprofittz ;

   //权益乘数
    private float qycs ;

   //报告名称
    private String reportdatename ;

   //净资产收益率（加权）（%）
    private float roejq ;

   //净资产收益率（扣非/加权）（%）
    private float roekcjq ;

   //速动比率
    private float sd ;

   //股票名称
    private String name ;

   //实际税率（%）
    private float taxrate ;

   //总资产周转率（次）
    private float toazzl ;

   //存款总额（元）
    private float totaldeposits ;

   //营业总收入（元）
    private float totaloperatereve ;

   //营业总收入同比增长（%）
    private float totaloperaterevetz ;

   //现金流量比率
    private float xjllb ;

   //净利率（%）
    private float xsjll ;

   //销售净现金流/营业总收入
    private float xsjxlyysr ;

   //毛利率（%）
    private float xsmll ;

   //预收账款/营业总收入
    private float yszkyysr ;

   //应收账款周转率（次）
    private float yszkzzl ;

   //应收账款周转天数（天）
    private float yszkzzts ;

   //营业总收入滚动环比增长（%）
    private float yyzsrgdhbzc ;

   //资产负债率（%）
    private float zcfzl ;

   //总资产收益率（加权）（%）
    private float zzcjll ;

   //总资产周转天数（天）
    private float zzczzts ;

}

