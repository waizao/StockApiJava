package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class RzRjHangye implements Serializable {

   //板块代码
    private String code ;

   //交易日期
    private String tdate ;

   //板块类型
    private int btcode ;

   //板块类型名称
    private String boardtype ;

   //融资-余额（元）
    private float finbalance ;

   //融资-余额占流通市值比
    private float finbalanceratio ;

   //融资-买入额（元）
    private float finbuyamt ;

   //融券-净买入（元）
    private float finnetbuyamt ;

   //融资-偿还额（元）
    private float finrepayamt ;

   //融券-净卖出（股）
    private float finnetsellamt ;

   //融券-余额（元）
    private float loanbalance ;

   //融券-余量（股）
    private float loanbalancevol ;

   //融券-净卖额（元）
    private float loannetsellamt ;

   //融券-偿还量（股）
    private float loanrepayvol ;

   //融券-卖出额
    private float loansellamt ;

   //融券-卖出量（股）
    private float loansellvol ;

   //融资融券余额（元）
    private float marginbalance ;

   //融资融券余额差值（元）
    private float finbalancediff ;

}

