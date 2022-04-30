package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReportFenhong implements Serializable {

   //股票代码
    private String code ;

   //股票名称
    private String name ;

   //报告日期
    private String tdate ;

   //方案进度
    private String assignprogress ;

   //每股收益(元)
    private float basiceps ;

   //股权登记日，前10日涨幅(%)
    private float bd10closeadjchrate ;

   //送转股份-送转总比例
    private float bonusitratio ;

   //送转股份-送股比例
    private float bonusratio ;

   //送转股份-转股比例
    private float itratio ;

   //每股净资产(元)
    private float bvps ;

   //预案公告日，后10日涨幅(%)
    private float d10closeadjchrate ;

   //除权除息日，后30日涨幅(%)
    private float d30closeadjchrate ;

   //股权登记日
    private String equityrecorddate ;

   //除权除息日
    private String exdividenddate ;

   //已除权天数(天)
    private int exdividenddays ;

   //最新公告日期
    private String noticedate ;

   //每股公积金(元)
    private float percapitalreserve ;

   //每股未分配利润(元)
    private float perunassignprofit ;

   //预案公告日
    private String plannoticedate ;

   //净利润同比增长(%)
    private float pnpyoyratio ;

   //现金分红-比例
    private float pretaxbonusrmb ;

   //现金分红-股息率(%)
    private float dividentratio ;

   //公布日期
    private String publishdate ;

   //代码简写
    private String secucode ;

   //总股本(元)
    private float totalshares ;

}

