package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class IndicatorTaROC implements Serializable {

   //股票代码
    private String code ;

   //交易时间
    private String tdate ;

   //roc值
    private float roc ;

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

   //换手率，仅日线、周线、月线有换手率。
    private float hsl ;

}

