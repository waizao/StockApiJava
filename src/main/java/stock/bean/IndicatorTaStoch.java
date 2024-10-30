package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class IndicatorTaStoch implements Serializable {

   //股票代码
    private String code ;

   //交易时间
    private String tdate ;

   //K指标值，J指标值=3*K-2*D
    private String output1 ;

   //D指标值，J指标值=3*K-2*D
    private String output2 ;

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

   //换手率，日线、周线、月线有换手率，其余无换手率参数值。
    private float hsl ;

}

