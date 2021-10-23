package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class RzRjStock implements Serializable {

   //股票代码
    private String code ;

   //股票名称
    private String name ;

   //交易日期
    private String tdate ;

   //融券偿还量(股)
    private float rqchl ;

   //融券净卖出(股)
    private float rqjmg ;

   //融券卖出量(股)
    private float rqmcl ;

   //融券当日余额(元)
    private float rqye ;

   //融券当日余量(股)
    private float rqyl ;

   //融资偿还额(元)
    private float rzche ;

   //融资净买入(元)
    private float rzjme ;

   //融资买入额(元)
    private float rzmre ;

   //融资融券余额(元)
    private float rzrqye ;

   //融资融券余额差值(元)
    private float rzrqyecz ;

   //融资当日余额(元)
    private float rzye ;

   //交易所
    private String trademarket ;

}

