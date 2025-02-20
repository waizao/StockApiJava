package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataShareTopHolder implements Serializable {

   //股票代码
    private String code ;

   //股票名称
    private String name ;

   //股东名称
    private String gname ;

   //股东类型，1：十大流动股东，2：十大股东
    private int gtype ;

   //报告期
    private String tdate ;

   //股东类型，包括个人、基金、QFII、社保、券商、信托
    private String a ;

   //期末持股-数量（股）
    private String b ;

   //期末持股-持股占流通股比（%）
    private String c ;

   //期末持股-数量变化（股）
    private String d ;

   //期末持股-数量变化比例（%）
    private String e ;

   //期末持股-流通市值（元）
    private String f ;

   //报告期名称
    private String g ;

}

