package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataStockLevel2TimeDeal implements Serializable {

   //股票代码
    private String code ;

   //分时时间
    private String tdate ;

   //成交价
    private float price ;

   //成交量（手）
    private float cjl ;

   //相对于上个价位走势，1表示下跌或持平，2表示上涨或持平
    private int trend ;

}

