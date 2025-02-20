package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataJiGouDiaoYanJiLv implements Serializable {

   //股票代码
    private String code ;

   //调研机构
    private String survey ;

   //调研日期
    private String tdate ;

   //股票名称
    private String name ;

   //机构类型
    private String orgtype ;

   //调研人员
    private String investigators ;

   //公告日期
    private String noticedate ;

   //代码简称
    private String secucode ;

   //机构调查详细内容，评估公司经营情况
    private String content ;

}

