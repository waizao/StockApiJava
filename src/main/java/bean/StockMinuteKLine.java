package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class StockMinuteKLine implements Serializable {

   //股票代码
    private String code ;

   //分时时间
    private String tdate ;

   //开盘价
    private float open ;

   //收盘价
    private float close ;

   //最高价
    private float high ;

   //最低价
    private float low ;

   //成交量（手）
    private float cjl ;

   //成交额（元）
    private float cje ;

   //成交均价
    private float cjjj ;

}

