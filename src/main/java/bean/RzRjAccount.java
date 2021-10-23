package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class RzRjAccount implements Serializable {

   //交易日期
    private String tdate ;

   //平均维持担保比例
    private float pjdbbl ;

   //融资余额(亿)
    private float rzye ;

   //融资买入额(亿)
    private float rzmre ;

   //参与交易的投资者数量(人)
    private float jytzz ;

   //融券余额(亿)
    private float rjye ;

   //融券卖出额(亿)
    private float rjmce ;

   //有融资融券负债的投资者数量(万名)
    private float fztzz ;

   //营业部数量(家)
    private float yyb ;

   //机构投资者数量(家)
    private float jgtzz ;

   //个人投资者数量(万名)
    private float grtzz ;

   //证券公司数量(家)
    private float zjgs ;

   //担保物总价值(亿)
    private float dbw ;

}

