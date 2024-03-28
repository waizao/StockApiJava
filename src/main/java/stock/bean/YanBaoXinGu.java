package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class YanBaoXinGu implements Serializable {

   //股票代码
    private String code ;

   //股票名字
    private String name ;

   //机构名称
    private String orgsname ;

   //公布日期
    private String tdate ;

   //作者
    private String researcher ;

   //标题
    private String title ;

   //研报内容
    private String content ;

   //研报PDF下载链接
    private String pdf ;

   //行业
    private String indvinduname ;

   //新股发行价
    private float newissueprice ;

   //上市日期
    private String newlistingdate ;

   //发行市盈率
    private float newpeissuea ;

   //申购日期
    private String newpurchasedate ;

}

