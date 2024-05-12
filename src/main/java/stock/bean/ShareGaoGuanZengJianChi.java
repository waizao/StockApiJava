package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class ShareGaoGuanZengJianChi implements Serializable {

   //股票代码
    private String code ;

   //股票名称
    private String name ;

   //变动人
    private String gname ;

   //变动日期
    private String tdate ;

   //成交均价
    private String a ;

   //变动金额（万）
    private String b ;

   //变动原因
    private String c ;

   //变动比例（‰）
    private String d ;

   //变动后持股数
    private String e ;

   //董监高人员姓名
    private String f ;

   //职务
    private String g ;

   //变动人与董监高的关系
    private String h ;

}

