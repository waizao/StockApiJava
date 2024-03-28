package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class JiGouDiaoYanXiangXi implements Serializable {

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

   //接待人员
    private String receptionist ;

   //接待地点
    private String receiveplace ;

   //公告日期
    private String noticedate ;

   //代码简称
    private String secucode ;

   //接待方式
    private String receivewayexplain ;

   //接待开始日期
    private String receivestartdate ;

   //接待结束日期
    private String receiveenddate ;

   //调研时间范围
    private String receivetimeexplain ;

   //序号
    private int numbernew ;

}

