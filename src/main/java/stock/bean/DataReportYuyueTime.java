package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataReportYuyueTime implements Serializable {

   //股票代码
    private String code ;

   //报告日期
    private String tdate ;

   //股票名称
    private String name ;

   //实际披露时间
    private String actualpublishdate ;

   //预约披露时间
    private String appointpublishdate ;

   //首次预约时间
    private String firstappointdate ;

   //一次变更日期
    private String firstchangedate ;

   //是否披露
    private int ispublish ;

   //报告类型代码
    private String reporttype ;

   //报告类型名称
    private String reporttypename ;

   //报告年份
    private String reportyear ;

   //二次变更日期
    private String secondchangedate ;

   //代码简写
    private String secucode ;

   //三次变更日期
    private String thirdchangedate ;

   //交易所
    private String trademarket ;

}

