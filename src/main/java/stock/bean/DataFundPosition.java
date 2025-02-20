package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataFundPosition implements Serializable {

   //基金代码
    private String code ;

   //基金名称
    private String name ;

   //公布日期
    private String tdate ;

   //股票代码
    private String scode ;

   //股票名称
    private String sname ;

   //占净值比例
    private String zjzbl ;

   //持股数（万股）
    private String cgs ;

   //持仓市值（万元）
    private String ccsz ;

}

