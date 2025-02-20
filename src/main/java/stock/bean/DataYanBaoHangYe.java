package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataYanBaoHangYe implements Serializable {

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

   //行业名称
    private String industryname ;

   //评级
    private String emratingname ;

}

