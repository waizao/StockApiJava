package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataLonghbActive implements Serializable {

   //营业机构代码
    private String operatedeptcode ;

   //上榜日期
    private String tdate ;

   //机构名称
    private String operatedeptname ;

   //买入个股数
    private float buyerappearnum ;

   //机构买入个股代码
    private String buystock ;

   //机构简称
    private String orgnameabbr ;

   //机构买入个股名称
    private String securitynameabbr ;

   //卖出个股数
    private float sellerappearnum ;

   //买入总金额（万）
    private float totalbuyamt ;

   //总买卖净额（万）
    private float totalnetamt ;

   //卖出总金额（万）
    private float totalsellamt ;

}

