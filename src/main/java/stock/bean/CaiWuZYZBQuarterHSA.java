package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class CaiWuZYZBQuarterHSA implements Serializable {

   //股票代码
    private String code ;

   //报告日期
    private String tdate ;

   //每股净资产（元）
    private float bps ;

   //扣非净利润（元）
    private float deduparentprofit ;

   //扣非净利润同比增长（%）
    private float dpnpyoyratio ;

   //基本每股收益（元）
    private float epsjb ;

   //毛利润（元）
    private float grossprofit ;

   //毛利率（%）
    private float grossprofitratio ;

   //摊薄总资产收益率（%）
    private float jroa ;

   //扣非净利润滚动环比增长（%）
    private float kfjlrgdhbzc ;

   //归属净利润滚动环比增长（%）
    private float netprofitrphbzc ;

   //净利率（%）
    private float netprofitratio ;

   //归属净利润（元）
    private float parentnetprofit ;

   //归属净利润同比增长（%）
    private float parentnetprofittz ;

   //每股公积金（元）
    private float percapitalreserve ;

   //每股经营现金流（元）
    private float pernetcash ;

   //每股未分配利润（元）
    private float perunassignprofit ;

   //摊薄净资产收益率（%）
    private float roediluted ;

   //营业总收入（元）
    private float totaloperatereve ;

   //营业总收入同比增长（%）
    private float totaloperaterevetz ;

   //营业总收入滚动环比增长（%）
    private float yyzsrgdhbzc ;

}

