package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class ShareZengJianChi implements Serializable {

   //股票代码
    private String code ;

   //股票名称
    private String name ;

   //股东名称
    private String gname ;

   //变动截止日
    private String tdate ;

   //变动后持股情况-持股总数（万股）
    private String a ;

   //变动后持股情况-占总股本比例
    private String b ;

   //变动后持股情况-变动数量（万股）
    private String c ;

   //变动后持股情况-占流通股比例
    private String d ;

   //增减方向
    private String e ;

   //持股变动信息-持流通股数（万股）
    private String f ;

   //持股变动信息-占流通股比例
    private String g ;

   //持股变动信息-占总股本比例
    private String h ;

   //变动开始日
    private String j ;

}

