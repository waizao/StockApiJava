package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class JiGouDiaoYanTongJi implements Serializable {

   //股票代码
    private String code ;

   //接待日期
    private String tdate ;

   //股票代码简称
    private String secucode ;

   //股票名称
    private String name ;

   //接待机构数量
    private int jgsum ;

   //接待方式
    private String receivewayexplain ;

   //接待人员
    private String receptionist ;

   //接待地点
    private String receiveplace ;

   //公告日期
    private String noticedate ;

}

