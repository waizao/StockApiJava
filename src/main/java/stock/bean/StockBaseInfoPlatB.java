package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class StockBaseInfoPlatB implements Serializable {

   //股票代码
    private String code ;

   //股票名称
    private String name ;

}

