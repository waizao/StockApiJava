package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class HSGTHistory implements Serializable {

   //市场类别
    private int mtype ;

   //交易日期
    private String tdate ;

   //当日资金流入
    private float drzjlr ;

   //当日余额
    private float drye ;

   //历史累计净买额
    private float lsljjme ;

   //当日成交净买额
    private float drcjjme ;

   //买入成交额
    private float mrcje ;

   //卖出成交额
    private float mccje ;

   //领涨股代码
    private String lcgcode ;

   //领涨股名称
    private String lcg ;

   //领涨股涨跌幅
    private float lcgzdf ;

   //上证指数
    private float szzs ;

   //上证指数涨跌幅
    private float szzfzdf ;

}

