package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class HSGTBlockRank implements Serializable {

   //板块代码
    private String code ;

   //交易日期
    private String tdate ;

   //板块名称
    private String name ;

   //北向资金今日增持估计-占板块比
    private float addboardratio ;

   //北向资金今日增持估计-占北向资金比
    private float addhkratio ;

   //北向资金今日增持估计-市值
    private float addmarketcap ;

   //北向资金今日增持估计-市值增幅
    private float addratio ;

   //北向资金今日持股-占北向资金比
    private float boardhkratio ;

   //北向资金今日持股-占板块比
    private float hkboardratio ;

   //北向资金今日持股-市值
    private float hkvalue ;

}

