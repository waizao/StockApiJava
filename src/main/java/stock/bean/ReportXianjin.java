package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReportXianjin implements Serializable {

   //股票代码
    private String code ;

   //股票名称
    private String name ;

   //报告日期
    private String tdate ;

   //净现金流（元）
    private float cceadd ;

   //净现金流同比增长（%）
    private float cceaddratio ;

   //融资性现金流量净额（元）
    private float netcashfinance ;

   //融资性净现金流占比（%）
    private float netcashfinanceratio ;

   //投资性现金流量净额（元）
    private float netcashinvest ;

   //投资性净现金流占比（%）
    private float netcashinvestratio ;

   //经营性现金流量净额（元）
    private float netcashoperate ;

   //经营性净现金流占比（%）
    private float netcashoperateratio ;

}

