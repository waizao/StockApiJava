package trade.strategy;

import lombok.Data;

/**
 * 限制交易套利模型
 */
@Data
public class TradeStrategy {
    private String stockCode = "512980";//股票代码
    private String startTradeDate = "2000-05-05";//开始交易日期

    private int totalMoney = 5000;//交易资金量
    private int singleMoney = 350;//单笔交易资金量
    private int tradeTimes = 1;//每日最大交易次数，该参数和单笔交易资金量参数共同能控制风险，同时也影响盈利的速度。
    private double share = 2;//共享资金池扩大比例

    private double profitLine = 0.80;//止盈价格线

    private int tradeDays = 10;//交易周期
    private int sellPoint = 5;//上涨卖出点位
    private int buyPoint = 7;//下跌买入点位
}
