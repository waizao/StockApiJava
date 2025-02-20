package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataGZHangYe implements Serializable {

   //板块代码
    private String code ;

   //市场名称
    private String name ;

   //交易时间
    private String tdate ;

   //PE（TTM）：当前股价与前四季度每股收益总和的比值
    private float pe_ttm ;

   //PE（静）：当前股价与最新年报每股收益的比值
    private float pe_lar ;

   //市净率
    private float pb_mrq ;

   //PEG值：PE（TTM）与每股收益近3年复合增长率的比值
    private float peg_car ;

   //市现率（TTM）：当前股价与前四季度每股现金流量总和的比值
    private float pcf_ocf_ttm ;

   //市销率（TTM）：总市值与前四季度营业收入总和的比值
    private float ps_ttm ;

   //平均市值 （亿元）
    private float market_cap_vag ;

   //个股数量
    private float num ;

   //亏损家数
    private float loss_count ;

   //平均流通股本（股）
    private float free_shares_vag ;

   //平均流通市值（元）
    private float nomarketcap_a_vag ;

   //流通市值（元）
    private float notlimited_marketcap_a ;

   //总市值（元）
    private float total_market_cap ;

   //总股本（股）
    private float total_shares ;

   //平均股本（股）
    private float total_shares_vag ;

}

