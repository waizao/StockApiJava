package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataShareJieJin implements Serializable {

   //股票代码
    private String code ;

   //股票简称
    private String name ;

   //解禁时间
    private String tdate ;

   //解禁数量（股）
    private String a ;

   //实际解禁数量（股）
    private String b ;

   //实际解禁市值（元）
    private String c ;

   //占解禁前流通市值比例（%）
    private String d ;

   //限售股类型
    private String e ;

}

