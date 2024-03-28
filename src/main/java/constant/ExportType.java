package constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Administrator
 */

@AllArgsConstructor
@ToString
public enum ExportType {
    String_Txt("Txt字符串", 0),
    String_Json("Json字符串", 1),
    File_Txt("Txt文件", 2),
    File_JSON("Json文件", 3),
    File_Csv("Csv文件", 4),
    String_DataFrame("DataFrame格式", 5);

    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private int type;
}
