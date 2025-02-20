package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataReportKuaiBao implements Serializable {

   //股票代码
    private String code ;

   //报告日期
    private String tdate ;

   //股票名称
    private String name ;

   //每股收益（元）
    private float basiceps ;

   //报告描述
    private String datatype ;

   //净利润-季度环比增长（%）
    private float djdjlhz ;

   //营业总收入-季度环比增长（%）
    private float djdyshz ;

   //净利润-同比增长（%）
    private float jlrtbzcl ;

   //公告日期
    private String noticedate ;

   //每股净资产（元）
    private float parentbvps ;

   //净利润（元）
    private float parentnetprofit ;

   //净利润-去年同期（元）
    private float parentnetprofitsq ;

   //所处行业
    private String publishname ;

   //代码简写
    private String secucode ;

   //股票类型
    private String securitytype ;

   //营业总收入（元）
    private float totaloperateincome ;

   //营业总收入-去年同期（元）
    private float totaloperateincomesq ;

   //交易所
    private String trademarket ;

   //最新公告日期
    private String updatedate ;

   //净资产收益率 （%）
    private float weightavgroe ;

   //营业总收入-同比增长（%）
    private float ystz ;

}

