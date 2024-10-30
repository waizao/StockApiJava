package stock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class GZStock implements Serializable {

   //股票代码
    private String code ;

   //市场名称
    private String name ;

   //股票类型，1：深证股票，2：上证股票，3：北证股票，4：港股
    private int stype ;

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

   //总市值（元）
    private float total_market_cap ;

   //总股本（股）
    private float total_shares ;

   //内部代码
    private String board_code ;

   //板块名称
    private String board_name ;

   //涨跌幅（%）
    private float change_rate ;

   //收盘价
    private float close_price ;

   //流通市值（元）
    private float notlimited_marketcap_a ;

   //板块代码
    private String orig_board_code ;

}

