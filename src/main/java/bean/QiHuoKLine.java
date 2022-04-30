package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class QiHuoKLine implements Serializable {

   //交易所代码
    private int jyscode ;

   //交易所名称
    private String jysname ;

   //品种代码
    private String pzcode ;

   //合约代码
    private String code ;

   //合约名称
    private String name ;

   //交易时间
    private String tdate ;

   //最新价
    private float zxj ;

   //涨跌额
    private float zde ;

   //涨跌幅
    private float zdf ;

   //今开
    private float jk ;

   //最高
    private float zg ;

   //最低
    private float zd ;

   //昨结
    private float zjsj ;

   //成交量
    private float cjl ;

   //成交额
    private float cje ;

   //买盘(外盘)
    private float wp ;

   //卖盘(内盘)
    private float np ;

   //持仓量
    private float ccl ;

}

