package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataStockChengFenGu implements Serializable {

   //股票代码
    private String code ;

   //交易时间
    private String tdate ;

   //股票名称
    private String name ;

   //成分股数据，Json格式：{c：股票代码，n：股票名称，w：权重，t：加入日期}。备注：部分指数不提供权重或者加入日期
    private String cfg ;

}

