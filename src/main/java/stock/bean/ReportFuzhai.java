package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReportFuzhai implements Serializable {

   //股票代码
    private String code ;

   //报告日期
    private String tdate ;

   //股票名称
    private String name ;

   //吸收存款（元）
    private float acceptdeposit ;

   //吸收存款同比（%）
    private float acceptdepositratio ;

   //应付账款（元）
    private float accountspayable ;

   //应付账款同比（%）
    private float accountspayableratio ;

   //应收账款（元）
    private float accountsrece ;

   //应收账款同比（%）
    private float accountsreceratio ;

   //预收保费（元）
    private float advancepremium ;

   //预收保费同比（%）
    private float advancepremiumratio ;

   //预收账款（元）
    private float advancereceivables ;

   //预收账款同比（%）
    private float advancereceivablesratio ;

   //代理买卖证券款（元）
    private float agenttradesecurity ;

   //可供出售金融资产（元）
    private float availablesalefinasset ;

   //存放中央银行款项（元）
    private float cashdepositpbc ;

   //资产负债同比（%）
    private float debtassetratio ;

   //行业名称
    private String industryname ;

   //存货（元）
    private float inventory ;

   //存货同比（%）
    private float inventoryratio ;

   //发放贷款及垫款（元）
    private float loanadvance ;

   //发放贷款及垫款同比（%）
    private float loanadvanceratio ;

   //向中央银行借款（元）
    private float loanpbc ;

   //向中央银行借款同比（%）
    private float loanpbcratio ;

   //货币资金（元）
    private float monetaryfunds ;

   //货币资金同比（%）
    private float monetaryfundsratio ;

   //公告日期
    private String noticedate ;

   //应收保费（元）
    private float premiumrece ;

   //应收保费同比（%）
    private float premiumreceratio ;

   //报告类型代码
    private String reporttypecode ;

   //代码简写
    private String secucode ;

   //卖出回购金融资产款（元）
    private float sellrepofinasset ;

   //结算备付金（元）
    private float settleexcessreserve ;

   //短期借款（元）
    private float shortloan ;

   //短期借款同比（%）
    private float shortloanratio ;

   //总资产（元）
    private float totalassets ;

   //总资产同比（%）
    private float totalassetsratio ;

   //股东权益合计（元）
    private float totalequity ;

   //总负债（元）
    private float totalliabilities ;

   //总负债同比（%）
    private float totalliabratio ;

}

