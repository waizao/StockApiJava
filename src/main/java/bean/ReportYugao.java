package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReportYugao implements Serializable {

   //股票代码
    private String code ;

   //报告日期
    private String tdate ;

   //股票名称
    private String name ;

   //业绩变动幅度-下限（%）
    private float addamplower ;

   //业绩变动幅度-上限（%）
    private float addampupper ;

   //业绩变动原因
    private String changereasonexplain ;

   //公告日期
    private String noticedate ;

   //预测净利润-下限
    private float predictamtlower ;

   //预测净利润-上限
    private float predictamtupper ;

   //业绩变动
    private String predictcontent ;

   //预测指标
    private String predictfinance ;

   //预告类型
    private String predicttype ;

   //上年同期值(元)
    private float preyearsameperiod ;

   //代码简写
    private String secucode ;

   //股票类型
    private String securitytype ;

   //交易所
    private String trademarket ;

}

