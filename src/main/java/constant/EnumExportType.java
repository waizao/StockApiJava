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
public enum EnumExportType {
    ExportType_String_Txt("Txt字符串", 0),
    ExportType_String_Json("Json字符串", 1),
    ExportType_File_Txt("Txt文件", 2),
    ExportType_File_JSON("Json文件", 3),
    ExportType_File_Csv("Csv文件", 4);
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private int type;
}
