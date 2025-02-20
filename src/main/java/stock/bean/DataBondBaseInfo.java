package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataBondBaseInfo implements Serializable {

   //债券代码
    private String code ;

   //债券简称
    private String name ;

   //发行规模（亿元）
    private float actualissuescale ;

   //中签号发布日
    private String bondstartdate ;

   //正股代码
    private String convertstockcode ;

   //正股价
    private float convertstockprice ;

   //申购代码
    private String correcode ;

   //债现价
    private float currentbondprice ;

   //到期时间
    private String expiredate ;

   //每股配售额
    private float firstperpreplacing ;

   //利率
    private String interestrateexplain ;

   //发行对象
    private String issueobject ;

   //上市时间
    private String listingdate ;

   //申购上限 （万元）
    private float onlinegeneralaau ;

   //中签率（%）
    private float onlinegenerallwr ;

   //发行说明
    private String paramname ;

   //申购日期
    private String publicstartdate ;

   //评级
    private String rating ;

   //赎回条款
    private String redeemclause ;

   //配售说明
    private String remark ;

   //转售条款
    private String resaleclause ;

   //代码简写
    private String secucode ;

   //正股简称
    private String securityshortname ;

   //股权登记日
    private String securitystartdate ;

   //转股溢价率
    private float transferpremiumratio ;

   //转股价
    private float transferprice ;

   //转股价值
    private float transfervalue ;

}

