package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class FundPosition implements Serializable {

   //基金代码，多个基金用逗号分隔，不支持All参数
    private String code ;

   //基金名称
    private String name ;

   //公布日期
    private String tdate ;

   //股票代码，多个股票用逗号分隔，每次最多30个股票；若为all，则表示全部股票，可获取任意一天内的所有股票数据
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

