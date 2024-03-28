package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class IndicatorTaRSI implements Serializable {

   //股票代码
    private String code ;

   //交易时间
    private String tdate ;

   //rsi值，多个RSI之间用逗号分割。
    private String rsi ;

   //开盘价
    private float open ;

   //收盘价
    private float close ;

   //最高价
    private float high ;

   //最低价
    private float low ;

   //成交量
    private float cjl ;

   //成交额
    private float cje ;

   //换手率，日线、周线、月线有换手率，其余无换手率参数。
    private float hsl ;

}

