package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class SharePeoples implements Serializable {

   //股票代码
    private String code ;

   //股票名称
    private String name ;

   //股东户数统计截止日-本次
    private String tdate ;

   //股东户数-本次
    private String a ;

   //股东户数-上次
    private String b ;

   //股东户数-增减数
    private String c ;

   //股东户数统计截止日-上次
    private String d ;

   //户均持股市值（万）
    private String e ;

   //户均持股数量（万）
    private String f ;

   //总市值（亿）
    private String g ;

   //总股本（亿）
    private String h ;

}

