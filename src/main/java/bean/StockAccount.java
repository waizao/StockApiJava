package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class StockAccount implements Serializable {

   //数据日期
    private String sdate ;

   //新增投资者数量（万户）
    private float xzsl ;

   //新增投资者环比增长
    private float xzhb ;

   //新增投资者同比增长
    private float xztb ;

   //期末投资者总量（万户）
    private float qmsl ;

   //期末投资者A股账号（万户）
    private float qmsla ;

   //期末投资者B股账号（万户）
    private float qmslb ;

   //沪深总市值（亿元）
    private float hszsz ;

   //沪深户均市值（万元）
    private float hjzsz ;

   //上证指数收盘
    private float szzs ;

   //上证指数涨跌幅
    private float szzdf ;

}

