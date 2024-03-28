package constant;

import lombok.Getter;
import lombok.Setter;


/**
 * 资产大类
 */
public enum FqType {
    No("不复权", 0),
    Before("前复权", 1),
    After("后复权", 2);
    @Setter
    @Getter
    private final String name;
    @Setter
    @Getter
    private final int type;

    FqType(String name, int type) {
        this.name = name;
        this.type = type;
    }
}
