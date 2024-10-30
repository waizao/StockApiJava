package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChuQuanChuXi implements Serializable {

   //股票代码
    private String code ;

   //股票名称
    private String name ;

   //除权除息日期
    private String tdate ;

   //若pgbl>0，则配股：每10股配（10*pgbl）股，配股价格（pgjg）元
    private float pgbl ;

   //配股价格
    private float pgjg ;

   //若pxbl>0，则派息：每10股派（10*pxbl）元
    private float pxbl ;

   //若sgbl>0，则送股：每10股送（10*sgbl）股
    private float sgbl ;

   //除权出息类型，按位与计算。（1&cqcxtype）==1，派息;（2&cqcxtype）==1，送股;（8&cqcxtype）==1，配股;（16&cqcxtype）==1，增发;
    private float cqcxtype ;

   //若zfbl>0，则增发：（zfgs）万股;增发价格（zfjg）元
    private float zfbl ;

   //增发股数（万股）
    private float zfgs ;

   //增发价格（元）
    private float zfjg ;

}

