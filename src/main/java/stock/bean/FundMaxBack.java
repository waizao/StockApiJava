package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class FundMaxBack implements Serializable {

   //基金代码
    private String code ;

   //股票名称
    private String name ;

   //基金最大回撤率
    private float maxBack ;

   //基金最大净值日期
    private String maxNavDate ;

   //基金最小净值日期
    private String minNavDate ;

   //基金累计净值最大值
    private float maxNavValue ;

   //基金累计净值最小值
    private float minNavValue ;

}

