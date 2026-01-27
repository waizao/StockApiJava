package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataStockHistory implements Serializable {

   //股票代码
    private String code ;

   //交易时间
    private String tdate ;

   //股票名称
    private String name ;

}

