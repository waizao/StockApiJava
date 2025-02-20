package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataStockZhuLi implements Serializable {

   //股票代码
    private String code ;

   //股票名称
    private String name ;

   //报告期
    private String tdate ;

   //基金-持有家数
    private String aa ;

   //基金-持股总数（股）
    private String ab ;

   //基金-占总股本比例（%）
    private String ac ;

   //基金-持股市值（元）
    private String ad ;

   //基金-持股变化
    private String ae ;

   //基金-持股变动数值（股）
    private String af ;

   //基金-持股变动比例（%）
    private String ag ;

   //QFII-持有家数
    private String ba ;

   //QFII-持股总数（万股）
    private String bb ;

   //QFII-占总股本比例（%）
    private String bc ;

   //QFII-持股市值（亿元）
    private String bd ;

   //QFII-持股变化
    private String be ;

   //QFII-持股变动数值（万股）
    private String bf ;

   //QFII-持股变动比例（%）
    private String bg ;

   //社保-持有家数
    private String ca ;

   //社保-持股总数（万股）
    private String cb ;

   //社保-占总股本比例（%）
    private String cc ;

   //社保-持股市值（亿元）
    private String cd ;

   //社保-持股变化
    private String ce ;

   //社保-持股变动数值（万股）
    private String cf ;

   //社保-持股变动比例（%）
    private String cg ;

   //券商-持有家数
    private String da ;

   //券商-持股总数（万股）
    private String db ;

   //券商-占总股本比例（%）
    private String dc ;

   //券商-持股市值（亿元）
    private String dd ;

   //券商-持股变化
    private String de ;

   //券商-持股变动数值（万股）
    private String df ;

   //券商-持股变动比例（%）
    private String dg ;

   //保险-持有家数
    private String ea ;

   //保险-持股总数（万股）
    private String eb ;

   //保险-占总股本比例（%）
    private String ec ;

   //保险-持股市值（亿元）
    private String ed ;

   //保险-持股变化
    private String ee ;

   //保险-持股变动数值（万股）
    private String ef ;

   //保险-持股变动比例（%）
    private String eg ;

   //信托-持有家数
    private String fa ;

   //信托-持股总数（万股）
    private String fb ;

   //信托-占总股本比例（%）
    private String fc ;

   //信托-持股市值（亿元）
    private String fd ;

   //信托-持股变化
    private String fe ;

   //信托-持股变动数值（万股）
    private String ff ;

   //信托-持股变动比例（%）
    private String fg ;

}

