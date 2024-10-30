package constant;

import lombok.Getter;
import lombok.Setter;

/**
 * 资产大类
 */
public enum KLineType {
    Minute_1("1分钟", 1),
    Minute_5("5分钟", 5),
    Minute_30("30分钟", 30),
    Minute_60("60分钟", 60),
    Day("日线", 101),
    Week("周线", 102),
    Month("月线", 103);
    @Setter
    @Getter
    private final String name;
    @Setter
    @Getter
    private final int type;

    KLineType(String name, int type) {
        this.name = name;
        this.type = type;
    }
}
