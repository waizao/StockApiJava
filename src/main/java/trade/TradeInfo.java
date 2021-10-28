package trade;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class TradeInfo implements Serializable {

    private String code;

    private boolean isOpen;//交易是否结束

    private float buyPrice;//买入价格

    private float sellPrice;//卖出价格

    private LocalDate buyDate = LocalDate.now();//买入日期

    private LocalDate sellDate = LocalDate.now();//卖出日期
}
