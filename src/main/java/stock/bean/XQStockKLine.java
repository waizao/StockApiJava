package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class XQStockKLine implements Serializable {

   //股票代码
    private String code ;

   //股票名称
    private String name ;

   //K线类别
    private int ktype ;

   //复权信息
    private int fq ;

   //交易时间
    private String tdate ;

   //开盘价
    private float open ;

   //收盘价
    private float close ;

   //最高价
    private float high ;

   //最低价
    private float low ;

   //涨跌幅
    private float zdf ;

   //成交量
    private float cjl ;

   //成交额
    private float cje ;

   //换手率
    private float hsl ;

}

