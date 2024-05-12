package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class StockYiDong implements Serializable {

   //股票代码
    private String code ;

   //异动类型，8201：火箭发射，8202：快速反弹，8207：竞价上涨，8209：高开5日线，8211：向上缺口，8215：60日大幅上涨，8204：加速下跌，8203：高台跳水，8208：竞价下跌，8210：低开5日线，8212：向下缺口，8216：60日大幅下跌，8193：大笔买入，8194：大笔卖出，64：有大买盘，128：有大卖盘，4：封涨停板，32：打开跌停板，8213：60日新高，8：封跌停板，16：打开涨停板，8214：60日新低
    private int ydtype ;

   //股票名称
    private String name ;

   //交易时间
    private String tdate ;

   //异动名称
    private String tname ;

   //异动信息
    private String info ;

   //更新时间
    private String wtime ;

}

