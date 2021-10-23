package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class FundNav implements Serializable {

   //基金代码
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

