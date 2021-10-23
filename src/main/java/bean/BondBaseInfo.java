package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class BondBaseInfo implements Serializable {

   //债券代码
    private String code ;

   //债券简称
    private String name ;

   //申购日期
    private String sgdate ;

   //申购代码
    private String sgcode ;

   //申购上限
    private float sglimit ;

   //信用评级
    private String xypj ;

   //正股代码
    private String zgcode ;

   //正股简称
    private String zgname ;

   //正股价
    private float zgprice ;

   //转股价
    private float ggprice ;

   //转股价值
    private float zgvalue ;

   //债现价
    private float zxprice ;

   //转股溢价率
    private float zgyjl ;

   //每股配售额
    private float mgpse ;

   //回售触发价
    private float hscfj ;

   //强赎触发价
    private float qscfj ;

   //转股价(元)
    private float zgj ;

   //正股市净率
    private float pb ;

   //中签号发布日
    private String zqhfbr ;

   //中签率(%)
    private float zjl ;

   //发行规模（亿元）
    private float gxgm ;

   //上市时间
    private String ssdate ;

}

