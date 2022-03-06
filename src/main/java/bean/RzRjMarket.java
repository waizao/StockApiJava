package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class RzRjMarket implements Serializable {

   //市场类型
    private int mtype ;

   //交易时间
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

   //融资当日余额占流通市值比
    private float rzyezb ;

}

