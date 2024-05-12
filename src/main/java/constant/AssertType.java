package constant;

import lombok.Getter;
import lombok.Setter;

/**
 * 资产大类
 */
public enum AssertType {
    Stock_HS_A("沪深A股", 1),
    Stock_HS_B("沪深B股", 2),
    Stock_HK("港股", 3),
    Stock_USA("美股", 4),
    Stock_GOLD("黄金", 5),
    Stock_RATE("汇率", 6),
    Stock_REITS("Reits", 7),
    Index_HS("沪深指数", 10),
    Index_HK("香港指数", 11),
    Index_QQ("全球指数", 12),
    Index_Bond("债券指数", 13),
    FUND_CN("场内基金", 20),
    FUND_CW("场外基金", 21),
    BOND_HS("沪深债券", 30),
    BK_HY("行业板块", 40),
    BK_GN("概念板块", 41),
    BK_DY("地域板块", 42),
    BK_ZJH("证监会板块", 43),
    QIHUO("期货", 50),

    COIN("加密货币", 60);
    @Setter
    @Getter
    private final String name;
    @Setter
    @Getter
    private final int type;

    AssertType(String name, int type) {
        this.name = name;
        this.type = type;
    }
}
