package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class HSTradeDate implements Serializable {

   //交易时间
    private String tdate ;

   //交易日是周几（星期天是一周第一天）
    private int week ;

   //是否休市，0：休市，1：交易
    private int isopen ;

   //前一个交易日
    private String lastdate ;

   //后一个交易日
    private String nextdate ;

}

