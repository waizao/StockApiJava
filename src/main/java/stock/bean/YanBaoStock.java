package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class YanBaoStock implements Serializable {

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

   //评级
    private String emratingname ;

   //股票代码
    private String code ;

   //股票名字
    private String stockname ;

   //行业
    private String indvinduname ;

   //预测后年每股收益
    private float predictnexttwoyeareps ;

   //预测后年市盈率
    private float predictnexttwoyearpe ;

   //预测明年每股收益
    private float predictnextyeareps ;

   //预测明年市盈率
    private float predictnextyearpe ;

   //预测今年每股收益
    private float predictthisyeareps ;

   //预测今年市盈率
    private float predictthisyearpe ;

}

