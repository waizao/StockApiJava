package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class FuQuanYinZi implements Serializable {

   //股票代码
    private String code ;

   //股票名称
    private String name ;

   //资产类别，1|沪深A股
    private int type ;

   //复权信息
    private int fq ;

   //除权出息日期
    private String tdate ;

   //复权因子
    private String fqfactor ;

}

