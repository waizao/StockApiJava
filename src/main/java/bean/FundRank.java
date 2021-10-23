package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class FundRank implements Serializable {

   //基金代码
    private String code ;

   //基金名称
    private String name ;

   //基金拼音名称
    private String jjjc ;

   //基金大类，0：场内基金 1：场外基金
    private int jjdl ;

   //基金类别
    private String jjlb ;

   //基金成立日期
    private String cdate ;

   //更新日期
    private String udate ;

   //基金单位净值
    private String nav ;

   //基金累计净值
    private String ljjz ;

   //日增长率
    private String rz ;

   //近1周增长率
    private String yzz ;

   //近1月增长率
    private String yyz ;

   //近3月增长率
    private String syz ;

   //近6月增长率
    private String lyz ;

   //近1年增长率
    private String ynz ;

   //近2年增长率
    private String lnz ;

   //近3年增长率
    private String snz ;

   //今年来增长率
    private String jnz ;

   //成立来增长率
    private String clz ;

}

