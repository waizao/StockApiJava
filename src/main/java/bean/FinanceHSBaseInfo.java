package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class FinanceHSBaseInfo implements Serializable {

   //股票代码
    private String code ;

   //股票名称
    private String name ;

   //报告类型
    private int mtype ;

   //报告日期
    private String tdate ;

   //基本每股收益(元)
    private float epsjb ;

   //扣非每股收益(元)
    private float epskcjb ;

   //稀释每股收益(元)
    private float epsxs ;

   //每股净资产(元)
    private float bps ;

   //每股公积金(元)
    private float mgzbgj ;

   //每股未分配利润(元)
    private float mgwfplr ;

   //每股经营现金流(元)
    private float mgjyxjje ;

   //营业总收入(元)
    private float totaloperatereve ;

   //毛利润(元)
    private float mlr ;

   //归属净利润(元)
    private float parentnetprofit ;

   //扣非净利润(元)
    private float kcfjcxsyjlr ;

   //营业总收入同比增长(%)
    private float totaloperaterevetz ;

   //归属净利润同比增长(%)
    private float parentnetprofittz ;

   //扣非净利润同比增长(%)
    private float kcfjcxsyjlrtz ;

   //营业总收入滚动环比增长(%)
    private float yyzsrgdhbzc ;

   //归属净利润滚动环比增长(%)
    private float netprofitrphbzc ;

   //扣非净利润滚动环比增长(%)
    private float kfjlrgdhbzc ;

   //净资产收益率(加权)(%)
    private float roejq ;

   //净资产收益率(扣非/加权)(%)
    private float roekcjq ;

   //总资产收益率(加权)(%)
    private float zzcjll ;

   //毛利率(%)
    private float xsmll ;

   //净利率(%)
    private float xsjll ;

   //预收账款/营业总收入
    private float yszkyysr ;

   //销售净现金流/营业总收入
    private float xsjxlyysr ;

   //经营净现金流/营业总收入
    private float jyxjlyysr ;

   //实际税率(%)
    private float taxrate ;

   //流动比率
    private float ld ;

   //速动比率
    private float sd ;

   //现金流量比率
    private float xjllb ;

   //资产负债率(%)
    private float zcfzl ;

   //权益乘数
    private float qycs ;

   //产权比率
    private float cqbl ;

   //总资产周转天数(天)
    private float zzczzts ;

   //存货周转天数(天)
    private float chzzts ;

   //应收账款周转天数(天)
    private float yszkzzts ;

   //总资产周转率(次)
    private float toazzl ;

   //存货周转率(次)
    private float chzzl ;

   //应收账款周转率(次)
    private float yszkzzl ;

   //存款总额(元)
    private float totaldeposits ;

   //贷款总额(元)
    private float grossloans ;

   //存贷款比例
    private float ltdrr ;

   //资本充足率(%)
    private float newcapitalader ;

   //核心资本充足率(%)
    private float hxyjbczl ;

   //不良贷款率(%)
    private float nonperloan ;

   //不良贷款拨备覆盖率(%)
    private float bldkbbl ;

   //资本净额(元)
    private float nzbje ;

   //总投资收益率(%)
    private float total_roi ;

   //净投资收益率(%)
    private float net_roi ;

   //已赚保费(元)
    private float earned_premium ;

   //赔付支出(元)
    private float compensate_expense ;

   //退保率(%)
    private float surrender_rate_life ;

   //偿付能力充足率(%)
    private float solvency_ar ;

   //净资本(元)
    private float jzb ;

   //净资产(元)
    private float jzc ;

   //净资本/净资产
    private float jzbjzc ;

   //自营股票规模/净资产
    private float zygpgmjzc ;

   //自营固定收益类证券规模/净资产
    private float zygdsylzqjzb ;

   //营运风险准备(元)
    private float yyfxzb ;

   //经纪业务风险准备(元)
    private float jjywfxzb ;

   //证券自营业务风险准备(元)
    private float zqzyywfxzb ;

   //证券承销业务风险准备(元)
    private float zqcxywfxzb ;

}

