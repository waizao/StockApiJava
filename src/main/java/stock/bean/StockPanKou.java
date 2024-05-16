package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class StockPanKou implements Serializable {

   //股票代码
    private String code ;

   //股票名称
    private String name ;

   //交易时间
    private String tdate ;

   //开盘价
    private float open ;

   //昨收价
    private float yclose ;

   //现价
    private float price ;

   //今日最高价
    private float high ;

   //今日最低价
    private float low ;

   //竞买价，即“买一”报价（元）
    private float bid ;

   //竞卖价，即“卖一”报价（元）
    private float ask ;

   //成交量（股）
    private float v ;

   //成交金额（元）
    private float e ;

   //委买一（量，单位：手）
    private float b1v ;

   //委买一（价，单位：元）
    private float b1p ;

   //委买二（量，单位：手）
    private float b2v ;

   //委买二（价，单位：元）
    private float b2p ;

   //委买三（量，单位：手）
    private float b3v ;

   //委买三（价，单位：元）
    private float b3p ;

   //委买四（量，单位：手）
    private float b4v ;

   //委买四（价，单位：元）
    private float b4p ;

   //委买五（量，单位：手）
    private float b5v ;

   //委买五（价，单位：元）
    private float b5p ;

   //委卖一（量，单位：手）
    private float s1v ;

   //委卖一（价，单位：元）
    private float s1p ;

   //委卖二（量，单位：手）
    private float s2v ;

   //委卖二（价，单位：元）
    private float s2p ;

   //委卖三（量，单位：手）
    private float s3v ;

   //委卖三（价，单位：元）
    private float s3p ;

   //委卖四（量，单位：手）
    private float s4v ;

   //委卖四（价，单位：元）
    private float s4p ;

   //委卖五（量，单位：手）
    private float s5v ;

   //委卖五（价，单位：元）
    private float s5p ;

}

