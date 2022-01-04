package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class FundBaseInfo implements Serializable {

   //基金代码，多个基金用逗号分隔，每次最多30个基金；若为all，则表示全部基金，可获取任意一天内的所有基金数据
    private String code ;

   //基金名称
    private String name ;

   //基金类别
    private String jjlb ;

   //基金成立日期
    private String clrq ;

   //基金成立规模
    private String clgm ;

   //资产规模
    private String zcgm ;

   //份额规模
    private String fegm ;

   //管理人
    private String glr ;

   //托管人
    private String tgr ;

   //经理人
    private String jlr ;

   //历史分红
    private String lsfh ;

   //管理费
    private String glf ;

   //托管费
    private String fgf ;

}

