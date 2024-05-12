package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class StockKLine implements Serializable {

   //股票代码
    private String code ;

   //股票名称
    private String name ;

   //K线类别
    private int ktype ;

   //复权信息，除沪深京A股、B股、港股外，其余复权值默认为前复权
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

   //成交量
    private float cjl ;

   //成交额
    private float cje ;

   //振幅
    private float zf ;

   //涨跌幅
    private float zdf ;

   //涨跌额
    private float zde ;

   //换手率
    private float hsl ;

}

