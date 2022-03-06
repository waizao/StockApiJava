package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class TradeDate implements Serializable {

   //市场类型
    private int mtype ;

   //交易时间
    private String tdate ;

   //是否休市，1：半天休市，2：全体休市，3：交易
    private int isopen ;

   //市场名称
    private String mkt ;

   //休市原因
    private String holiday ;

}

