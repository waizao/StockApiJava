package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataStockAHComparePrice implements Serializable {

   //港股代码
    private String code ;

   //股票名称
    private String name ;

   //A股代码
    private String acode ;

   //港股-最新价（HKD）
    private float a ;

   //A股-最新价（RMB）
    private float b ;

   //溢价（A/H）%
    private float d ;

}

