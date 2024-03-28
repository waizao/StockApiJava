package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReportLirun implements Serializable {

   //股票代码
    private String code ;

   //股票名称
    private String name ;

   //报告日期
    private String tdate ;

   //已赚保费（元）
    private float earnedpremium ;

   //手续费及佣金净收入（元）
    private float feecommissionni ;

   //财务费用（元）
    private float financeexpense ;

   //行业代码
    private String industrycode ;

   //行业名称
    private String industryname ;

   //利息净收入（元）
    private float interestni ;

   //投资收益（元）
    private float investincome ;

   //管理费用（元）
    private float manageexpense ;

   //公告日期
    private String noticedate ;

   //营业支出（元）
    private float operatecost ;

   //营业总支出（元）
    private float operateexpense ;

   //营业总支出同比（%）
    private float operateexpenseratio ;

   //营业总收入（元）
    private float operateincome ;

   //营业利润（元）
    private float operateprofit ;

   //营业利润同比（%）
    private float operateprofitratio ;

   //营业税金及附加（元）
    private float operatetaxadd ;

   //净利润（元）
    private float parentnetprofit ;

   //净利润同比（%）
    private float parentnetprofitratio ;

   //销售费用（元）
    private float saleexpense ;

   //代码简写
    private String secucode ;

   //营业总收入同比（%）
    private float toiratio ;

   //营业总支出（元）
    private float totaloperatecost ;

   //营业总收入（元）
    private float totaloperateincome ;

   //利润总额（元）
    private float totalprofit ;

}

