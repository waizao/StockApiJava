package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class TSStockPosition implements Serializable {

   //股票代码
    private String code ;

   //股票名称
    private String name ;

   //基金公布持仓季度
    private String tdate ;

   //持仓该股票的基金个数
    private int fundnum ;

   //基金持该股票总市值（万元）
    private float fundsz ;

   //基金持有该股票总股数（万股）
    private float fundcgs ;

   //基金持有该股票比例(持有股数/流通股数)
    private float fundbl ;

   //流通股本（万股）
    private float ltgb ;

   //总股本（万股）
    private float zgb ;

   //流通市值（万元）
    private float ltsz ;

   //总市值（万元）
    private float zsz ;

   //上市日期
    private String ssdate ;

}

