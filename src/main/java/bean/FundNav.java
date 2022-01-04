package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class FundNav implements Serializable {

   //基金代码，多个基金用逗号分隔，每次最多30个基金；若为all，则表示全部基金，可获取任意一天内的所有基金数据
    private String code ;

   //净值日期
    private String tdate ;

   //基金单位净值
    private String nav ;

   //基金累计净值
    private String ljjz ;

   //日增长率(%)
    private String rzgl ;

   //申购状态
    private String sgzt ;

   //赎回状态
    private String shzt ;

   //分红金额
    private String fhje ;

   //分红描述
    private String fhms ;

}

