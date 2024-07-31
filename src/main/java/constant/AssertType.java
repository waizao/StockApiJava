package constant;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 资产大类
 */ public enum AssertType {
    Stock_HS_A("沪深A股", 1), Stock_HS_B("沪深B股", 2), Stock_HK("港股", 3), Stock_USA("美股", 4), Stock_GOLD("黄金", 5), Stock_RATE("汇率", 6), Stock_REITS("Reits", 7),
    Index_HS("沪深京指数", 10), Index_HK("香港指数", 11), Index_QQ("全球指数", 12), Index_Bond("债券指数", 13), Index_CF("重要指数", 14), Index_SW("申万指数", 15),

    FUND_CN("场内基金", 20), FUND_CW("场外基金", 21), BOND_HS("沪深债券", 30),

    BK_SW_ONE("申万-一级行业", 37), BK_SW_TWO("申万-二级行业", 38), BK_SW_THREE("申万-三级行业", 39),

    BK_HY("东财-行业板块", 40), BK_GN("东财-概念板块", 41), BK_DY("东财-地域板块", 42), BK_THS_HY("同花顺-行业板块", 47), BK_THS_GN("同花顺-概念板块", 48), BK_THS_DY("同花顺-地域板块", 49),

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
