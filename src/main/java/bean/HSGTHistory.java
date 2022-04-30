package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class HSGTHistory implements Serializable {

   //市场类别
    private int mtype ;

   //交易日期
    private String tdate ;

   //历史累计净买额
    private float accumdealamt ;

   //买入成交额
    private float buyamt ;

   //当日资金流入
    private float fundinflow ;

   //涨跌幅
    private float indexchangerate ;

   //上证指数
    private float indexcloseprice ;

   //领涨股
    private String leadstocksname ;

   //领涨股-涨跌幅
    private float lschangerate ;

   //当日成交净买额
    private float netdealamt ;

   //当日余额
    private float quotabalance ;

   //卖出成交额
    private float sellamt ;

}

