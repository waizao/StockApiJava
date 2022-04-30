package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class StockReName implements Serializable {

   //股票代码
    private String code ;

   //更名时间
    private String tdate ;

   //公司名称
    private String changeafterfn ;

   //股票安全代码
    private String secucode ;

   //类别
    private String securitytype ;

}

