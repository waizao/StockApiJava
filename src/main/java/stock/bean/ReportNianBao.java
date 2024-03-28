package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReportNianBao implements Serializable {

   //股票代码
    private String code ;

   //报告日期
    private String tdate ;

   //股票名称
    private String name ;

   //利润分配
    private String assigndscrpt ;

   //每股收益（元）
    private float basiceps ;

   //每股净资产 （元）
    private float bps ;

   //报告描述
    private String datatype ;

   //报告年份
    private String datayear ;

   //报告类型
    private String datemmdd ;

   //每股经营现金流量（元）
    private float mgjyxjje ;

   //公告日期
    private String noticedate ;

   //净利润（元）
    private float parentnetprofit ;

   //所处行业
    private String publishname ;

   //季度
    private String qdate ;

   //代码简写
    private String secucode ;

   //股票类型
    private String securitytype ;

   //净利润-季度环比增长（%）
    private float sjlhz ;

   //净利润-同比增长（%）
    private float sjltz ;

   //营业总收入（元）
    private float totaloperateincome ;

   //交易所
    private String trademarket ;

   //最新公告日期
    private String updatedate ;

   //净资产收益率（%）
    private float weightavgroe ;

   //销售毛利率（%）
    private float xsmll ;

   //营业总收入-季度环比增长（%）
    private float yshz ;

   //营业总收入-同比增长（%）
    private float ystz ;

}

