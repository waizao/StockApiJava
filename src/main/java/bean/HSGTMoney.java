package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class HSGTMoney implements Serializable {

   //资金类别
    private int mtype ;

   //资金名称
    private String name ;

   //K线类别
    private int ktype ;

   //交易时间
    private String tdate ;

   //净流入（万元）
    private float jlr ;

   //资金余额（万元）
    private float zjye ;

   //累计净流入（万元）
    private float ljjlr ;

}

